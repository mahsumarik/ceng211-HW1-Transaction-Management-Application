package CENG211_Homeworks.G17_CENG211_HW1;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Query {
    TransactionManagement transactionManagement;
    Transaction[][] transactions;
    SalaryManagement salaryManagement;
    ShopAssistant[] shopAssistants;

    public Query(){
        transactionManagement= new TransactionManagement();
        transactions=transactionManagement.fillTransactionsToTransactionManagement();

        salaryManagement= new SalaryManagement();
        shopAssistants=salaryManagement.fillShopAssistantToSalaryManagement();
    }

    private void highestSalaryShopAssistant(){
        double highestSalary=0;
        ShopAssistant shopAssistant=null;
        for (int i=0;i<100;i++){
            if (shopAssistants[i].getWeeklySalary()*4 + shopAssistants[i].getCommission() > highestSalary){
                highestSalary=shopAssistants[i].getWeeklySalary()*4 + shopAssistants[i].getCommission();
                shopAssistant=shopAssistants[i];
            }
        }
        NumberFormat nf=NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println("The highest salary shop assistant= "+"{"+"ID:"+ shopAssistant.getID()+","+" Name:"+shopAssistant.getName()+
                ","+" Seniority:"+shopAssistant.getSeniority()+","+" Weekly Salary:"+ shopAssistant.getWeeklySalary()+","+" Commission:"+
                nf.format(shopAssistant.getCommission())+","+" Salary:"+nf.format(highestSalary)+"}");
    }

    public void test(){                // You can check the compatibility of the arrays with the output with this method
        for (int i=0;i<100;i++){
            for (int k=0;k<15;k++){
                System.out.println(transactions[i][k].toString());
                System.out.println("******************************");
            }
        }

        for (int i=0;i<100;i++){
            System.out.println(shopAssistants[i].toString());
            System.out.println("************************************");
        }
    }


    private double highestTotalPriceTransaction(){
        double highestPrice=0;
        for (int i=0;i<100;i++){
            for (int k=0;k<15;k++){
                if (transactions[i][k].getTotalPrice()>highestPrice){
                    highestPrice=transactions[i][k].getTotalPrice();
                }
            }
        }
        return highestPrice;
    }

    private String mostExpensiveProductInLowestPriceTransaction(){
        double lowestPrice=10000000;
        Transaction lowestTransaction = null;
        int mostExpensiveProduct=0;
        String ProductName=null;
        for (int i=0;i<100;i++){
            for (int k=0;k<15;k++){
                if (transactions[i][k].getTotalPrice()<lowestPrice){
                    lowestPrice=transactions[i][k].getTotalPrice();
                    lowestTransaction=transactions[i][k];
                }
            }
        }
        for (int i=0;i<lowestTransaction.getProductArray().length;i++){
            if (lowestTransaction.getProductArray()[i].getPrice()>mostExpensiveProduct){
                ProductName=lowestTransaction.getProductArray()[i].getProductName();
            }
        }
        return ProductName;
    }

    private double lowestTransactionFee(){
        double lowestTransactionFee=200.3;
        for (int i=0;i<100;i++){
            for (int k=0;k<15;k++){
                if (transactions[i][k].getTransactionFee()<lowestTransactionFee){
                    lowestTransactionFee=transactions[i][k].getTransactionFee();
                }
            }
        }
        return lowestTransactionFee;
    }


    private  double totalRevenue(){
        double totalRevenue=0;
        for (int i=0;i<100;i++){
            for (int k=0;k<15;k++){
                totalRevenue+=transactions[i][k].getTotalPrice()+transactions[i][k].getTransactionFee();
            }
        }
        return totalRevenue;
    }

    private double totalProfit(){
        double totalSalaryPaid=0;
        for(int i=0;i<100;i++){
            totalSalaryPaid += (shopAssistants[i].getWeeklySalary() * 4) + shopAssistants[i].getCommission();
        }
        return totalRevenue()-totalSalaryPaid;
    }


    public void showQueryOutputs(){
        NumberFormat nf=NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println("The highest total price transaction= "+nf.format(highestTotalPriceTransaction()));
        System.out.println("The most expensive product in the lowest price transaction= "+mostExpensiveProductInLowestPriceTransaction());
        System.out.println("The lowest transaction fee= "+nf.format(lowestTransactionFee()));
        highestSalaryShopAssistant();
        System.out.println("The total revenue= "+nf.format(totalRevenue()));
        System.out.println("The total proift= "+nf.format(totalProfit()));
    }

}
