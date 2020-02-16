package ru.xpendence.modelmapperdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xpendence.modelmapperdemo.entity.Unicorn;


@Repository
public interface UnicornRepository extends JpaRepository<Unicorn, Long> {
}
