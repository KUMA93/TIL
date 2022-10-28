# DELETE API

* 리소스를 삭제하는 메소드로 PathVariable이 사용 가능하다.
    ![DELETE SEND](../img/DeleteSend.png)
    
    ```java
    @DeleteMapping("/delete/{userId}")
        public void delete(@PathVariable String userId, @RequestParam String account) {
            System.out.println(userId);
            System.out.println(account);
        }
    ```
    ![DELETE CONSOLE](../img/DeleteConsole.png)

