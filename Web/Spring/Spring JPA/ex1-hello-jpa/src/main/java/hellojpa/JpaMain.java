package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 저장

//            Member member = new Member();
//
//            member.setId(2L);
//            member.setName("HelloB");
//
//            em.persist(member);


            // 조회

//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());


            // 삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);


            // 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");


            // JPQL
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            // 비영속 상태, 단순 멤버 객체 생성
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("HelloJPA");

            // 영속 상태, persist에서 DB에 쿼리가 나가는 것이 아니다.(BEFORE와 AFTER사이에 뭐리문이 위치하지 않고 나중에 나온다.)
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");




            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
