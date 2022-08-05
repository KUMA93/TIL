## 개요
* 〈form〉 태그는 웹 페이지에서의 입력 양식을 의미한다.
* 로그인 창이나, 회원가입 폼 등이 이에 해당된다.

* 텍스트 필드에 글자를 입력하거나, 체크박스나 라디오 버튼을 클릭하고 제출 버튼을 누르면 백엔드 서버에 양식이 전달되어 정보를 처리하게 된다.

* 실제로 백엔드 코드와 함께 〈form〉을 사용하기 위해서는 다음 속성들이 사용됩니다.
  * name: 폼의 이름
  * action: 폼 데이터가 전송되는 백엔드 url
  * method: 폼 전송 방식 (GET / POST)
  * …

## input
* 〈form〉 태그는 전체 양식을 의미하며, 화면에 보이지 않는 추상적인 태그이다.
* 실제로 사용자가 양식을 입력하기 위한 태그는 〈input〉 태그 등이 사용된다.

* type 속성을 통해 종류를 나타내며, name을 통해 데이터의 이름, value를 통해 기본 값을 지정한다.

### type
  * text: 일반 문자
  * password: 비밀번호
  * button: 버튼
  * submit: 양식 제출용 버튼
  * reset: 양식 초기화용 버튼
  * radio: 한개만 선택할 수 있는 컴포넌트
  * checkbox: 다수를 선택할 수 있는 컴포넌트
  * file: 파일 업로드
  * hidden: 사용자에게 보이지 않는 숨은 요소
  * …

### 예제
    ```html
    <form>
        <p>
            <strong>아이디</strong>
            <input type="text" name="name" value="아이디 입력">
        </p>
        <p>
            <strong>비밀번호</strong>
            <input type="password" name="password" value="비밀번호 입력">
        </p>
        <p>
            <strong>성별</strong>
            <input type="radio" name="gender" value="M">남자
            <input type="radio" name="gender" value="F">여자
        </p>
        <p>
            <strong>응시분야</strong>
            <input type="checkbox" name="part" value="eng">영어
            <input type="checkbox" name="part" value="math">수학
        </p>
        <p>
            <input type="submit" value="제출">
        </p>
    </form>
    ```       
<form>
    <p>
        <strong>아이디</strong>
        <input type="text" name="name" value="아이디 입력">
    </p>
    <p>
        <strong>비밀번호</strong>
        <input type="password" name="password" value="비밀번호 입력">
    </p>
    <p>
        <strong>성별</strong>
        <input type="radio" name="gender" value="M">남자
        <input type="radio" name="gender" value="F">여자
    </p>
    <p>
        <strong>응시분야</strong>
        <input type="checkbox" name="part" value="eng">영어
        <input type="checkbox" name="part" value="math">수학
    </p>
    <p>
        <input type="submit" value="제출">
    </p>
</form>


## select, option
* 〈select〉 및 〈option〉은 드롭다운 리스트를 만드는 태그이다.
* 예제
    ```html
    <select>
        <option value="ktx">KTX</option>
        <option value="itx">ITX 새마을</option>
        <option value="mugung">무궁화호</option>
    </select>
    ```
    <select>
        <option value="ktx">KTX</option>
        <option value="itx">ITX 새마을</option>
        <option value="mugung">무궁화호</option>
    </select>
