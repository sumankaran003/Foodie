package in.karan.suman.foodka.Model;

/**
 * Created by Suman on 12-Dec-17.
 */

public class Food {

    private String name,image,price,description,discount,menuId;

    public Food() {
    }

    public Food(String name, String image, String price, String description, String discount, String menuId) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
