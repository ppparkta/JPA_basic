package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery  extends BaseEntity{
    @Id @GeneratedValue
    private Long id;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

}
