## 개요
* CSS를 별도의 파일로 저장 후 HTML 문서 내에서 불러올 수 있다.

* 여러 웹페이지에서 `공통적인 CSS`를 참조할 때, `중복 코드를 제거`할 수 있기에 매우 유용하다.
* `문서 규격과 스타일의 분리`를 위해 CSS를 별도의 파일로 분리하여 사용하는 것이 좋다.

## 사용법
```html
<head>
	<link rel="stylesheet" href="경로.css" type="text/css">
</head>
```

## 특별한 점
* CSS의 인코딩은 문서 맨 앞에 `@charset "utf-8";` 형식의 코드를 쓰며 지정한다.
* CSS에서 background-image 등으로 외부 이미지나 파일 등을 참조할 때에는 웹페이지 url이 아닌 CSS 파일의 경로를 기준으로 한다.

## CSS 파일 예제
```css
@charset "utf-8";

h1{
	font-size: 30px;
	font-weight: normal;
	margin: 0;
	margin-bottom: 10px;
}

#progress-bar{
	margin: 0;
	padding: 0;
	margin-bottom: 15px;
	list-style: none;
}

.common-btn{
	padding: 4px 6px;
	background-color: #07C;
	color: white;
	border: none;
	border-radius: 10px;
	text-decoration: none;
}
```