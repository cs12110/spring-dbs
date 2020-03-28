package com.spring.dbs.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.dbs.entity.order.OrderInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/1 14:25
 * <p>
 * since: 1.0.0
 */
public interface OrderMapper extends BaseMapper<OrderInfo> {


    /**
     * query by orderNo
     *
     * @param orderNo orderNo
     * @return OrderInfo
     */
    OrderInfo queryByOrderNo(@Param("orderNo") String orderNo);
}
