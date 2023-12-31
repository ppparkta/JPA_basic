package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ORDERS")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID")
    private Member member;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="DELIVERY_ID")
    private Delivery delivery;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
    private LocalDateTime orderDate; //order_date, ORDER_DATE
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
}
