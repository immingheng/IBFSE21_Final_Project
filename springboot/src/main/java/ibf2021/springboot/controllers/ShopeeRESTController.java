package ibf2021.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibf2021.springboot.models.Listing;
import ibf2021.springboot.services.ShopeeAPICallService;

@RestController
@RequestMapping(path = "/api/shopee", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShopeeRESTController {

    @Autowired
    ShopeeAPICallService shopeeSvc;

    @GetMapping(path = "listings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Listing>> getAllListing(@RequestParam String shop_id) {
        return shopeeSvc.getItemLists(shop_id);
    }

    // DEPRECATED - SANITISED THE VALUES BEFORE SENDING IT BACK TO THE CLIENT SIDE
    // @GetMapping(path = "listing/{itemId}", produces =
    // MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<String> getItemDetail(@PathVariable int itemId) {
    // return shopeeSvc.getItemDetail(itemId);
    // }

}
