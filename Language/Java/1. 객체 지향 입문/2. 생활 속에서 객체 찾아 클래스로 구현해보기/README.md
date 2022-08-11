# 02. 생활 속에서 객체 찾아 클래스로 구현해 보기

## 객체를 찾아 봅시다

- 온라인 쇼핑몰에 회원 로그인을 하고 여러 판매자가 판매하고 있는 제품 중 하나를 골라 주문을 한다

- 아침에 회사에 가는 길에 별다방 커피숍에 들려 아이스 카페라떼를 주문했다

- 성적확인을 위해 학사 관리 시스템에 로그인 하여 수강 한 과목들의 성적을 확인했다


## 클래스는 객체의 청사진(blueprint) 입니다

- 객체의 속성은 클래스의 <b>멤버 변수(member variable)</b>로 선언 함

- 학생 클래스
```java
public class Student {

	int studentNumber;
	String studentName;
	int majorCode;
	String majorName;
	int grade;
}
```

- 주문 클래스
```java
public class Order {

	int orderId;
	String buyerId;
	String sellerId;
	int productId;
	String orderDate;
}
```

- 회원 클래스
```java
public class UserInfo {

	String userId;
	String userPassWord;
	String userName;
	String userAddress;
	int phoneNumber;
}
```

## 객체 지향 프로그램을 할 때는 

- 객체를 정의 하고

- 각 객체의 속성을 멤버 변수로 역할을 메서드로 구현하고

- 각 객체간의 협력을 구현합니다.

## 클래스 코딩하기

- 클래스는 대문자로 시작하는 것이 좋음

- 패키지는 소문자로 시작하는 것이 좋음

- java 파일 하나에 클래스는 여러 개가 있을 수 있지만, public 클래스는 하나이고, public 클래스와 .java 파일의 이름은 동일함

- camel notation 방식으로 명명 -> 변수같은 경우 소문자로 시작해서 단어의 첫글자만 대문자로 명명

## 다음 강의
[03. 함수와 메서드](../3.%20%ED%95%A8%EC%88%98%EC%99%80%20%EB%A9%94%EC%84%9C%EB%93%9C/)