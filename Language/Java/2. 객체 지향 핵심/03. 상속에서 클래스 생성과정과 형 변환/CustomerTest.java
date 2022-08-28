package ch03;

public class CustomerTest {
    public static void main(String[] args) {

        Customer customerLee = new Customer(10010, "이순신");
//        customerLee.setCustomerName("이순신");
//        customerLee.setCustomerID(10010);
        customerLee.bonusPoint = 1000;
        System.out.println(customerLee.showCustomerInfo());

        VIPCustomer customerKim = new VIPCustomer(10020, "김유신");
//        customerKim.setCustomerName("김유신");
//        customerKim.setCustomerID(10020);
        customerKim.bonusPoint = 10000;
        System.out.println(customerKim.showCustomerInfo());

        Customer vc = new VIPCustomer(12345, "noname");

        // vc.getAgentID(); -> VIPCustomer 클래스의 모든 멤버 변수에 대한 메모리는 생성되었지만 변수 타입자체는 Customer이므로 getAgentID와 같은 메서드는 사용 불가능
    }
}
