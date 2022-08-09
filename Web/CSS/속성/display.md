## 개요
* display 속성은 요소를 어떻게 보여줄지를 결정한다.
* 주로 4가지 속성값이 쓰이는데, 태그마다 기본값이 다르다.
  * none : 보이지 않음
  * block : 블록 박스
  * inline : 인라인 박스
  * inline-block : block과 inline의 중간 형태

## none
* 요소를 렌더링하지 않도록 설정한다. visibility 속성을 `hidden으로 설정한 것과 달리`, 영역도 차지하지 않는다.

## 예제
```css
<style>
.display-none{ display: none }
.invisible{ visibility: hidden }
div.res{ border: 1px solid #aaa; }
</style>
<div class="res">
    <div class="display-none">1</div>
    <div>2</div>

    <div class="invisible">3</div>
    <div>4</div>
</div>
```
<style>
.display-none{ display: none }
.invisible{ visibility: hidden }
div.res{ border: 1px solid #aaa; }
</style>
<div class="res">
    <div class="display-none">1</div>
    <div>2</div>
    <div class="invisible">3</div>
    <div>4</div>
</div>

## block
* [div 태그](../../HTML/〈body〉태그/〈div〉태그.md), [p 태그](../../HTML/〈body〉태그/〈p〉태그.md), [h# 태그](../../HTML/〈body〉태그/〈h#〉태그.md), [li 태그](../../HTML/〈body〉태그/〈li〉태그.md) 등이 이에 해당된다.

* 기본적으로 가로 영역을 모두 채우며, block 요소 다음에 등장하는 태그는 줄바꿈이 된 것처럼 보인다. 
* width, height 속성을 지정 할 수 있으며, block 요소 뒤에 등장하는 태그가 그 이전 block 요소에 오른쪽에 배치될 수 있어도 항상 다음 줄에 렌더링된다.

## 예제
```css
<style>
.block1{ width: 300px; border: 3px solid #333 }
.block2{ width: 200px; border: 3px solid #999 }
div.res{ border: 1px solid #aaa; }
</style>
<div class="res">
    <div class="block1">1</div>
    <div class="block2">2</div>
    hello
</div>
```

<style>
.block1{ width: 300px; border: 3px solid #333 }
.block2{ width: 200px; border: 3px solid #999 }
div.res{ border: 1px solid #aaa; }
</style>
<div class="res">
    <div class="block1">1</div>
    <div class="block2">2</div>
    hello
</div>

## inline
* [span 태그](../../HTML/〈body〉태그/〈span〉태그.md), [b 태그](../../HTML/〈body〉태그/〈b〉태그.md), [i 태그](../../HTML/〈body〉태그/〈i〉태그.md), [a 태그](../../HTML/〈body〉태그/〈a〉태그.md) 등이 이에 해당된다.

* block 과 달리 줄 바꿈이 되지 않고, width와 height를 지정 할 수 없다. 문서에서 특정 부분에 색상을 입힌다고 다음에 나오는 글이 줄바꿈 되지 않듯이 inline 요소 뒤에 나오는 태그 또한 줄바꿈 되지 않고 바로 오른쪽에 표시된다.

## 예제
```css
<style>
.inline1{
	background: #09c;
}
.inline2{
	width: 200px; /* 이 값은 무시됩니다 */
	border: 3px solid #999;
}
</style>

<p>
	Lorem ipsum dolor sit amet, <span class="inline1">consectetur adipiscing elit</span>,
	sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
	Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
	Duis aute irure dolor in <span class="inline2">reprehenderit</span>
	in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
	Excepteur sint occaecat cupidatat non proident,
	sunt in culpa qui officia deserunt mollit anim id est laborum.
</p>
```
<style>
.inline1{
	background: #09c;
}
.inline2{
	width: 200px; /* 이 값은 무시됩니다 */
	border: 3px solid #999;
}
</style>

<p>
	Lorem ipsum dolor sit amet, <span class="inline1">consectetur adipiscing elit</span>,
	sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
	Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
	Duis aute irure dolor in <span class="inline2">reprehenderit</span>
	in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
	Excepteur sint occaecat cupidatat non proident,
	sunt in culpa qui officia deserunt mollit anim id est laborum.
</p>


## inline-block
* block과 inline의 중간 형태라고 볼 수 있는데, 줄 바꿈이 되지 않지만 크기를 지정 할 수 있다.

## 예제
```css
<style>
.inline-block1{
	display: inline-block;
	background: #09c;
	height: 45px;
	/* 원래 inline 요소의 높이는 글자(폰트)의 높이를 바탕으로 설정되지만,
	inline-block을 이용하면 임의로 높이 또한 설정을 할 수 있다. */
}
.inline-block2{
	display: inline-block;
	width: 200px; /* 이 값은 이제 정상 작동한다 */
	border: 3px solid #999;
}
</style>

<p>
	Lorem ipsum dolor sit amet, <span class="inline-block1">consectetur adipiscing elit</span>,
	sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
	Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
	Duis aute irure dolor in <span class="inline-block2">reprehenderit</span>
	in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
	Excepteur sint occaecat cupidatat non proident,
	sunt in culpa qui officia deserunt mollit anim id est laborum.
</p>
```

<style>
.inline-block1{
	display: inline-block;
	background: #09c;
	height: 45px;
}
.inline-block2{
	display: inline-block;
	width: 200px;
	border: 3px solid #999;
}
</style>

<p>
	Lorem ipsum dolor sit amet, <span class="inline-block1">consectetur adipiscing elit</span>,
	sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
	Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
	Duis aute irure dolor in <span class="inline-block2">reprehenderit</span>
	in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
	Excepteur sint occaecat cupidatat non proident,
	sunt in culpa qui officia deserunt mollit anim id est laborum.
</p>