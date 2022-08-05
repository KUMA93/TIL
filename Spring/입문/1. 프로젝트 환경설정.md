# 프로젝트 환경설정

## 스프링 프로젝트 생성
* https://start.spring.io
* 메이븐 프로젝트(Maven Project) / 그레이들 프로젝트(Gradle Project)
  * 메이븐 프로젝트는 필요한 라이브러리를 당겨오고 빌드하는 라이프사이클까지 관리해주는 툴
  * 최근엔 그레이들로 많이 쓰는 추세이다

## 라이브러리 
* Gradle은 의존관계가 있는 라이브러리를 함께 다운로드 한다.
* 스프링 부트 주요 라이브러리
  * spring-boot-starter-web
      * spring-boot-starter-tomcat: 톰캣 (웹서버)
      * spring-webmvc: 스프링 웹 MVC
  * spring-boot-starter-thymeleaf: 타임리프 템플릿 엔진(View)
  * spring-boot-starter(공통): 스프링 부트 + 스프링 코어 + 로깅
      * spring-boot
        * spring-core
      * spring-boot-starter-logging
        * logback, slf4j 
* 테스트 주요 라이브러리
  * spring-boot-starter-test
    * junit: 테스트 프레임워크
    * mockito: 목 라이브러리
    * assertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리
    * spring-test: 스프링 통합 테스트 지원
## MVC
* MVC와 템플릿 엔진(Thymeleaf)
  * MVC: Model, View, Controller
* Controller, Model
  ```java
  package hello.hellospring.controller;

  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.GetMapping;

  @Controller
  public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }
  }
  ```
* 타임리프 사용 부분
  ```html
  <!DOCTYPE HTML>
  <html xmlns:th="http://www.thymeleaf.org">
  <head>
      <title>HELLO</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  <body>
  <p th:text="'안녕하세요. ' + ${data}" >어디서 나타날까</p>
  </body>
  </html>
  ```
## 빌드 후 실행
* On 터미널
1. ./gradlew build
2. cd build/libs
3. java -jar hello-spring-0.0.1-SNAPSHOT.jar
4. 실행 확인