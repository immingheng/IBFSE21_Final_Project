package ibf2021.springboot.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2021.springboot.models.ScrapeResults;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/buyer")
public class buyerRESTController {

    @GetMapping(path = "/search")
    public ResponseEntity<List<ScrapeResults>> ScrapeFromWebUsingHTMLUnit() {
        return null;
    }

}
