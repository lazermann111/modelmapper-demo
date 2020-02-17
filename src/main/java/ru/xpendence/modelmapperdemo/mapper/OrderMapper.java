package ru.xpendence.modelmapperdemo.mapper;

import java.util.Objects;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.xpendence.modelmapperdemo.dto.OrderDto;
import ru.xpendence.modelmapperdemo.entity.Order;
import ru.xpendence.modelmapperdemo.repository.CustomerRepository;

@Component
public class OrderMapper extends AbstractMapper<Order, OrderDto> {

	private final ModelMapper mapper;
	private final CustomerRepository customerRepository;

	@Autowired
	public OrderMapper(ModelMapper mapper, CustomerRepository customerRepository) {
		super(Order.class, OrderDto.class);
		this.mapper = mapper;
		this.customerRepository = customerRepository;
	}

	@PostConstruct
	public void setupMapper() {
		mapper.createTypeMap(Order.class, OrderDto.class)
				.addMappings(m -> m.skip(OrderDto::setCustomerId)).setPostConverter(toDtoConverter());
		mapper.createTypeMap(OrderDto.class, Order.class)
				.addMappings(m -> m.skip(Order::setCustomer)).setPostConverter(toEntityConverter());
	}

	@Override
	public void mapSpecificFields(Order source, OrderDto destination) {
		destination.setCustomerId(getId(source));
	}

	private Long getId(Order source) {
		return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getCustomer().getId();
	}

	@Override
	void mapSpecificFields(OrderDto source, Order destination) {
		destination.setCustomer(customerRepository.findById(source.getCustomerId()).orElse(null));
	}
}
