package ru.xpendence.modelmapperdemo.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.xpendence.modelmapperdemo.attributes.OrderStatus;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "customers")
@EqualsAndHashCode(callSuper = false)
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends AbstractEntity {

    private String name;
    private List<Order> orders;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
    public List<Order> getOrders() {
        return orders;
    }
}
