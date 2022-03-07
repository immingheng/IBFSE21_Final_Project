package ibf2021.springboot.mySQL;

public class SQL {

    public static final String SQL_SAVE_USER_TO_MYSQL = "insert ignore into user(name, email, shopee_shop_id) values (?, ? ,?)";

    public static final String SQL_CHECK_USER_EXISTS = "select shopee_shop_id from user where email = ?";

}