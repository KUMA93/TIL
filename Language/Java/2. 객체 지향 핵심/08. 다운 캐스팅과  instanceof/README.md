# 08. 다운 캐스팅과 instanceof 

## 다운 캐스팅(downcasting)

- 업캐스팅된 클래스를 다시 원래의 타입으로 형 변환

- 하위 클래스로의 형 변환은 명시적으로 해야 함

```java
Customer vc = new VIPCustomer();              //묵시적
VIPCustomer vCustomer = (VIPCustomer)vc;      //명시적
```

## instanceof를 이용하여 인스턴스의 형 체크

- 원래 인스턴스의 형이 맞는지 여부를 체크하는 키워드 맞으면 true 아니면 false를 반환 함

AnimalTest.java
```java
public void testDownCasting(ArrayList<Animal> list) {
		
		for(int i =0; i<list.size(); i++) {
			Animal animal = list.get(i);
		
			if ( animal instanceof Human) {
				Human human = (Human)animal;
				human.readBooks();
			}
			else if( animal instanceof Tiger) {
				Tiger tiger = (Tiger)animal;
				tiger.hunting();
			}
			else if( animal instanceof Eagle) {
				Eagle eagle = (Eagle)animal;
				eagle.flying();
			}
			else {
				System.out.println("error");
			}
		
		}
}
```
## 다음 강의
[09. 추상 클래스 구현하기](../09.%20%EC%B6%94%EC%83%81%20%ED%81%B4%EB%9E%98%EC%8A%A4%EC%9D%98%20%EC%9D%98%EB%AF%B8%EC%99%80%20%EA%B5%AC%ED%98%84%ED%95%98%EB%8A%94%20%EB%B0%A9%EB%B2%95/)
