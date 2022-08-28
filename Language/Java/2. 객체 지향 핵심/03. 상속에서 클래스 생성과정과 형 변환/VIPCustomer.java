package ch03;

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

        System.out.println("VIPCustomer() call");
    }

    public int getAgentID() {

        return agentID;
    }
}
