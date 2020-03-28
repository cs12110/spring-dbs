package com.spring.dbs.entity.product;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-28 12:35
 * <p>
 * @since 1.0.0
 */
@Data
@TableName(value = "t_product_info")
public class ProductInfo {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String productCode;
    private String productName;
    private BigDecimal price;
    private Integer stock;
    private Date createTime;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
