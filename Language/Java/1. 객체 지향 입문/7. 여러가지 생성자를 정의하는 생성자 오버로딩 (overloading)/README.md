# 07. 여러가지 생성자를 정의하는 생성자 오버로딩 (overloading)

## 생성자 정의 하기

- 생성자를 구현해서 사용할 수 있음

- 클래스에 생성자를 따로 구현하면 기본 생성자 (default constructor)는 제공되지 않음

- 생성자를 호출하는 코드(client 코드)에서 여러 생성자 중 필요에 따라 호출해서 사용할 수 있음

UserInfo.java
```java
public class UserInfo {

	public String userId;
	public String userPassWord;
	public String userName;
	public String userAddress;
	public String phoneNumber;
	
	public UserInfo(){}
	
	public UserInfo(String userId, String userPassWord, String userName) {
		this.userId = userId;
		this.userPassWord = userPassWord;
		this.userName = userName;
	}
	
	public String showUserInfo() {
		return "고객님의 아이디는 " + userId + "이고, 등록된 이름은 " + userName + "입니다."; 
	}
}
```

UserInfoTest.java
```java
public class UserInfoTest {

	public static void main(String[] args) {

		UserInfo userLee = new UserInfo();
		userLee.userId = "a12345";
		userLee.userPassWord = "zxcvbn12345";
		userLee.userName = "Lee";
		userLee.phoneNumber = "01034556699";
		userLee.userAddress = "Seoul, Korea";
		
		System.out.println(userLee.showUserInfo());
		
		UserInfo userKim = new UserInfo("b12345", "09876mnbvc", "Kim");
		System.out.println(userKim.showUserInfo());
	}
}
```


## 다음 강의 
[08. 복습해봅시다 (객체 구현하기)](../8.%20%EB%B3%B5%EC%8A%B5%ED%95%B4%EB%B4%85%EC%8B%9C%EB%8B%A4%20(%EA%B0%9D%EC%B2%B4%20%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0)/)