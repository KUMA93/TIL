# 스프링 DB 접근기술

# 순수 JDBC 추가 

## 환경설정
* build.gradle - jdbc, h2 DB 관련 라이브러리 추가
```java
implementation 'org.springframework.boot:spring-boot-starter-jdbc'
runtimeOnly 'com.h2database:h2'
```
* application.properties - 스프링 부트 데이터베이스 연결 설정 추가
```java
spring.datasource.url=jdbc:h2:tcp://localhost/~/test
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
```

## JDBC 리포지토리 구현
* 코드가 많이 기므로 [JdbcMemberRepository.java](../hello-spring/src/main/java/hello/hellospring/repository/JdbcMemberRepository.java)을 눌러 확인한다.
* 20년 전에 이런식으로 직접 코딩했다는 사실정도만 알고 넘어가면 된다.

## 스프링 설정 변경
* [SpringConfig.java](../hello-spring/src/main/java/hello/hellospring/SpringConfig.java)에 return new JdbcMemberRepository(dataSource); 으로 리턴값을 바꾼다.
* DataSource는 데이터베이스 커넥션을 획득할 때 사용하는 객체다. 
* 스프링 부트는 데이터베이스 커넥션정보를 바탕으로 DataSource를 생성하고 스프링 빈으로 만들어둔다. 그래서 DI를 받을 수 있다.

# 스프링 통합 테스트
* @SpingBootTest 어노테이션을 붙여주면 별다른 수정없이 스프링 컨테이너와 테스트를 함께 실행하여 전에 사용했던 테스트 코드 그대로 통합 테스트를 해볼 수 있다.
* 이전에 @AfterEach 어노테이션을 붙여 메모리를 비워주는 작업은 @Transactional 어노테이션을 붙여 테스트 시작 전에 트랜잭션을 시작하고 테스트 완료 후에 항상 롤백시킴으로 간단히 DB를 비워줄 수 있다.
* [MemberServiceIntergrationTest](../hello-spring/src/test/java/hello/hellospring/service/MemberServiceIntergrationTest.java)

# 스프링 JdbcTemplate
## 환경 설정
* 순수 Jdbc와 동일한 환경설정을 가진다.
* 스프링 JdbcTemplate 과 MyBatis 같은 라이브러리는 JDBC API에서 본 반복 코드를 대부분 제거해준다. 하지만 SQL은 직접 작성해야 한다.

## JdbcTemplate 리포지토리 구현
* [JdbcTemplateMemberRepository](../hello-spring/src/main/java/hello/hellospring/repository/JdbcTemplateMemberRepository.java)

## 스프링 설정 변경
* [SpringConfig.java](../hello-spring/src/main/java/hello/hellospring/SpringConfig.java)에 return new JdbcTemplateMemberRepository(dataSource); 으로 리턴값을 바꾼다.

# JPA
## 환경 설정
* build.gradle - jpa, h2 데이터베이스 관련 라이브러리 추가 (jpa 라이브러리는 내부에 jdbc 관련 라이브러리를 포함한다. 따라서 앞서 사용한 jdbc 라이브러리는 주석처리했다.)
```java
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
runtimeOnly 'com.h2database:h2'
```
* application.properties - sql문을 출력해주는 속성과 테이블 자동생성 속성을 추가해준다.(이미 테이블이 만들어져있기 때문에 none으로 설정)
```java
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=none
```
* [SpringConfig.java](../hello-spring/src/main/java/hello/hellospring/SpringConfig.java) 에서 JPA를 사용하도록 스프링 설정 변경
```java
@Bean
public MemberRepository memberRepository() {
//  return new MemoryMemberRepository();
//  return new JdbcMemberRepository(dataSource);
//  return new JdbcTemplateMemberRepository(dataSource);
    return new JpaMemberRepository(em);
}
```
* [MemberService.java](../hello-spring/src/main/java/hello/hellospring/service/MemberService.java) - 서비스 계층에 트랜잭션 추가
```java
import org.springframework.transaction.annotation.Transactional
@Transactional
public class MemberService {}
```

## JPA 엔티티 매핑
* [Member.java](../hello-spring/src/main/java/hello/hellospring/domain/Member.java) - @Entity, @Id, @GeneratedValue 어노테이션을 사용해 엔티티를 매핑해준다.

