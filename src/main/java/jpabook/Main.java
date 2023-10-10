package jpabook;

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
            Order order = new Order();
            OrderItem orderItem = new OrderItem();

            //연관관계 편의 메소드 생성
            order.addOrderItem(orderItem);

            em.persist(orderItem);
            em.persist(order);

            // 오더아이템 -> 오더 참조 -> 출력 (연관관계의 주인)
            System.out.println("Orderitem Id = " + orderItem.getOrder().getId());
            // 오더 -> 오더아이템 참조 -> 출력 (연관관계의 주인 아님, 역참조)
            System.out.println("In Order, Orderitem Id = " + order.getOrderItems().get(0).getId());

            et.commit();
        }catch(Exception e){
            et.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}