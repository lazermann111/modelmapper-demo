package ru.xpendence.modelmapperdemo.dto;

import lombok.*;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDto extends AbstractDto {

    private String name;
    private List<OrderDto> orders;
}
