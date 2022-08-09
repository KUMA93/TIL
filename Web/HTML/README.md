# **HTML**
* [HTML 개요](#html이란) <br/>
* [태그](./%ED%83%9C%EA%B7%B8.md) <br/>
  * [〈body〉태그](〈body〉태그/README.md) <br/> 
  * [〈head〉태그](〈head〉태그/README.md) <br/>
## HTML이란?

* 수학에서 덧셈 기호를 +로 나타내고, 뺄셈 기호를 -로 나타내듯 웹 사이트에서 화면에 표시되는 정보를 약속 한 것이 HTML이다.

* HTML은 HyperText Markup Language의 약자이다.
  * HyperText는 단순 텍스트 이상의, 링크 등의 개념이 포함 된 텍스트
  * Markup은 꺽쇠(<, >)로 이루어진 태그를 사용하는 규격
  * 태그들을 이용하여 텍스트 이상의 요소를 정의하는 약속된 언어라고 할 수 있다.
  * 실제로 웹사이트에 표시되는 문자, 사진, 영상, 레이아웃 모두 HTML로 구성되어있다.

## 마크업(Markup)

* 아래와 같은 코드가 마크업 형식을 따르는 텍스트이다.
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <note>
	  <to>Tom</to>
	  <from>Amy</from>
	  <heading>Reminder</heading>
	  <body>Don't forget me this weekend!</body>
  </note>
  ```
* 꺽쇠 안에 들어간 간 것이 태그라고 부르고, <something> 처럼 열고 </something> 처럼 닫으며, 이 둘 사이에 값이 들어간다.
* 주로 꺽쇠 안에 들어가는 문자는 속성의 이름이며, 태그 내부에 들어가는 값은 속성의 값이다.

## HTML 예시

* HTML 문서는 아래처럼 태그들로 이루어져 있다.
  ```html
  <html>
      <head>
		  <title>My Homepage</title>
	  </head>
	  <body>
		  Welcome to my homepage!
	  </body>
  </html>
  ```

* HTML에서 태그는 자신의 이름에 따라 각자 특정한 역할을 갖고 있다.
* 예를 들어 <body></body>태그는 문서의 몸통을 나타내며, 이 태그 안에 들어가는 내용이 몸통부에 표시되게 된다.
* 프론트엔드 프레임워크 등을 사용하면 사용자가 임의로 태그를 만들어 사용하는 경우도 존재한다.

## 주석
* ```html
  '<!--'로 시작하여 '-->'로 끝난다.
  <!-- '주석란' -->
  ```

## 웹 브라우징
* 웹 브라우징의 원리를 간단하게 요약하면 다음과 같다.
  1. 사용자가 주소(URL) 입력
  2. 어떤 IP에 접속해야 하는지 알아냄 (DNS)
  3. 브라우저가 해당 서버에 입력한 주소(URL)로 요청
  4. 서버에서 브라우저의 요청을 해석하고 실행하여 결과 데이터 전송(HTML, CSS, JS,…)
  5. 브라우저가 서버에서 받은 값을 해석하여 화면으로 출력

## 원문보기
* [ofcourse](https://ofcourse.kr/html-course/HTML-%EC%9E%85%EB%AC%B8)
* 본 문서는 위의 링크를 마크다운에 알맞게 재가공한 문서입니다.