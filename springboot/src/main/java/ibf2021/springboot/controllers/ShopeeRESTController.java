package ibf2021.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2021.springboot.services.ShopeeAPICallService;

@RestController
@RequestMapping(path = "/api/shopee", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShopeeRESTController {

    @Autowired
    ShopeeAPICallService shopeeSvc;

    @GetMapping(path = "listings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllListing() {
        // Requires a HTTP HEADER - "Authorization" with SHA256 Hash of
        // (Endpoint URL|Raw Http Request Body and App Secret Key)

        // URL END POINT https://partner.test-stable.shopeemobile.com/api/v1/items/get
        // Request Params:
        // Pagination Offset : default = uint 0 (For offset)
        // Pagination_entries_per_page: uint max = 100 (How many listing to extract at
        // once)
        // partner_id : MY SHOPEE DEVELOPER APP ID
        // shop_id: This is either made known extracted from query parameter upon a
        // shopee seller granting permission to developer via Oauth2 flow using
        // Shopee's authorisation end point
        // Timestamp: time in epoch time
        return shopeeSvc.getItemLists();
    }

    @PostMapping(path = "/addListing", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addNewListing() {
        return null;
    }
}
