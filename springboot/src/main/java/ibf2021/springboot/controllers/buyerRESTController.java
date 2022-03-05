package ibf2021.springboot.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2021.springboot.models.ScrapeResults;

@RestController
@RequestMapping(path = "/api/buyer")
public class buyerRESTController {

    @PostMapping(path = "/search")
    public ResponseEntity<List<ScrapeResults>> ScrapeFromWebUsingHTMLUnit() {
        return null;
    }

}
