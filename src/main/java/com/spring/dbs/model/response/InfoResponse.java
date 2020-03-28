package com.spring.dbs.model.response;

import com.alibaba.fastjson.JSON;
import com.spring.dbs.entity.order.OrderInfo;
import com.spring.dbs.entity.product.ProductInfo;
import lombok.Data;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-28 14:20
 * <p>
 * @since 1.0.0
 */
@Data
public class InfoResponse {
    private OrderInfo orderInfo;
    private ProductInfo productInfo;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
