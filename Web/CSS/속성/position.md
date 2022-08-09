## 개요
* position 속성은 태그를 어떻게 위치시킬지를 정의하며, 아래의 5가지 값을 갖는다.
  * static: 기본값, 다른 태그와의 관계에 의해 자동으로 배치되며 위치를 임의로 설정해 줄 수 없다.
  * absolute: 절대 좌표와 함께 위치를 지정해 줄 수 있다.
  * relative: 원래 있던 위치를 기준으로 좌표를 지정한다.
  * fixed: 스크롤과 상관없이 항상 문서 최 좌측상단을 기준으로 좌표를 고정한다.
  * inherit: 부모 태그의 속성값을 상속받는다.
* 좌표를 지정 해주기 위해서는 left, right, top, bottom 속성과 함께 사용한다.

* position을 absolute나 fixed로 설정시 가로 크기가 100%가 되는 block 태그의 특징이 사라지게 된다.

## 사용법
```css
#box1 { position:static }
#box2 { position:absolute }
#box3 { position:relative }
#box4 { position:fixed }
#box5 { position:inherit }
```

## 예제
```html
<html>
<head>
	<style>
		.box-container{
			width: 350px;
			border: 2px solid #e91bf5;
		}
		.box-container div{
			padding: 10px;
			border: 1px solid green;
			background-color: #e3ffe0;
		}
		#box1 { position: static; top: 20px; left: 30px; }
		#box2 { position: relative; top: 20px; left: 30px; }
		#box3 { position: absolute; top: 1080px; right: 70px; }
		#box4 { position: fixed; top: 20px; right: 30px; }
	</style>
</head>
<body>
	<div class="box-container">
		<div id="box1">static 박스</div>
		<div id="box2">relative 박스</div>
		<div id="box3">absolute 박스</div>
		<div id="box4">fixed 박스</div> <!-- '출력 결과' 란이 아닌, 전체 페이지에서 고정되어 보여짐 -->
	</div>
</body>
</html>
```
<html>
<head>
	<style>
		.box-container{
			width: 350px;
			border: 2px solid #e91bf5;
		}
		.box-container div{
			padding: 10px;
			border: 1px solid green;
			background-color: #e3ffe0;
		}
		#box1 { position: static; top: 20px; left: 30px; }
		#box2 { position: relative; top: 20px; left: 30px; }
		#box3 { position: absolute; top: 1080px; right: 70px; }
		#box4 { position: fixed; top: 20px; right: 30px; }
	</style>
</head>
<body>
	<div class="box-container">
		<div id="box1">static 박스</div>
		<div id="box2">relative 박스</div>
		<div id="box3">absolute 박스</div>
		<div id="box4">fixed 박스</div>
	</div>
</body>
</html>

</br></br>   

## absolute와 relative
* relative 인 컨테이너 내부에 absolute인 객체가 있으면 절대 좌표를 계산할 때, relative 컨테이너를 기준점으로 잡게 된다. (없다면 전체 문서가 기준, 위의 예제에서 top의 속성값을 1080px을 준 이유)
## 예제
```html
<html>
<head>
	<style>
		#box-container{ position: relative; height: 90px; margin-top: 40px; border: 2px solid red; }
		#box-inner{ position: absolute; top: 30px; left: 20px; border: 2px solid blue; }
	</style>
</head>
<body>
	<div id="box-container">
		컨테이너
		<div id="box-inner">absolute 박스</div>
	</div>
</body>
</html>
```

<html>
<head>
	<style>
		#box-container{ position: relative; height: 90px; margin-top: 40px; border: 2px solid red; }
		#box-inner{ position: absolute; top: 30px; left: 20px; border: 2px solid blue; }
	</style>
</head>
<body>
	<div id="box-container">
		컨테이너
		<div id="box-inner">absolute 박스</div>
	</div>
</body>
</html>