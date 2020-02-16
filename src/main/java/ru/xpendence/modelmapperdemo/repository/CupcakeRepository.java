package ru.xpendence.modelmapperdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xpendence.modelmapperdemo.entity.Cupcake;

import java.util.List;


@Repository
public interface CupcakeRepository extends JpaRepository<Cupcake, Long> {

    List<Cupcake> findAllByIdIn(List<Long> ids);
}
