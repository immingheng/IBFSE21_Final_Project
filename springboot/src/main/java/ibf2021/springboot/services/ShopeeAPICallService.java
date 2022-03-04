package ibf2021.springboot.services;

import static ibf2021.springboot.utilities.SensitiveData.*;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ibf2021.springboot.models.Listing;

import org.apache.commons.codec.binary.Hex;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;

@Service
public class ShopeeAPICallService {

    private static final Logger logger = Logger.getLogger(ShopeeAPICallService.class.getName());

    public String authHashHMACSHA256(String RequestEndPoint, String rawHttpBody, String APIKey) {
        if (APIKey == null) {
            logger.warning("SHOPEE SECRET API KEY IS NOT SET!");
        }
        String baseString = "%s|%s".formatted(RequestEndPoint, rawHttpBody);
        logger.info("BASESTRING>> " + baseString);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(APIKey.getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            return Hex.encodeHexString((mac.doFinal(baseString.getBytes("UTF-8"))));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to compute HMAC-SHA256");
        }
    }

    // GET EPOCH TIME STAMP BASED ON SYSTEM MACHINE
    public long getCurrentEpochTime() {
        logger.info("Current EPOCH TIME IS >>>" + System.currentTimeMillis() / 1000);
        return System.currentTimeMillis() / 1000;
    }

    // Overloaded method to use hard-coded shop_id for development process
    public ResponseEntity<List<Listing>> getItemLists() {
        List<Listing> listings = new ArrayList<>();
        String URI = "https://partner.test-stable.shopeemobile.com/api/v1/items/get";
        JsonObject requestBody = Json.createObjectBuilder()
                .add("pagination_offset", 0)
                .add("pagination_entries_per_page", 100)
                .add("shopid", SHOPEE_SHOP_ID)
                .add("partner_id", SHOPEE_PARTNER_ID)
                .add("timestamp", getCurrentEpochTime())
                .build();
        logger.info("REQUEST BODY THAT WAS BUILT FOR getItemLists -> " + requestBody.toString());
        RequestEntity<String> req = RequestEntity.post(URI)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", authHashHMACSHA256(URI, requestBody.toString(), SHOPEE_TEST_SECRET_KEY))
                .body(requestBody.toString(), String.class);
        logger.info("REQUEST ENTITY WITH HEADER AND ETC TO POST TO SHOPEE" + req.toString());
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);
        logger.info("RESPONSE FROM SHOPEE API ->" + resp.toString());
        JsonObject data = ResponseEntity2JSON(resp);
        JsonArray jarray = data.getJsonArray("items");
        for (JsonValue item : jarray) {
            int item_id = item.asJsonObject().getInt("item_id");
            logger.info("item_id >> " + item_id);
            JsonObject itemDetail = ResponseEntity2JSON(getItemDetail(item_id)).getJsonObject("item");
            Listing listing = new Listing();
            listing.setImage(itemDetail.getJsonArray("images").get(0).toString());
            listing.setDescription(itemDetail.getString("description"));
            listing.setPrice(itemDetail.getJsonNumber("price").longValue());
            listing.setProduct_name(itemDetail.getString("name"));
            listing.setQuantity(itemDetail.getInt("stock"));
            listings.add(listing);
        }
        return ResponseEntity.ok().body(listings);
    }

    public JsonObject ResponseEntity2JSON(ResponseEntity<String> resp) {
        Reader reader = new StringReader(resp.getBody().toString());
        JsonReader JSONReader = Json.createReader(reader);
        JsonObject data = JSONReader.readObject();
        return data;
    }

    public ResponseEntity<String> getItemLists(String shop_id) {
        String URI = "https://partner.test-stable.shopeemobile.com/api/v1/items/get";
        JsonObject requestBody = Json.createObjectBuilder()
                .add("pagination_offset", 0)
                .add("pagination_entries_per_page", 100)
                .add("shopid", Integer.parseInt(shop_id))
                .add("partner_id", SHOPEE_PARTNER_ID)
                .add("timestamp", getCurrentEpochTime())
                .build();
        logger.info("REQUEST BODY THAT WAS BUILT FOR getItemLists -> " +
                requestBody.toString());
        RequestEntity<String> req = RequestEntity.post(URI)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", authHashHMACSHA256(URI, requestBody.toString(),
                        SHOPEE_TEST_SECRET_KEY))
                .body(requestBody.toString(), String.class);
        logger.info("REQUEST ENTITY WITH HEADER AND ETC TO POST TO SHOPEE" +
                req.toString());
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);
        logger.info("RESPONSE FROM SHOPEE API ->" + resp.toString());
        return resp;
    }

    // Method to call after getting entire item lists to extract item_id and obtain
    // entire item detail to be saved into DB
    public ResponseEntity<String> getItemDetail(int itemId) {
        String URI = "https://partner.test-stable.shopeemobile.com/api/v1/item/get";
        JsonObject requestBody = Json.createObjectBuilder()
                .add("item_id", itemId)
                .add("shopid", SHOPEE_SHOP_ID)
                .add("partner_id", SHOPEE_PARTNER_ID)
                .add("timestamp", getCurrentEpochTime())
                .build();
        logger.info("REQUEST BODY THAT WAS BUILT FOR getItemDetail -> " + requestBody.toString());
        RequestEntity<String> req = RequestEntity.post(URI)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", authHashHMACSHA256(URI, requestBody.toString(), SHOPEE_TEST_SECRET_KEY))
                .body(requestBody.toString(), String.class);
        logger.info("REQUEST ENTITY WITH HEADER AND ETC TO POST TO SHOPEE" + req.toString());
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);
        logger.info("RESPONSE FROM SHOPEE API ->" + resp.toString());
        return resp;
    }

}
