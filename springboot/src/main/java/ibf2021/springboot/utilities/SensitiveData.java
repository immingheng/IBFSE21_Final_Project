package ibf2021.springboot.utilities;

public class SensitiveData {

    public static final String SHOPEE_TEST_SECRET_KEY = System.getenv("SHOPEE_SECRET_KEY");
    // TODO - DO NOT HARD CODE THE SHOPID and PARTNER_ID IN (HAVE TO EXTRACT SHOP_ID
    // FROM AUTH TO IMPLEMENT MULTI-USER CASE)
    public static final int SHOPEE_SHOP_ID = 22595;
    public static final int SHOPEE_PARTNER_ID = 1006071;

}
