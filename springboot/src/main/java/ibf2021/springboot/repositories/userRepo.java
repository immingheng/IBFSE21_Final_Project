package ibf2021.springboot.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static ibf2021.springboot.mySQL.SQL.*;

@Repository
public class UserRepo {

    @Autowired
    private JdbcTemplate template;

    public int addUser2mySQL(String email, String name, int shopee_shop_id) {
        // insert into user(name, email, shopee_shop_id) values (?, ? ,?)"
        return this.template.update(SQL_SAVE_USER_TO_MYSQL, name, email, shopee_shop_id);
    }

    public int getShopeeShopId(String email, String name) {
        // return this.template.queryForRowSet(sql)
        return 0;
    }

}
