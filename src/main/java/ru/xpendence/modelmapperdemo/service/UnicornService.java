package ru.xpendence.modelmapperdemo.service;

import ru.xpendence.modelmapperdemo.dto.UnicornDto;


public interface UnicornService {

    UnicornDto save(UnicornDto dto);

    UnicornDto get(Long id);
}
