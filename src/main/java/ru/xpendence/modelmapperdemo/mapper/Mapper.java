package ru.xpendence.modelmapperdemo.mapper;

import ru.xpendence.modelmapperdemo.dto.AbstractDto;
import ru.xpendence.modelmapperdemo.entity.AbstractEntity;

public interface Mapper<E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);
}
