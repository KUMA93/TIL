package ch06;

public class VIPCustomer extends Customer {

    private int agentID;
    double saleRatio;

//    public VIPCustomer() {
//        super(0, "no-name");
//        customerGrade = "VIP";
//        bonusRatio = 0.05;
//        saleRatio = 0.1;
//
//        System.out.println("VIPCustomer() call");
//    }

    public VIPCustomer(int customerID, String customerName) {
        super(customerID, customerName);

        customerGrade = "VIP";
        bonusRatio = 0.05;
        saleRatio = 0.1;

    }

    @Override
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;
        price -= (int)(price * saleRatio);

        return price;
    }

    public int getAgentID() {

        return agentID;
    }
}
