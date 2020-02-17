package ru.xpendence.modelmapperdemo.service;

import ru.xpendence.modelmapperdemo.dto.CustomerDto;


public interface CustomerService {

    CustomerDto save(CustomerDto dto);

    CustomerDto get(Long id);
}
