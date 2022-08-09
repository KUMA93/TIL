## 개요
* `margin`과 `padding` 속성은 각각 `바깥쪽 여백`, `안쪽 여백`을 의미한다.
* `margin`과 `padding`는 `border 을 경계`로 나뉜다.

<img src="../../../img/margin_padding.png" width=500px>

## 방향
* 방향마다 여백을 다르게 설정할 수 있다.
  * margin: 20px 같은 표현은 상하좌우 모두 20px을 의미한다
  * margin: 30px 10px은 상하 30px, 좌우 10px을 의미한다.
  * margin: 30px 10px 20px 50px은 위 30px, 오른쪽 10px, 아래 20px, 왼쪽 50px을 의미한다.
  * margin: 30px 10px 40px은 위 30px, 좌우 10px, 아래 40px을 의미한다.
* 즉, 방향의 위부터 시계방향으로 회전하여 위 오른쪽 아래 왼쪽 순서로 설정한다.

## 사용법
```css
#box{ margin: 10px; padding: 20px }
```

## 예제
```html
<html>
<head>
<style>
	.box-container{
		display: inline-block;
		background-color: #d2f4ff;
		border: 2px solid #09c;
		margin: 5px 15px;
	}
	.box-container div{
		width: 120px;
		height: 80px;
		background-color: #fde6ff;
		border: 2px solid #90C;
		font-size: 15px;
	}
	#box1{ margin: 10px;  padding: 0; }
	#box2{ margin: 5px 25px; padding: 0; }
	#box3{ margin: 0;  padding: 10px 30px 5px; }
	#box4{ margin: 10px; padding: 10px 20px; }
	#box5{ margin: 10px 30px 0 50px; padding: 30px 0 }
</style>
</head>

<body>
	<div class="box-container">
		<div id="box1">m: 10<br>p: 0</div>
	</div>
	<div class="box-container">
		<div id="box2">m: 5 25<br>p: 0</div>
	</div>
	<div class="box-container">
		<div id="box3">m: 0<br>p: 10 30 5</div>
	</div>
	<div class="box-container">
		<div id="box4">m: 10<br>p: 10 20</div>
	</div>
	<div class="box-container">
		<div id="box5">m: 10 30 0 50<br>p: 30 0</div>
	</div>
</body>
</html>
```
<html>
<head>
<style>
	.box-container{
		display: inline-block;
		background-color: #d2f4ff;
		border: 2px solid gray;
		margin: 5px 15px;
	}
	.box-container div{
		width: 120px;
		height: 80px;
		background-color: #fde6ff;
		border: 2px solid gray;
		font-size: 15px;
	}
	#box1{ margin: 10px;  padding: 0; }
	#box2{ margin: 5px 25px; padding: 0; }
	#box3{ margin: 0;  padding: 10px 30px 5px; }
	#box4{ margin: 10px; padding: 10px 20px; }
	#box5{ margin: 10px 30px 0 50px; padding: 30px 0 }
</style>
</head>

<body>
	<div class="box-container">
		<div id="box1">m: 10<br>p: 0</div>
	</div>
	<div class="box-container">
		<div id="box2">m: 5 25<br>p: 0</div>
	</div>
	<div class="box-container">
		<div id="box3">m: 0<br>p: 10 30 5</div>
	</div>
	<div class="box-container">
		<div id="box4">m: 10<br>p: 10 20</div>
	</div>
	<div class="box-container">
		<div id="box5">m: 10 30 0 50<br>p: 30 0</div>
	</div>
</body>
</html>