package com.spring.dbs.entity.order;

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
 * @author cs12110 create at 2020-03-28 12:29
 * <p>
 * @since 1.0.0
 */
@Data
@TableName(value = "t_order_info")
public class OrderInfo {

    @TableId(type= IdType.AUTO)
    private Long id;
    private String orderNo;
    private String productCode;
    private BigDecimal price;
    private Date createTime;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
