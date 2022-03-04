package ibf2021.springboot.utilities;

public class SensitiveData {

    public static final String SHOPEE_TEST_SECRET_KEY = System.getenv("SHOPEE_SECRET_KEY");
    // Shop ID is extracted when a shop give their permission for my use on their
    // shop details via Oauth2
    public static final int SHOPEE_SHOP_ID = 22595;
    // Partner_ID won't change
    public static final int SHOPEE_PARTNER_ID = 1006071;

}
