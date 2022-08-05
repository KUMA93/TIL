## 개요
* 기본적으로 HTML은 코드 가독성 향상을 위해 줄 바꿈을 해도 줄 바꿈이 화면에 출력되지 않는다. 
* 줄 바꿈을 하려면 직접 줄 바꿈을 한다는 명령을 적어 주어야 하며, HTML에서는 <br>를 통하여 줄바꿈을 한다.

## 사용법
* 첫번째줄〈br〉두번째줄
* 예제
    ```html
    <html>
        <body>
            the
            first
            line<br>
            the second line
        </body>
    </html>
    ```
    ```
    the first line
    the second line
    ```
## 그 외
* 실제 줄바꿈이 그대로 반영되게 하고 싶을 때 〈pre〉태그를 사용하면 된다.
* 〈pre〉태그는 줄바꿈 뿐만 아니라 띄어쓰기, 탭 등 원래 무시되던 문자들이 출력되게 된다.