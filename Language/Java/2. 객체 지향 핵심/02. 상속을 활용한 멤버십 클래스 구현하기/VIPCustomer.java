package ch02;

public class VIPCustomer extends Customer {

    private int agentID;
    double saleRatio;

    public VIPCustomer() {

        customerGrade = "VIP";
        bonusRatio = 0.05;
        saleRatio = 0.1;
    }

    public int getAgentID() {
        return agentID;
    }
}
