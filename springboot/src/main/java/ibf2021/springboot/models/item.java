package ibf2021.springboot.models;

public class Item {
    private String product_name;
    private String category_name;
    private String product_cover_image;
    private String product_image1;
    private String product_image2;
    private String product_image3;
    private String product_image4;
    private String product_image5;
    private String product_image6;
    private String product_image7;
    private String product_image8;
    private String product_description;
    private String brand;
    private String color;
    private int recommended_age;
    private String warranty_type;
    private String material;
    private float price;
    private int stock;
    private float product_weight;
    private String preorder;
    private String condition;

    public Item() {
    }

    public Item(String product_name, String category_name, String product_cover_image, String product_image1,
            String product_image2, String product_image3, String product_image4, String product_image5,
            String product_image6, String product_image7, String product_image8, String product_description,
            String brand, String color, int recommended_age, String warranty_type, String material, float price,
            int stock, float product_weight, String preorder, String condition) {
        this.product_name = product_name;
        this.category_name = category_name;
        this.product_cover_image = product_cover_image;
        this.product_image1 = product_image1;
        this.product_image2 = product_image2;
        this.product_image3 = product_image3;
        this.product_image4 = product_image4;
        this.product_image5 = product_image5;
        this.product_image6 = product_image6;
        this.product_image7 = product_image7;
        this.product_image8 = product_image8;
        this.product_description = product_description;
        this.brand = brand;
        this.color = color;
        this.recommended_age = recommended_age;
        this.warranty_type = warranty_type;
        this.material = material;
        this.price = price;
        this.stock = stock;
        this.product_weight = product_weight;
        this.preorder = preorder;
        this.condition = condition;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategory_name() {
        return this.category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getProduct_cover_image() {
        return this.product_cover_image;
    }

    public void setProduct_cover_image(String product_cover_image) {
        this.product_cover_image = product_cover_image;
    }

    public String getProduct_image1() {
        return this.product_image1;
    }

    public void setProduct_image1(String product_image1) {
        this.product_image1 = product_image1;
    }

    public String getProduct_image2() {
        return this.product_image2;
    }

    public void setProduct_image2(String product_image2) {
        this.product_image2 = product_image2;
    }

    public String getProduct_image3() {
        return this.product_image3;
    }

    public void setProduct_image3(String product_image3) {
        this.product_image3 = product_image3;
    }

    public String getProduct_image4() {
        return this.product_image4;
    }

    public void setProduct_image4(String product_image4) {
        this.product_image4 = product_image4;
    }

    public String getProduct_image5() {
        return this.product_image5;
    }

    public void setProduct_image5(String product_image5) {
        this.product_image5 = product_image5;
    }

    public String getProduct_image6() {
        return this.product_image6;
    }

    public void setProduct_image6(String product_image6) {
        this.product_image6 = product_image6;
    }

    public String getProduct_image7() {
        return this.product_image7;
    }

    public void setProduct_image7(String product_image7) {
        this.product_image7 = product_image7;
    }

    public String getProduct_image8() {
        return this.product_image8;
    }

    public void setProduct_image8(String product_image8) {
        this.product_image8 = product_image8;
    }

    public String getProduct_description() {
        return this.product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRecommended_age() {
        return this.recommended_age;
    }

    public void setRecommended_age(int recommended_age) {
        this.recommended_age = recommended_age;
    }

    public String getWarranty_type() {
        return this.warranty_type;
    }

    public void setWarranty_type(String warranty_type) {
        this.warranty_type = warranty_type;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getProduct_weight() {
        return this.product_weight;
    }

    public void setProduct_weight(float product_weight) {
        this.product_weight = product_weight;
    }

    public String getPreorder() {
        return this.preorder;
    }

    public void setPreorder(String preorder) {
        this.preorder = preorder;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}
