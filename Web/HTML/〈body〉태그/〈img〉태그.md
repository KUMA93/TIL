## 개요
* 〈img〉 태그는 이미지를 삽입하는 태그로, src 속성을 통해 이미지 경로를 지정한다.
* 이미지 파일이 src 속성에서 지정한 경로에 없을시, 이미지는 출력되지 않거나 엑스박스가 뜨게 된다.
### 속성
* src: 이미지의 경로
* width: 이미지 가로 크기
* height: 이미지 세로 크기

## 사용법
* 〈img src="my_profile.png" width="500" height="300"〉
* 예제
    ```html
    <html>
    <body>
        <p>
            이미지가 정상적으로 삽입 된 경우<br>
            <img src="/images/attach/logo_black.png" width="245">
        </p>	
        <p>
            없는 이미지가 삽입 된 경우<br>
            <img src="no_img.png" width="100" height="50">
        </p>
    </body>
    </html>
    ```
    <html>
    <body>
        <p>
            이미지가 정상적으로 삽입 된 경우<br>
            <img src="../../../img/logo_black.png" width="245">
        </p>	
        <p>
            없는 이미지가 삽입 된 경우<br>
            <img src="no_img.png" width="100" height="50">
        </p>
    </body>
    </html>