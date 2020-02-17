package ru.xpendence.modelmapperdemo.service;

import ru.xpendence.modelmapperdemo.dto.CustomerDto;
import ru.xpendence.modelmapperdemo.entity.Customer;

public interface CustomerService {

    Customer save(Customer dto);

    Customer get(Long id);
}
