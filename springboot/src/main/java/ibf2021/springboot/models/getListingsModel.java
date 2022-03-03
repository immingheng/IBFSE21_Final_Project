package ibf2021.springboot.models;

public class getListingsModel {
    int item_id;
    int shop_id;
    long update_time;
    String status;
    String item_sku;
    String[] variations;
    boolean is_2tier_item;
    String[] tenures;

    public getListingsModel() {
    }

    public getListingsModel(int item_id, int shop_id, long update_time, String status, String item_sku,
            String[] variations, boolean is_2tier_item, String[] tenures) {
        this.item_id = item_id;
        this.shop_id = shop_id;
        this.update_time = update_time;
        this.status = status;
        this.item_sku = item_sku;
        this.variations = variations;
        this.is_2tier_item = is_2tier_item;
        this.tenures = tenures;
    }

    public int getItem_id() {
        return this.item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getShop_id() {
        return this.shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getItem_sku() {
        return this.item_sku;
    }

    public void setItem_sku(String item_sku) {
        this.item_sku = item_sku;
    }

    public String[] getVariations() {
        return this.variations;
    }

    public void setVariations(String[] variations) {
        this.variations = variations;
    }

    public boolean isIs_2tier_item() {
        return this.is_2tier_item;
    }

    public boolean getIs_2tier_item() {
        return this.is_2tier_item;
    }

    public void setIs_2tier_item(boolean is_2tier_item) {
        this.is_2tier_item = is_2tier_item;
    }

    public String[] getTenures() {
        return this.tenures;
    }

    public void setTenures(String[] tenures) {
        this.tenures = tenures;
    }

    public getListingsModel item_id(int item_id) {
        setItem_id(item_id);
        return this;
    }

    public getListingsModel shop_id(int shop_id) {
        setShop_id(shop_id);
        return this;
    }

    public getListingsModel update_time(long update_time) {
        setUpdate_time(update_time);
        return this;
    }

    public getListingsModel status(String status) {
        setStatus(status);
        return this;
    }

    public getListingsModel item_sku(String item_sku) {
        setItem_sku(item_sku);
        return this;
    }

    public getListingsModel variations(String[] variations) {
        setVariations(variations);
        return this;
    }

    public getListingsModel is_2tier_item(boolean is_2tier_item) {
        setIs_2tier_item(is_2tier_item);
        return this;
    }

    public getListingsModel tenures(String[] tenures) {
        setTenures(tenures);
        return this;
    }

}
