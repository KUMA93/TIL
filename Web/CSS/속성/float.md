## 개요
* float 라는 단어는 원래 ‘뜨다’ 라는 의미이며, 원래 웹페이지에서 이미지를 어떻게 띄워서 텍스트와 함께 배치할 것인가에 대한 속성이다.
<img src="../../../img/float.png">

  * `inherit`: 부모 요소에서 상속
  * `left`: 왼쪽에 부유하는 블록 박스를 생성. 페이지 내용은 박스 오른쪽에 위치하며 위에서 아래로 흐름.
  * `right`: 오른쪽에 부유하는 블록 박스를 생성. 페이지 내용은 박스 왼쪽에 위치하며 위에서 아래로 흐름. 이후 요소에 clear 속성이 있으면 페이지 흐름이 달라짐. none 이 아니라면 display 속성은 무시된다.
  * `none` - 요소를 부유시키지 않음
* `left`와 `right`를 통해 부유속성을 지정시 `display는 무시`된다. (none은 제외)
또한 이후 요소에 `clear` 속성이 있으면 페이지 흐름이 달라진다.

## 사용법
```css
.content > img{ float: left }
```

## 예제
```html
<html>
<head>
<style>
	.float-container{
		width: 320px;
		border: 2px solid #09c;
	}
	.float-container img{
		float: left;
		margin: 5px;
		padding: 5px;
		border: 2px solid #90C;
	}
</style>
</head>
<body>
	<div class="float-container">
		<img src="../../../img/earth.jpg">
		Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
		tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
		quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
		consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
		cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
		proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
	</div>
</body>
</html>
```
<html>
<head>
<style>
	.float-container{
		width: 320px;
		border: 2px solid #09c;
	}
	.float-container img{
		float: left;
		margin: 5px;
		padding: 5px;
		border: 2px solid #90C;
	}
</style>
</head>
<body>
	<div class="float-container">
		<img src="../../../img/earth.jpg">
		Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
		tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
		quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
		consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
		cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
		proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
	</div>
</body>
</html>

## 레이아웃에서의 float
* float 속성은 원래 이미지와 텍스트 배치 용도로 등장했지만, 요즘에는 레이아웃용으로 많이 사용하고 있다.
* 〈div〉 태그를 float 속성 및 width, height 속성 등을 이용하여 레이아웃을 배치하는 방식이다.

## 예제
```html
<html>
<head>
<style>
	.ex-layout{ height: 310px }
	.menu{
		width: 300px;
		height: 40px;
		border: 2px solid #09c;
		background-color: #d7f5ff;
	}
	.main .left-menu{
		float: left;
		width: 50px;
		height: 254px;
		border: 2px solid red;
		background-color: #ffe7d5;
	}
	.main .content{
		float: left;
		width: 250px;
		height: 250px;
	}
	.main .content .article{
		height: 200px;
		border: 2px solid blue;
		background-color: #e2e9ff;
	}
	.main .content .comment{
		height: 50px;
		border: 2px solid purple;
		background-color: #ffddff;
	}
</style>
</head>
<body>
	<div class="ex-layout">
		<div class="menu">global menu</div>
		<div class="main">
			<div class="left-menu">left menu</div>
			<div class="content">
				<div class="article">article</div>
				<div class="comment">comment</div>
			</div>
		</div>
	</div>
</body>
</html>
```

<html>
<head>
<style>
	.ex-layout{ height: 310px }
	.menu{
		width: 300px;
		height: 40px;
		border: 2px solid #09c;
		background-color: #d7f5ff;
        color: black;
	}
	.main .left-menu{
		float: left;
		width: 50px;
		height: 254px;
		border: 2px solid red;
		background-color: #ffe7d5;
        color: black;
	}
	.main .content{
		float: left;
		width: 250px;
		height: 250px;
	}
	.main .content .article{
		height: 200px;
		border: 2px solid blue;
		background-color: #e2e9ff;
        color: black;
	}
	.main .content .comment{
		height: 50px;
		border: 2px solid purple;
		background-color: #ffddff;
        color: black;
	}
</style>
</head>
<body>
	<div class="ex-layout">
		<div class="menu">global menu</div>
		<div class="main">
			<div class="left-menu">left menu</div>
			<div class="content">
				<div class="article">article</div>
				<div class="comment">comment</div>
			</div>
		</div>
	</div>
</body>
</html>