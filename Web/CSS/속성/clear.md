## 개요
* float 속성을 통해 태그를 부유시킨 이후 문서의 흐름을 제거하기 위해 쓰인다.
방향에 따라 3가지 속성을 사용할 수 있다.
  * left: 좌측 부유 제거
  * right: 우측 부유 제거
  * both: 양쪽 모두 제거

## 예제
```html
<html>
<head>
<style>
	.float-container{ width: 320px; border: 2px solid #09c; }
	.float-container img{ float: left; margin: 5px; padding: 5px; border: 2px solid #90C; }
</style>
</head>
<body>
	<div class="float-container">
		<img src="../../../img/earth.jpg">
		<p>This is first line with floating image.</p>
		<p style="clear: both">This is second line with cleared property.</p>
	</div>
</body>
</html>
```

<html>
<head>
<style>
	.float-container{ width: 320px; border: 2px solid #09c; }
	.float-container img{ float: left; margin: 5px; padding: 5px; border: 2px solid #90C; }
</style>
</head>
<body>
	<div class="float-container">
		<img src="../../../img/earth.jpg">
		<p>This is first line with floating image.</p>
		<p style="clear: both">This is second line with cleared property.</p>
	</div>
</body>
</html>

## 레이아웃에서의 clear
* float 속성이 레이아웃에서 많이 사용한다고 하였는데, clear속성도 float를 레이아웃에서 사용하며 발생되는 문제를 해결하기 위해 많이 사용된다.

* float 속성을 적용한 태그는 붕 뜨며 정상적인 요소로 처리가 안되기 때문에
아래에 나타나야 하는 내용이 부유된 태그의 중간에 나타나는 문제 및 상위 태그의 높이가 없어지는 문제 등이 발생하게 된다.

## 예제
```css
<style>
	.box-container{
		width: 350px;
		border: 2px solid #09c;
		background-color: #d7f5ff;
	}
	.box-container .box{
		width: 80px;
		height: 40px;
		border: 2px solid red;
		background-color: #ffe7d5;
	}
</style>
<div class="box-container">
	<div class="box" style="float: left">박스1</div>
	<div class="box" style="float: right">박스2</div>
</div>
<div>박스 아래에 나타나야 하는 내용</div>
```
<style>
	.box-container{
		width: 350px;
		border: 2px solid #09c;
		background-color: #d7f5ff;
	}
	.box-container .box{
		width: 80px;
		height: 40px;
		border: 2px solid red;
		background-color: #ffe7d5;
	}
</style>
<div class="box-container">
	<div class="box" style="float: left">박스1</div>
	<div class="box" style="float: right">박스2</div>
</div>
<div>박스 아래에 나타나야 하는 내용</div>

## 예제
```css
<div class="box-container">
	<div class="box" style="float: left">박스1</div>
	<div class="box" style="float: right">박스2</div>
	<div style="clear: both"></div>
</div>
<div>박스 아래에 나타나야 하는 내용</div>
```
<div class="box-container">
	<div class="box" style="float: left">박스1</div>
	<div class="box" style="float: right">박스2</div>
	<div style="clear: both"></div>
</div>
<div>박스 아래에 나타나야 하는 내용</div>

## after 가상선택자와 clear
* clear 해주기 위해서는 float된 요소 다음에 clear하는 태그를 따로 삽입해야 하는 불편함이 있다.
* 이때 가상 클래스 선택자를 이용하면 이 문제를 해결할 수 있다.
* 부유를 제거하고 싶은 컨테이너에 다음 클래스를 적용시키면 문제가 해결된다.
```css
.clearfix:after{ content: ""; display: block; clear: both }
```

## 예제
```css
<style type="text/css">
	.clearfix{ *zoom: 1; }
	.clearfix:after{ content: ""; display: block; clear: both }
</style>
<div class="box-container clearfix">
	<div class="box" style="float: left">박스1</div>
	<div class="box" style="float: right">박스2</div>
</div>
<div>박스 아래에 나타나야 하는 내용</div>
```
<style type="text/css">
	.clearfix{ *zoom: 1; }
	.clearfix:after{ content: ""; display: block; clear: both }
</style>
<div class="box-container clearfix">
	<div class="box" style="float: left">박스1</div>
	<div class="box" style="float: right">박스2</div>
</div>
<div>박스 아래에 나타나야 하는 내용</div>

## float와 clear로 레이아웃 구성하기
* float 속성과 clear 속성, 그리고 after 가상선택자는 가장 보편적으로 사용되는 레이아웃 구성 방법이다.