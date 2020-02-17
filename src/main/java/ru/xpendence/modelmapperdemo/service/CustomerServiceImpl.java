package ru.xpendence.modelmapperdemo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.xpendence.modelmapperdemo.dto.CustomerDto;
import ru.xpendence.modelmapperdemo.entity.Customer;
import ru.xpendence.modelmapperdemo.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CustomerDto save(Customer c) {
        return mapper.map(repository.save(c), CustomerDto.class);
    }

    @Override
    public CustomerDto get(Long id) {
        return mapper.map(repository.findById(id).get(), CustomerDto.class);
    }
}
