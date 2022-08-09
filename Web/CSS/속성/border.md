## 개요
* border 속성은 태그의 테두리를 설정하는 속성으로, background 속성과 비슷하게 세부적인 속성들을 한번에 쓸 수 있는 속성이다. `width - style - color의 순서로 사용`한다.

## border-width
* 테두리의 두께로, 주로 px 단위를 사용한다.

## border-style
* 테두리의 스타일로 실선, 점선, 이중선 등의 옵션이 존재한다.

## border-color
* 테두리의 색상으로, 값은 color 속성의 포맷을 사용한다.

## 예제

```css
<style>
	.border-styles > p{
		margin: 2px 0;
		padding: 1px 3px;
		border-width: 2px;
		border-color: #aaa;
	}
</style>
<div class="border-styles">
	<p style="border-style: solid">solid</p>
	<p style="border-style: dotted">dotted</p>
	<p style="border-style: dashed">dashed</p>
	<p style="border-style: double">double</p>
	<p style="border-style: groove">groove</p>
	<p style="border-style: ridge">ridge</p>
	<p style="border-style: inset">inset</p>
	<p style="border-style: outset">outset</p>
</div>
```

<style>
	.border-styles > p{
		margin: 2px 0;
		padding: 1px 3px;
		border-width: 2px;
		border-color: #aaa;
	}
</style>
<div class="border-styles">
	<p style="border-style: solid">solid</p>
	<p style="border-style: dotted">dotted</p>
	<p style="border-style: dashed">dashed</p>
	<p style="border-style: double">double</p>
	<p style="border-style: groove">groove</p>
	<p style="border-style: ridge">ridge</p>
	<p style="border-style: inset">inset</p>
	<p style="border-style: outset">outset</p>
</div>

## 방향
* 테두리의 특정 방향만 따로 설정할 수도 있다.
  * border-top
  * border-bottom
  * border-left
  * border-right
* border-bottom-color처럼 방향과 색,두께,스타일을 따로 설정할 수도 있다.

## 사용법
```css
#box{
	border: 4px dotted green;
	border-bottom: 5px solid blue;
}
```

## 예제
```html
<html>
<head>
<style>
	#box{
		padding: 5px;
		border: 4px dotted green;
		border-bottom: 5px solid blue;
	}
</style>
</head>

<body>
	 <div id="box">Simple Border Example</div>
</body>
</html>
```

<html>
<head>
<style>
	#box{
		padding: 5px;
		border: 4px dotted green;
		border-bottom: 5px solid blue;
	}
</style>
</head>

<body>
	 <div id="box">Simple Border Example</div>
</body>
</html>

## border-radius 속성

* border-radius 속성은 요소의 테두리를 둥글게 만들어 준다. px 단위와 % 단위를 사용할 수 있으며, border 속성 없이도 사용할 수 있다.

총 4개의 모서리를 각각 다른 값으로도 줄 수 있다. margin 및 padding 속성 처럼 4개의 값을 띄워쓰면 왼쪽-위 부터 시계 방향으로 각자 다른 값을 지정할 수 있다.

## 사용법
```css
#box{
	border-radius: 5px;
	border-radius: 1px 2px 3px 4px;
}
```

## 예제
```html
<html>
<head>
<style>
    .box{
        width: 150px;
        height: 80px;
		background-color: #039BE5;
		border: 2px solid #01579B;
		margin-bottom: 20px;
    }
	#box1{
		border-radius: 20px;
	}
	#box2{
		width: 80px;
		border-radius: 50%;
	}
	#box3{
		border-radius: 20px 0 10px 50px;
	}
</style>
</head>

<body>
	<div id="box1" class="box"></div>
	<div id="box2" class="box"></div>
	<div id="box3" class="box"></div>
</body>
</html>
```

<html>
<head>
<style>
    .box{
        width: 150px;
        height: 80px;
		background-color: #039BE5;
		border: 2px solid #01579B;
		margin-bottom: 20px;
    }
	#box1{
		border-radius: 20px;
	}
	#box2{
		width: 80px;
		border-radius: 50%;
	}
	#box3{
		border-radius: 20px 0 10px 50px;
	}
</style>
</head>

<body>
	<div id="box1" class="box"></div>
	<div id="box2" class="box"></div>
	<div id="box3" class="box"></div>
</body>
</html>