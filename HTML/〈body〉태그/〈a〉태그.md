## 개요
* 〈a〉〈/a〉 태그는 하이퍼링크를 걸어주는 태그이다.

### 속성
* href: 클릭시 이동 할 링크
* target: 링크를 여는 방법
  * _self: 현재 페이지 (기본값)
  * _blank: 새 탭
  * _parent: 부모 페이지로, iframe 등이 사용된 환경에서 쓰인다.
  * _top: 최상위 페이지로, iframe 등이 사용된 환경에서 쓰인다.
  * 프레임이름: 직접 프레임이름을 명시해서 사용할 수도 있다.

## 사용법
* 〈a〉 href="http://www.naver.com">Go NAVER〈/a〉
* 예제
    ```html
    <html>
        <body>
            <a href="http://www.naver.com">Go Naver</a><br>
            <a href="http://google.co.kr" target="_blank">Go Google (new window)</a>
        </body>
    </html>
    ```
    <html>
        <body>
            <a href="http://www.naver.com">Go Naver</a><br>
            <a href="http://google.co.kr" target="_blank">Go Google (new window)</a>
        </body>
    </html>