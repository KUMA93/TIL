# Object Mapper
* Object Mapper는 `Text형태의 JSON을 Object로`, `Object를 Text형태의 JSON으로 바꿔준다`.

## Text형태의 JSON을 Object로 바꿀 때
* object mapper가 get method를 활용한다. -> 해당 클래스에 getter 필요
    ```java
    var user = new User("steve", 10, "010-1111-2222");
    var text = objectMapper.writeValueAsString(user);
    System.out.println(text);
    ```
    ```
    {"name":"steve","age":10,"phone_number":"010-1111-2222"}
    ```
* 해당 클래스에 메소드를 만들 때 get을 붙이면 serialize 에러가 발생한다. -> get이 메소드명에서 빠져야 한다.

## Object를 Text형태의 JSON으로 바꿀 때
* object mapper가 default 생성자를 필요로 한다.
    ```java
    var objectUser = objectMapper.readValue(text, User.class);
    System.out.println(objectUser);
    ```
    ```
    User{name='steve', age=10, phoneNumber='010-1111-2222'}
    ```