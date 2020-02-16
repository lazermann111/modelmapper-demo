package ru.xpendence.modelmapperdemo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.xpendence.modelmapperdemo.dto.UnicornDto;
import ru.xpendence.modelmapperdemo.entity.Unicorn;


@Component
public class UnicornMapper extends AbstractMapper<Unicorn, UnicornDto> {

    @Autowired
    public UnicornMapper() {
        super(Unicorn.class, UnicornDto.class);
    }
}
