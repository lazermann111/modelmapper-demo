package ru.xpendence.modelmapperdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xpendence.modelmapperdemo.entity.Droid;

import java.util.List;


@Repository
public interface DroidRepository extends JpaRepository<Droid, Long> {

    List<Droid> findAllByIdIn(List<Long> ids);
}
