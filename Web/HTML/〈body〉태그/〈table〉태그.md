## 개요
* 〈table〉 태그는 HTML 문서에서 표를 만드는 태그이다.
* 행과 열을 표현하기 위해 〈tr〉, 〈td〉등의 태그와 함께 작성하게 된다.
* 예전에는 웹 페이지의 레이아웃을 구성할 때, 〈table〉 태그를 이용하여 많이 구성하였는데 적당한 사용 방법이 아니므로 `레이아웃 구성시에는 〈div〉 태그와 CSS를 이용`한다.

* 〈tr〉태그는 표의 행을 나타낸다.
* 〈td〉태그는 표의 열을 나타내며, 〈tr〉 태그 하위에 위치한다.
* 예제
    ```html
    <table>
        <tr>
            <td>섹션1</td>
            <td>섹션2</td>
        </tr>
        <tr>
            <td>섹션3</td>
            <td>섹션4</td>
        </tr>
        <tr>
            <td>섹션4</td>
            <td>섹션5</td>
        </tr>
    </table>
    ```
    <table>
        <tr>
            <td>섹션1</td>
            <td>섹션2</td>
        </tr>
        <tr>
            <td>섹션3</td>
            <td>섹션4</td>
        </tr>
        <tr>
            <td>섹션4</td>
            <td>섹션5</td>
        </tr>
    </table>

## thead
* 일반적인 표는 제목 줄을 가지고 있는 경우가 많다.
* 〈table〉 태그도 제목 줄을 지원하며, 〈thead〉, 〈tbody〉, 〈th〉 태그를 사용하여 구현한다.

  * 〈thead〉 태그는 표의 제목 영역을 나타낸다. 〈table〉 하위, 〈tr〉 상위에 위치한다.
  * 〈tbody〉 태그는 표의 본문 영역을 나타낸다. 〈thead〉와 같은 위치에 존재한다.
  * 〈th〉 태그는 제목 셀을 나타낸다. 〈td〉 태그 대신 사용한다.
* 예제
    ```html
    <table>
        <thead>
            <tr>
                <th>학교</th>
                <th>창립년도</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>서울대학교</td>
                <td>1946</td>
            </tr>
            <tr>
                <td>고려대학교</td>
                <td>1905</td>
            </tr>
            <tr>
                <td>연세대학교</td>
                <td>1885</td>
            </tr>
        </tbody>
    </table>
    ```
    <table>
        <thead>
            <tr>
                <th>학교</th>
                <th>창립년도</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>서울대학교</td>
                <td>1946</td>
            </tr>
            <tr>
                <td>고려대학교</td>
                <td>1905</td>
            </tr>
            <tr>
                <td>연세대학교</td>
                <td>1885</td>
            </tr>
        </tbody>
    </table>

## rowspan, colspan
* 표는 셀 병합을 통해 더 보기 좋게 만들기도 하는데, 〈table〉 태그에서는 rowspan과 colspan 이라는 속성을 통해 병합 기능을 제공한다.
  * colspan은 〈td〉태그에서 사용하며, 열을 확장한다. (좌우로)
  * rowspan은 〈td〉태그에서 사용하며, 행을 확장한다. (상하로)
* 예제
    ```html
    <table>
        <tr>
            <td colspan="2">2x1 셀</td>
        </tr>
        <tr>
            <td>1x1 셀</td>
            <td>1x2 셀</td>
        </tr>
    </table>
    ```
    <table>
        <tr>
            <td colspan="2">2x1 셀</td>
        </tr>
        <tr>
            <td>1x1 셀</td>
            <td>1x2 셀</td>
        </tr>
    </table>

* 예제2
    ```html
    <table>
        <tr>
            <td rowspan="2">1x2 셀</td>
            <td>1x1 셀</td>
        </tr>
        <tr>
            <td>1x1 셀</td>
        </tr>
    </table>
    ```
    <table>
        <tr>
            <td rowspan="2">1x2 셀</td>
            <td>1x1 셀</td>
        </tr>
        <tr>
            <td>1x1 셀</td>
        </tr>
    </table>