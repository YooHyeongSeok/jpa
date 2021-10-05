package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        /*Application이 올라가면 딱 1개만 생성*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /*하나의 트랜잭션에서만 움직여야 한다. ::: em*/
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            /*save*/
            /*Member member = new Member();
            member.setId(2L);
            member.setName("hellow2");
            em.persist(member);*/

            /*update*/
            /*Member findMember = em.find(Member.class, 1L);
            System.out.println("JpaMain.main :: " + findMember.getName());
            findMember.setName("updHellow");*/

            /*jpql*/
            List<Member> m =
                    em.createQuery("select m from Member as m", Member.class)
                            .setFirstResult(0)
                            .setMaxResults(8)
                            .getResultList();

            for (Member mm : m) {
                System.out.println("JpaMain.m :::" + mm.getUsername());
            }

            tx.commit();

        } catch (Exception e) {
            //익셉션 발생시 롤백
            tx.rollback();
        } finally {
            //자원 반환
            em.close();
        }
        //WAS 종료 시 반환
        emf.close();
    }
}
