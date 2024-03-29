## 개요
* font 속성은 글자의 폰트를 정의하는 속성인데, 여러 기능을 동시에 가지고 있는 속성이기도 하다.
* 정확히 말하면 6개의 세부적인 글꼴 관련 속성을 font라는 하나의 속성에 한번에 쓸 수 있다.

	|속성|설명|
	|:---|:---:|
	|font-style|이탤릭체 등의 글꼴의 스타일 지정|
	|font-weight|글자 두께|
	|font-variant|글꼴 변형 (소문자를 대문자로 바꾸는 등의)|
	|font-size|글자 크기|
	|line-height|줄 간격|
	|font-family|글꼴 (굴림, 돋움, …)|

* font 속성은 다음과 같은 순서로 세부 속성을 한번에 기술한다.
```css
font: font-style font-variant font-weight font-size/line-height font-family
```

## font-style
* 글꼴의 스타일로, 주로 이탤릭체(기울여 표시)를 설정하기 위해 사용한다.
  * normal: 기본
  * italic: 이탤릭체

## font-weight
* 글꼴의 두께로, 미리 정의된 단어나 100 ~ 900 사이의 숫자를 통해 설정한다.
* 기본값은 normal 이다.
  * 100: lighter
  * 200
  * 300
  * 400: normal
  * 500
  * 600
  * 700: bold
  * 800
  * 900: bolder

## font-size
* 글자 크기로, 〈font〉 태그의 size 속성과 효과가 같다.
* (HTML5 부터 〈font〉 태그 사용은 권장되지 않으며, CSS를 사용해야 한다)

* `px`, `px`, `em`, 등의 단위와 `small`, `big` 등의 상수 크기를 사용할 수 있다.
* 일반 웹 페이지에서는 px를 사용한다.

## font-family
* 글꼴 종류로, 〈font〉 태그의 face 속성과 효과가 같다.
* 쉼표(,)로 여러 글꼴을 등록 할 수 있는데, 이때 맨 앞에 있는 글꼴을 우선으로 적용시키며, 맨 앞에 있는 글꼴이 사용자의 컴퓨터에 없을 때 그 다음 글꼴을 사용한다.

## 사용법
```css
.box1 {
	font-size: 20px;
	font-family: 나눔고딕,NanumGothic,돋움,Dotum;
}
.box1 .title { font-weight: bold }
.ex1 { font: 15px NanumGothic, sans-serif }
.ex2 { font: italic bold 12px/30px Dotum, sans-serif }
```

## 예제
```html
<html>
<head>
	<style>
		#text1 { font-size: 37px }
		#text2 { font-size: 28px }
		#text3 { font-size: 19px }

		.bold { font-weight: bold }
		.italic{ font-style: italic }
		.jinji{ font-family: "궁서" }

		#text4{ font: italic bold 20px serif; }
   </style>
</head>
<body>
	<div id="text1">37px</div>
	<div id="text2">28px</div>
	<div id="text3">19px</div>
	<br>
	<div class="bold">굵은 글씨</div>
	<div class="italic">기울인 글</div>
	<div class="jinji">진지한 글꼴</div>
	<br>
	<div id="text4">There's no books on my backpack</div>
</body>
</html>
```

<html>
<head>
	<style>
		#text1 { font-size: 37px }
		#text2 { font-size: 28px }
		#text3 { font-size: 19px }

		.bold { font-weight: bold }
		.italic{ font-style: italic }
		.jinji{ font-family: "궁서" }

		#text4{ font: italic bold 20px serif; }
   </style>
</head>
<body>
	<div id="text1">37px</div>
	<div id="text2">28px</div>
	<div id="text3">19px</div>
	<br>
	<div class="bold">굵은 글씨</div>
	<div class="italic">기울인 글</div>
	<div class="jinji">진지한 글꼴</div>
	<br>
	<div id="text4">There's no books on my backpack</div>
</body>
</html>