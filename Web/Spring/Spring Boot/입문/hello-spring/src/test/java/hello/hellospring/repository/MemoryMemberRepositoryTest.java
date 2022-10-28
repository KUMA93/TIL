package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 각 테스트가 끝나고 메모리를 비워줄 필요가 있다. MemoryMemberRepository 클래스에 clearStore() 메소드를 구현하고 각테스트 마지막에 불러온다.
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        System.out.println("result = " + (result == member)); // #1 단순 출력.
        Assertions.assertEquals(member, result); // #2 Assertion.assertEquals() 사용. 출력되는 내용은 없지만 값이 다르다면 오류코드가 출력된다.
        assertThat(member).isEqualTo(result); // #3 Assertions.assertThat() 사용
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1); // 마찬가지로 출력되는 내용이 없지만 값이 다르다면 오류코드가 출력
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
