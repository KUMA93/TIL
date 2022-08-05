## 개요
* 〈meta /〉 태그는 웹 페이지의 보이지 않는 정보를 제공하는데 쓰이는 태그이다.
* 페이지의 설명 요약, 핵심 키워드, 제작자, 크롤링 정책 등 수많은 정보를 제공할 수 있다.

* 닫는 태그가 없는 태그로, 태그의 속성을 통해 정보를 제공한다.

### SEO
* **SEO**는 Search Engine Optimization의 약자로, 검색 엔진 최적화를 의미한다.

* 〈meta /〉 태그를 이용하여 description, keywords, author, subject, classification 등의 정보를 표기할 수 있으며, 검색 엔진은 이런 정보를 적극적으로 활용한다.
* 다음과 같이 작성한다.
    ```html
    <meta name="description" content="<p>태그에 대해 알아봅시다">
    <meta name="subject" content="HTML - <p>태그">
    ```

* 예시
    ```html
    <html>
    <head>
        <title>HTML 태그의 속성 - ofcourse</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="태그는, 태그 내부에 값을 넣을 수 있을 뿐만 아니라, 태그마다 속성을 부여할 수 있습니다.">
        <meta name="subject" content="태그의 속성">
        <meta name="classification" content="html">
        <meta name="keywords" content="www,web,world wide web,html,css,javascript">
        <meta name="robots" content="ALL">
    </head>
    <body>
        ...
    </body>
    </html>
    ```
