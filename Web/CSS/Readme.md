# **CSS**
* [CSS 개요](#css-개요)
* [선택자](./%EC%84%A0%ED%83%9D%EC%9E%90/)
* [속성](./%EC%86%8D%EC%84%B1/)
* [레이아웃 구성](./%EB%A0%88%EC%9D%B4%EC%95%84%EC%9B%83%20%EA%B5%AC%EC%84%B1/)
* [적용 우선순위](./%EC%A0%81%EC%9A%A9%20%EC%9A%B0%EC%84%A0%EC%88%9C%EC%9C%84/)
* [CSS 파일 분리](./CSS%20%ED%8C%8C%EC%9D%BC%20%EB%B6%84%EB%A6%AC/)

## CSS 개요
* CSS란?
  * **Cascading Style Sheets**의 줄임말이다.
  * 웹 페이지 화면에 표시되는 `스타일을 구체적으로 정하는 규격`이다.
  * 공통적인 디자인을 갖는 문서가 여럿 존재할 경우 하나의 디자인이 변경되면 모든 파일을 수정해야 되는 번거로움을 해결한다.
  * 내용과 스타일을 분리해주어 역할 분담도 되는 효과를 가지고 있다.

## 사용법
* CSS 내부적으로 사용되는 문법은 동일하며, 어디에 기술하느냐의 차이가 존재한다.
* 기술하는 방법은 아래의 3가지가 있다.
  1. HTML 태그의 style 속성을 이용
  2. `〈style〉 태그를 통해 HTML 문서 내부에 기술` (〈style〉 태그는 주로 〈head〉태그 내부에 사용한다)
  3. [.css 파일로 분리](./CSS%20%ED%8C%8C%EC%9D%BC%20%EB%B6%84%EB%A6%AC/)하여 HTML 문서에 연결
    ```html
    <!-- 1번 방법 -->
    <div style="color: red"> this is red text </div>
    <!-- 2번 방법 -->
    <html>
    <head>
        <style type="text/css">
            .my-text{ color: blue }
        </style>
    </head>
    <body>
        <div class="my-text">
            this is red blue
        </div>
    </body>
    </html>
    ```

    * 1번 처럼 사용시 HTML과 CSS를 분리하는 장점이 없어지기 때문에 2,3번을 주로 활용한다.
    * 〈style〉 태그의 type="text/css"는 필수가 아니지만, 더 정확한 표현을 위해 함께 써주기도 한다.

## 주석

* /* 로 시작하여 */로 끝난다.
    ```css
    #my-box{
        /* color: red; */
        color: blue;
    }
    ```

## 원문보기
* [ofcourse](https://ofcourse.kr/css-course/CSS-%EC%9E%85%EB%AC%B8)