package ru.xpendence.modelmapperdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.xpendence.modelmapperdemo.attributes.OrderStatus;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto extends AbstractDto {

    private String name;
    private Long customerId;
	private OrderStatus orderStatus;
}
