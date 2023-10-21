package jpabook;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try{
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Team team2 = new Team();
            team2.setName("teamB");
            em.persist(team2);

            Member member = new Member();
            member.setUsername("관리자1");
            member.setAge(10);
            member.setTeam(team);
            member.setType(MemberType.ADMIN);
            em.persist(member);

            Member member2 = new Member();
            member2.setUsername("관리자2");
            member2.setAge(10);
            member2.setTeam(team);
            member2.setType(MemberType.ADMIN);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("관리자3");
            member3.setAge(10);
            member3.setTeam(team2);
            member3.setType(MemberType.ADMIN);
            em.persist(member3);

            em.flush();
            em.clear();

//            String query = "select group_concat(m.username) from Member m ";
//            List<String> resultList = em.createQuery(query, String.class).getResultList();
//            String query = "select t.members from Team t";
//            String query = "select m.username from Team t join t.members m";
//            String query = "select m from Member m join fetch m.team";
//            String query = "select distinct t from Team t join fetch t.members";

            int resultCount = em.createQuery("update Member m set m.age= 20")
                    .executeUpdate();

            Member findMem = em.find(Member.class, member.getId());

            System.out.println("findMember = "+findMem.toString());
            et.commit();
        }catch(Exception e){
            et.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}