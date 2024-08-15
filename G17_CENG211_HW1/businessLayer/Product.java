package CENG211_Homeworks.G17_CENG211_HW1;

public class Product {
    private int ID;
    private String productName;
    private double price;
    private int quantity;

    public Product(int ID, String productName, double price) {
        this.ID = ID;
        this.productName = productName;
        this.price = price;
        this.quantity= 1+(int)(Math.random()*10);
    }

    public int getID() {
        return ID;
    }

    public String getProductName() {
        return productName;
    }


    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    @Override
    public String toString() {
        return "ID:"+ getID()+ " Product Name:"+getProductName()+" Price:"+getPrice()+ " Quantity:"+getQuantity();
    }
}
