package ch15;

public class CustomerTest {
    public static void main(String[] args) {

        Customer customer = new Customer();
        System.out.println("===== customer =====");
        customer.buy();
        customer.sell();
        customer.order();
        customer.hello();

        Buy buyer = customer;
        System.out.println("===== buyer < customer =====");
        buyer.buy();
        buyer.order();

        Sell seller = customer;
        System.out.println("===== seller < customer =====");
        seller.sell();
        seller.order();
    }
}