package ru.xpendence.modelmapperdemo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.xpendence.modelmapperdemo.dto.CustomerDto;
import ru.xpendence.modelmapperdemo.entity.Customer;


@Component
public class CustomerMapper extends AbstractMapper<Customer, CustomerDto> {

    @Autowired
    public CustomerMapper() {
        super(Customer.class, CustomerDto.class);
    }
}
