package ibf2021.springboot.services;

import static ibf2021.springboot.utilities.SensitiveData.*;

import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.google.common.hash.Hashing;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.apache.commons.codec.binary.Hex;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@Service
public class ShopeeAPICallService {

    private static final Logger logger = Logger.getLogger(ShopeeAPICallService.class.getName());

    public String authHashSHA256(String APIKey, String redirectURL) {
        String baseString = "%s%s".formatted(APIKey, redirectURL);
        // USING GOOGLE GUAVA LIBRARY TO HASH
        String sha256hex = Hashing.sha256()
                .hashString(baseString, StandardCharsets.UTF_8)
                .toString();
        logger.info("HASHED STRING TO ALLOW SELLER AUTHENTICATE MY APP >>> " + sha256hex);
        return sha256hex;
    }

    public String authHashHMACSHA256(String RequestEndPoint, String rawHttpBody, String APIKey) {
        if (APIKey == null) {
            logger.info("API KEY IS NOT SET!");
        }

        String baseString = "%s|%s".formatted(RequestEndPoint, rawHttpBody);
        logger.info("BASESTRING>> " + baseString);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(APIKey.getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            // logger.info(Base64.encodeBase64String((mac.doFinal(baseString.getBytes("UTF-8")))));
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

    public ResponseEntity<String> getItemLists() {
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
        // resp should return status code,
        // {items:[{item_id(number),shop_id(number),update_time(long epoch
        // time),status(STRING),item_sku(String),variation(Array),
        // is_2tier_item(Boolean), tenures(Array)}], request_id(HASH), more(boolean),
        // total(int)}
        return resp;
    }

}
