package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class OrderItem extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name="ORDER_ITEM_ID")
    private Long id;
//    @Column(name="ORDER_ID")
    @ManyToOne
    @JoinColumn(name="ORDER_ID")
    private Order order;
//    @Column(name="ITEM_ID")
    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private Item item;
    private int orderPrice;
    private int count;

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public Item getItem() {
        return item;
    }
}
