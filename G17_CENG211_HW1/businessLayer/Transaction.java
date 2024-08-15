package CENG211_Homeworks.G17_CENG211_HW1;

import java.util.Arrays;

public class Transaction {
    private int ID;
    private Product[] productArray;
    private double totalPrice;
    private double transactionFee;


    public Transaction(int ID,  double totalPrice,Product[] productArray, double transactionFee) {
        this.ID = ID;
        this.productArray = productArray;
        this.totalPrice = totalPrice;
        this.transactionFee = transactionFee;
    }

    public int getID() {
        return ID;
    }


    public Product[] getProductArray() {
        return productArray;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTransactionFee() {
        return transactionFee;
    }


    @Override
    public String toString() {
        return "ID:"+ getID()+ "\nProduct Array:"+ Arrays.toString(getProductArray()) +"\nTotal Price:"+getTotalPrice()+ "\nTransaction Fee:"+getTransactionFee();
    }
}
