package com.baizhi.vo;

import com.baizhi.entity.Production;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Item {
    private Production production;
    private Integer count;
    private Double subTotal;
}
