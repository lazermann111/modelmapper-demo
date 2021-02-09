package ru.xpendence.modelmapperdemo.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.*;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDto extends AbstractDto {

    private String name;
    @ApiModelProperty(value = "list of customer's orders")
    private List<OrderDto> orders;
}
