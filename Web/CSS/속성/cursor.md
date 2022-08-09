## 개요
* cursor 속성을 이용하면 해당 태그 위에 위치하는 마우스 커서의 모양을 바꿀 수 있다.
    * auto: 자동
    * default: 기본값 (화살표)
    * pointer: 손가락 모양 (클릭 가능한 버튼)
    * wait: 로딩

## 사용법
```css
.btn-wait { cursor: wait }
```

## 예제
```css
<style type="text/css">
	.cursors span{
		display: inline-block;
		margin: 5px;
		padding: 5px 10px;
		background-color: #d2f4ff;
		border: 2px solid #09c;
	}
</style>

<div class="cursors">
	<span style="cursor: auto">Auto</span>
	<span style="cursor: crosshair">Crosshair</span>
	<span style="cursor: default">Default</span>
	<span style="cursor: pointer">Pointer</span>
	<span style="cursor: move">Move</span>
	<span style="cursor: e-resize">e-resize</span>
	<span style="cursor: ne-resize">ne-resize</span>
	<span style="cursor: nw-resize">nw-resize</span>
	<span style="cursor: n-resize">n-resize</span>
	<span style="cursor: se-resize">se-resize</span>
	<span style="cursor: sw-resize">sw-resize</span>
	<span style="cursor: s-resize">s-resize</span>
	<span style="cursor: w-resize">w-resize</span>
	<span style="cursor: text">Text</span>
	<span style="cursor: wait">Wait</span>
	<span style="cursor: help">Help</span>
</div>
```

<style type="text/css">
	.cursors span{
		display: inline-block;
		margin: 5px;
		padding: 5px 10px;
		background-color: #d2f4ff;
		border: 2px solid #09c;
	}
</style>

<div class="cursors">
	<span style="cursor: auto">Auto</span>
	<span style="cursor: crosshair">Crosshair</span>
	<span style="cursor: default">Default</span>
	<span style="cursor: pointer">Pointer</span>
	<span style="cursor: move">Move</span>
	<span style="cursor: e-resize">e-resize</span>
	<span style="cursor: ne-resize">ne-resize</span>
	<span style="cursor: nw-resize">nw-resize</span>
	<span style="cursor: n-resize">n-resize</span>
	<span style="cursor: se-resize">se-resize</span>
	<span style="cursor: sw-resize">sw-resize</span>
	<span style="cursor: s-resize">s-resize</span>
	<span style="cursor: w-resize">w-resize</span>
	<span style="cursor: text">Text</span>
	<span style="cursor: wait">Wait</span>
	<span style="cursor: help">Help</span>
</div>