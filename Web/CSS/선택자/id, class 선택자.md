## 개요
* 태그에서 설정한 id나 class 속성에 따라 스타일을 지정한다.
* id 에 줄 경우 아래처럼 #을 맨 앞에 붙여 사용하며, 원칙적으로 하나의 객체에만 적용할 수 있다.
	```css
	#아이디{ 속성1:속성값; 속성2:속성값; } 
	```
* class에 줄 경우 아래처럼 .을 맨 앞에 붙여 사용하며, 여러 객체에 적용할 수 있다.
	```css
	.클래스명{ 속성1:속성값; 속성2:속성값 }
	```
## 사용법
```css
#m_box{ width:500px; height:300px; }
.box{ background-color:blue; }
```

## 예제
```html
<html>
<head>
<style>
	#m_box{ background-color: #09C; width: 150px; height: 40px; }
	.box{ width: 100px; height: 50px; border: 1px solid green }
</style>
</head>
<body>
	<div class="box">1번 box 클래스</div>
	<div class="box">2번 box 클래스</div>
	<div id="m_box">m_box 아이디</div>
</body>
</html>
```
<html>
<head>
<style>
	#m_box{ background-color: #09C; width: 150px; height: 40px; }
	.box{ width: 100px; height: 50px; border: 1px solid green }
</style>
</head>
<body>
	<div class="box">1번 box 클래스</div>
	<div class="box">2번 box 클래스</div>
	<div id="m_box">m_box 아이디</div>
</body>
</html>