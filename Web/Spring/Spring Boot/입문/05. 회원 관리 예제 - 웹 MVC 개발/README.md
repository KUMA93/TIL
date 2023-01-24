# 회원 관리 예제 - 웹 MVC 개발

## 회원 웹 기능 - 홈 화면 추가

* [controller/HomeController.java](./../hello-spring/src/main/java/hello/hellospring/controller/HomeController.java) - 홈 컨트롤러 추가
```java
package hello.hellospring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
    return "home";
    }
}
```

* [resources/templates/home.html](./hello-spring/src/main/resources/templates/home.html) - 회원 관리용 홈
```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<body>
<div class="container">
    <div>
        <h1>Hello Spring</h1>
        <p>회원 기능</p>
        <p>
            <a href="/members/new">회원 가입</a>
            <a href="/members">회원 목록</a>
        </p>
    </div>
</div> <!-- /container -->

</body>
</html>
```

## 회원 웹 기능 - 등록

* [controller/MemberController.java](../hello-spring/src/main/java/hello/hellospring/controller/MemberController.java) - 회원 등록 폼 컨트롤러
```java
@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Get 방식으로 들어올 때
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm.html";
    }

    // Post 방식으로 들어올 때 - 회원 컨트롤러에서 회원을 셀제 등록하는 기능
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
}
```

* [controller/MemberFrom.java](./../hello-spring/src/main/java/hello/hellospring/controller/MemberForm.java) - 회원 등록 화면에서 데이터를 전달 받을 폼 객체
```java
public class MemberForm {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

* [resources/templates/members/createMemberForm.html](./../hello-spring/src/main/resources/templates/members/createMemberForm.html) - 회원 등록 폼 HTML
```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<body>
<div class="container">
    <form action="/members/new" method="post">
        <div class="form-group">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" placeholder="이름을
입력하세요">
        </div>
        <button type="submit">등록</button>
    </form>
</div> <!-- /container -->
</body>
</html>
```

## 회원 관리 예제 - 조회

* [controller/MemberController.java](../hello-spring/src/main/java/hello/hellospring/controller/MemberController.java) - 회원 컨트롤러에서 조회 기능 추가
```java
@GetMapping("/members")
public String list(Model model) {
    List<Member> members = memberService.findMembers();
    model.addAttribute("members", members);
    return "members/memberList";
}
```

* [resources/templates/members/memberList.html](../hello-spring/src/main/resources/templates/members/memberList.html) - 회원 리스트 HTML, 타임리프문법으로 입력 받은 회원의 목록을 java의 for each문과 유사한 방식으로 출력한다.
```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<body>
<div class="container">
    <div>
        <table>
            <thead>
            <tr>
                <th>#</th>
                <th>이름</th>
            </tr>
            </thead>
            <tbody>
            <tr th:each="member : ${members}">
                <td th:text="${member.id}"></td>
                <td th:text="${member.name}"></td>
            </tr>
            </tbody>
        </table>
    </div>
</div> <!-- /container -->
</body>
</html>
```

