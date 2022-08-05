## 개요
* 〈li〉〈/li〉 태그는 list의 약자로, 목록을 만드는 태그이다.
* 이 태그는 단독으로 쓰이지 않으며 〈ul〉〈/ul〉 혹은 〈ol〉〈/ol〉 태그 내부에 들어간다.
  * 〈ol〉 태그는 번호를 메겨 순서가 있는 (ordered list) 목록을 만든다.
  * 〈ul〉 태그는 순서없이 모양으로 (unordered list) 목록을 만든다.
* 〈li〉 태그는 단순히 리스트 나열 뿐만 아니라 메뉴등을 만들때도 사용한다.

## 사용법
```html
<ol>
	<li>목록1</li>
	<li>목록2</li>
</ol>
```
* 예제
    ```html
    <html>
        <body>
            <ol>
                <li>목록1</li>
                <li>목록2</li>
            </ol>

            <ul>
                <li>목록1</li>
                <li>목록2</li>
                <li>목록3</li>
                <ol>
                    <li>목록3-1</li>
                    <li>목록3-2</li>
                </ol>
            </ul>
        </body>
    </html>
    ```
    <html>
        <body>
            <ol>
                <li>목록1</li>
                <li>목록2</li>
            </ol>
            <ul>
                <li>목록1</li>
                <li>목록2</li>
                <li>목록3</li>
                <ol>
                    <li>목록3-1</li>
                    <li>목록3-2</li>
                </ol>
            </ul>
        </body>
    </html>