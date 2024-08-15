package CENG211_Homeworks.G17_CENG211_HW1;

public class SalaryManagement {
    private ShopAssistant [] shopAssistants;

    FileIO fileIO;

    TransactionManagement transactionManagement;

    public SalaryManagement(){
        fileIO=new FileIO();
        transactionManagement= new TransactionManagement();
    }

    public ShopAssistant[] getShopAssistants() {
        return shopAssistants;
    }

    public void setShopAssistants(ShopAssistant[] shopAssistants) {
        this.shopAssistants=shopAssistants;
    }

    public ShopAssistant[] fillShopAssistantToSalaryManagement(){
        Transaction[][] transactions= transactionManagement.fillTransactionsToTransactionManagement();
        ShopAssistant [] shopAssistantsCopy=fileIO.readShopAssistantItems();
        for (int i=0;i< shopAssistantsCopy.length;i++){
            int seniority=shopAssistantsCopy[i].getSeniority();
            int weeklySalary=getWeeklySalaryBasisToAssistant(seniority);
            double totalRevenueFromOneAssistant=totalRevenueFromOneAsisstant(transactions[i]);
            double commission=getCommission(totalRevenueFromOneAssistant);
            shopAssistantsCopy[i].setWeeklySalary(weeklySalary);
            shopAssistantsCopy[i].setCommission(commission);
        }
        setShopAssistants(shopAssistantsCopy);
        return getShopAssistants();
    }

    public int getWeeklySalaryBasisToAssistant(int seniority){
        if (seniority<1){
            return 1500;
        } else if (seniority <3) {
            return 2000;
        } else if (seniority<5) {
            return 2500;
        }else{
            return 3000;
        }
    }

    public double getCommission(double totalRevenueFromOneAssistant){
        double commission;
        if (totalRevenueFromOneAssistant>7500){
            commission=(totalRevenueFromOneAssistant*3)/100;
        }else{
            commission=(totalRevenueFromOneAssistant*1)/100;
        }
        return commission;
    }

    public  double totalRevenueFromOneAsisstant(Transaction[] transactionsCopy){
        int i=0;
        double totalRevenueFromOneAsisstant=0;
        for (int k=0;k<15;k++){
            totalRevenueFromOneAsisstant+=transactionsCopy[k].getTotalPrice()+transactionsCopy[k].getTransactionFee();
        }
        return totalRevenueFromOneAsisstant;
    }
}
