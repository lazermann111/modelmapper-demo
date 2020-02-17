package ru.xpendence.modelmapperdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.xpendence.modelmapperdemo.dto.CustomerDto;
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
    public CustomerDto save(CustomerDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public CustomerDto get(Long id) {
        return mapper.toDto(repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Unable to get customer from Database by id " + id)));
    }
}
