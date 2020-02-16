package ru.xpendence.modelmapperdemo.dto;

import lombok.*;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UnicornDto extends AbstractDto {

    private String name;
    private List<DroidDto> droids;
    private String color;
}
