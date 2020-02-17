package ru.xpendence.modelmapperdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xpendence.modelmapperdemo.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
