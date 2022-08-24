# 19. 복습해봅시다 (static과 싱클톤 패턴)

## 설명에 따른 객체를 구현하여 테스트 코드가 실행되도록 구현하기

    자동차 공장이 있습니다. 자동차 공장은 유일한 객체이고, 이 공장에서 생산되는 자동차는 제작될 때마다 고유의 번호가 부여됩니다. 
    자동차 번호가 10001부터 시작되어 자동차가 생산될 때마다 10002, 10003 이렇게 번호가 붙도록 자동차 공장 클래스, 자동차 클래스를 구현하세요
    다음 CarFactoryTest.java 테스트 코드가 수행 되도록 합니다.


CarFactoryTest.java
```java
public class CarFactoryTest {

	public static void main(String[] args) {
		CarFactory factory = CarFactory.getInstance();
		Car mySonata = factory.createCar();
		Car yourSonata = factory.createCar();
		
		System.out.println(mySonata.getCarNum());     //10001 출력
		System.out.println(yourSonata.getCarNum());   //10002 출력
	}
}
```
## 다음 강의
[20. 자료를 순차적으로 한꺼번에 관리하는 방법 - 배열(array)](../20.%20%EC%9E%90%EB%A3%8C%EB%A5%BC%20%EC%88%9C%EC%B0%A8%EC%A0%81%EC%9C%BC%EB%A1%9C%20%ED%95%9C%EA%BA%BC%EB%B2%88%EC%97%90%20%EA%B4%80%EB%A6%AC%ED%95%98%EB%8A%94%20%EB%B0%A9%EB%B2%95%20-%20%EB%B0%B0%EC%97%B4%20(array)/)