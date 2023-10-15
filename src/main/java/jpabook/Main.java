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
            Book book = new Book();
            book.setName("jPa");
            book.setAuthor("영한T");
            em.persist(book);
            et.commit();
        }catch(Exception e){
            et.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}