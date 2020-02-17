package ru.xpendence.modelmapperdemo.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.xpendence.modelmapperdemo.attributes.OrderStatus;

import javax.persistence.*;

@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order extends AbstractEntity {

    private String name;
    private Customer customer;
	private OrderStatus orderStatus;

    public Order(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    public Customer getCustomer() {
        return customer;
    }


	@Column(name = "orderStatus")
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
}
