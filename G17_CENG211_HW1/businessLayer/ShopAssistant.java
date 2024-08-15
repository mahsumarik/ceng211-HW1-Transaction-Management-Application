package CENG211_Homeworks.G17_CENG211_HW1;

public class ShopAssistant {
    private int ID;
    private String Name;
    private String Surname;
    private String Phone_number;
    private int Seniority;
    private int weeklySalary;
    private double commission;

    public ShopAssistant(int ID, String name, String surname, String phone_number) {
        this.ID = ID;
        Name = name;
        Surname = surname;
        Phone_number = phone_number;
        this.Seniority=(int)(Math.random()*16);
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }


    public String getSurname() {
        return Surname;
    }


    public String getPhone_number() {
        return Phone_number;
    }


    public int getSeniority() {
        return Seniority;
    }


    public int getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(int weeklySalary) {
        this.weeklySalary = weeklySalary;
    }


    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "ID:"+ getID()+ " Name:"+getName()+" Surname:"+getSurname()+" Phone Number:"+getPhone_number()+ " Seniority:"+getSeniority()+" weekly salary:"+getWeeklySalary();
    }

}
