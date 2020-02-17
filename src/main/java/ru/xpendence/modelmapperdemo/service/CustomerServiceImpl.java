package ru.xpendence.modelmapperdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.xpendence.modelmapperdemo.dto.CustomerDto;
import ru.xpendence.modelmapperdemo.entity.Customer;
import ru.xpendence.modelmapperdemo.mapper.CustomerMapper;
import ru.xpendence.modelmapperdemo.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Customer save(Customer c) {
        return repository.save(c);
    }

    @Override
    public Customer get(Long id) {
        return repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Unable to get customer from Database by id " + id));
    }
}
