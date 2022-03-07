package ibf2021.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2021.springboot.models.User;
import ibf2021.springboot.services.AuthService;
import static ibf2021.springboot.mySQL.SQL.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class authenticationRESTController {

    private static final Logger logger = Logger.getLogger(authenticationRESTController.class.getName());

    @Autowired
    JdbcTemplate template;

    @Autowired
    AuthService authSvc;

    @GetMapping(path = "/user/shopee_shop_id")
    public ResponseEntity<Integer> getShopeeShopID(@RequestHeader("authorization") String jwt) {
        logger.info(jwt);
        User user = authSvc.extractUserFromJWT(jwt);
        logger.info(user.toString());
        try {
            SqlRowSet rs = template.queryForRowSet(SQL_CHECK_USER_EXISTS, user.getEmail());
            rs.next();
            int shopee_shop_id = rs.getInt("shopee_shop_id");
            logger.info("SHOPEE_SHOP_ID IS " + shopee_shop_id);
            return ResponseEntity.ok().body(shopee_shop_id);

        } catch (Exception e) {
            e.printStackTrace();
            logger.info("USER DOES NOT HAVE A SHOPEE LINKED IN THE DATABASE.");
            return ResponseEntity.ok().body(0);
        }
    }

}
