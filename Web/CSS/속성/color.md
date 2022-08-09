## 개요
* color 속성은 단어 뜻대로 색상, 정확히는 글자의 색상을 의미한다.
  * red, blue등 이미 정의된 색
  * #000, #FFFFFF 등의 16진수 색상 코드
  * rgb(255, 255, 255) 등의 rgb 색상
  * rgba(200, 100, 150, 0.5) 등의 알파(투명도)가 적용된 rgba 색상
* color 속성은 위 목록등의 값을 사용할 수 있으며, 기본값은 inherit으로 부모의 색상을 가져온다.

## 사용법
```css
#text1 { color: red; }
#text2 { color: #0A0; }
#text3 { color: rgb(0, 0, 150); }
#text4 { color: rgba(30, 150, 100, 0.5); }
```

## 예제

```html
<html>
<head>
<style>
    div.txt1 { color: rgba(55, 77, 59, 0.7); }
    div#txt2 { color: #1B2; }
</style>
</head>
<body>
	<div style="color: red">text1</div>
	<div style="color: #0A0">text2</div>
	<div style="color: rgb(0, 0, 150)">text3</div>
	<div style="color: rgba(0, 140, 170, 0.5)">text4</div>
    <div class="txt1">text5</div>
    <div id="txt2">text6</div>
</body>
</html>
```
<html>
<head>
<style>
    div.txt1 { color: rgba(55, 77, 59, 0.7); }
    div#txt2 { color: #1B2; }
</style>
</head>
<body>
	<div style="color: red">text1</div>
	<div style="color: #0A0">text2</div>
	<div style="color: rgb(0, 0, 150)">text3</div>
	<div style="color: rgba(0, 140, 170, 0.5)">text4</div>
    <div class="txt1">text5</div>
    <div id="txt2">text6</div>
</body>
</html>