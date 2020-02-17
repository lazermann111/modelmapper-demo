package ru.xpendence.modelmapperdemo.service;

import ru.xpendence.modelmapperdemo.dto.CustomerDto;
import ru.xpendence.modelmapperdemo.entity.Customer;

public interface CustomerService {

	CustomerDto save(Customer dto);

	CustomerDto get(Long id);
}
