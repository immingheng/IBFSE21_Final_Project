package ibf2021.springboot.models;

// Model of what I want to extract from shopee api call to be passed back to front-end
public class Listing {
    String image;
    String product_name;
    String description;
    int quantity;
    float price;

    public Listing() {
    }

    public Listing(String image, String product_name, String description, int quantity, float price) {
        this.image = image;
        this.product_name = product_name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Listing image(String image) {
        setImage(image);
        return this;
    }

    public Listing product_name(String product_name) {
        setProduct_name(product_name);
        return this;
    }

    public Listing description(String description) {
        setDescription(description);
        return this;
    }

    public Listing quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    public Listing price(float price) {
        setPrice(price);
        return this;
    }

}