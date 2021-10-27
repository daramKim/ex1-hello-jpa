package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {

        // 데이터베이스 설정정보 : persistence.xml에 있는 정보랑 매칭.
        // 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 엔티티 매니저는 쓰레드간에 공유X (사용하고 버려야 한다).
        EntityManager em = emf.createEntityManager();

        // jpa 모든 작업은 트랜잭션 내에서 이루어져야한다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // code
        try{
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");

            em.persist(member); // 저장
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }

        // end
        emf.close();

    }
}
