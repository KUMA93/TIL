package ch08;

public class Order {
    public String orderId;
    public String phoneNumber;
    public String address;
    public String orderDate;
    public int orderTime;
    public int orderPrice;
    public String menuNumber;

    public Order( String orderId, String phoneNumber, String address, int orderTime, int orderPrice ) {
        this.orderId = orderId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderTime = orderTime;
        this.orderPrice = orderPrice;
        this.orderDate = orderId.substring(0, 8);
        this.menuNumber = orderId.substring(8, 12);
    }

    public void showOrderInfo() {
        System.out.println("주문 접수 번호 : " + orderId);
        System.out.println("주문 핸드폰 번호 : " + phoneNumber);
        System.out.println("주문 집 주소 : " + address);
        System.out.println("주문 날짜 : " + orderDate);
        System.out.println("주문 시간 : " + orderTime);
        System.out.println("주문 가격 : " + orderPrice);
        System.out.println("메뉴 번호 : " + menuNumber);
    }
}
