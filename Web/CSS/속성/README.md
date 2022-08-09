## 개요
* HTML과 비슷하게, CSS도 특정한 기능을 하는들이 미리 정의되어 있으며, 이를 활용하여 태그의 스타일을 정의 할 수 있다.
* `속성: 값` 의 형태로 사용되며, 여러 속성끼리는 `;`를 통해 구분된다.
* 하나의 선택자의 속성들을 한 줄로 쓰든, 여러줄로 나누어 쓰든 상관이 없으며 작업하는 사람들 끼리 정하여 편한대로 사용하면 된다.
```css
선택자{ 속성1: 값1; 속성2: 값2 }
/* or */
선택자{
	속성1: 값1;
	속성2: 값2;
}
```
* Chrome의 디버깅 툴을 이용하면, 특정 태그에 어떤 CSS 속성이 사용되었는지 쉽게 알 수 있다.
* 이를 통해 자신이 모르는 속성을 알 수도 있고, 속성의 사용법을 공부할 수도 있다.

## 목록

* [width, height](./width%2C%20height.md)
* [margin, padding](./margin%2C%20padding.md)
* [color](./color.md)
* [font](./font.md)
* [text-align](./text-align.md)
* [background](./background.md)
* [border](./border.md)
* [visibility](./visibility.md)
* [display](./display.md)
* [float](./float.md)
* [clear](./clear.md)
* [position](./position.md)
* [cursor](./cursor.md)

## 상속
* 어떤 속성들은 부모 태그에 특정 값을 적용하면 하위 태그에도 그 속성들이 그대로 전달되기도 한다. (color, font 등)
* `속성: inherit` 처럼 작성하면 강제로 부모의 속성을 상속받게도 할 수 있다.
