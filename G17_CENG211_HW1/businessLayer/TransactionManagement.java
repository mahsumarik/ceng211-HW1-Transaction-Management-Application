package CENG211_Homeworks.G17_CENG211_HW1;

public class TransactionManagement {

    private Transaction [][] transactions;

    FileIO fileIO;


    public TransactionManagement() {
        fileIO= new FileIO();
    }

    public Transaction[][] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[][] transactions) {
        this.transactions = transactions;
    }

    public Transaction[][] fillTransactionsToTransactionManagement(){
        Transaction [][] transactionsCopy= new Transaction[100][15];
        int id=0;
        for (int i =0;i<100;i++){
            for (int k=0;k<15;k++){
                Product[] products=getRandomProduct();
                double totalPrice=getTotalPrice(products);
                transactionsCopy[i][k]=new Transaction(id,totalPrice,products,getTransactionFee(totalPrice));
                id++;
            }
        }
        setTransactions(transactionsCopy);
        return getTransactions();
    }

    private Product[] getRandomProduct(){
        Product [] products1 =fileIO.readProductItems();
        Product[] products= new Product[3];
        for (int k=0;k<3;k++){
            int random=(int)(Math.random()*products1.length);
            products[k]=products1[random];
        }
        return products;
    }

    private double getTotalPrice(Product[] products){
        double totalPrice=0;
        for (int i=0;i<products.length;i++){
            totalPrice+=products[i].getPrice()*products[i].getQuantity();
        }
        return totalPrice;
    }

    private double getTransactionFee(double price){
        if(price<=499){
            return( double)price/100;
        } else if (price<=799) {
            return (double)(price/100)*3;
        }else if (price<=999){
            return (double)(price/100)*5;
        }else{
            return (double)(price/100)*9;
        }
    }




}
