## 개요
* CSS의 특성상 어떤 태그에 속성이 중복되어 설정될 수 있다.
* CSS는 어떤 속성이 우선되어 적용되는지 미리 명시하고 있다. 우선순위는 아래와 같다.
  * 속성 값 뒤에 `!important` 를 붙인 속성
  * `HTML`에서 `style`을 직접 지정한 속성
  * `#id` 로 지정한 속성
  * `.클래스`, `:추상클래스` 로 지정한 속성
  * `태그이름` 으로 지정한 속성
  * 상위 객체에 의해 상속된 속성
* 같은 우선 순위에 있는 경우, 부모-자식 관계가 많은 경우가 우선되며, 모든 설정이 같은 경우 나중에 선언한 것이 우선되어 적용된다.

## !important
* 우선순위를 무시하고, 꼭 적용 시키고 싶은 속성이 있다면, 속성 값 뒤에 `!important` 를 붙여서 적용시켜주면 된다.
```css
.normal { color: blue }
.compulsion{ color: black !important }
```
* !important 는 우선순위 뿐만 아니라 디자이너-개발자간 커뮤니케이션시 중요한 속성임을 알리는 뜻을 나타내기도 한다.

## 예제
```html
<html>
<head>
<style>
	#my-box .text{ color: black }
	.black{ color: red }
	.important-black{ color: red !important }
</style>
</head>
<body>
	<div id="my-box">
		<div class="text">My text 1</div>
		<div class="text black">My text 2</div>
		<div class="text important-black">My text 3</div>
	</div>
</body>
</html>
```
<html>
<head>
<style>
	#my-box .text{ color: black }
	.black{ color: red }
	.important-black{ color: red !important }
    .res{ border: 1px solid black; background-color: #ddd; }
</style>
</head>
<body>
    <div class="res">
        <div id="my-box">
            <div class="text">My text 1</div>
            <div class="text black">My text 2</div>
            <div class="text important-black">My text 3</div>
        </div>
    </div>
</body>
</html>