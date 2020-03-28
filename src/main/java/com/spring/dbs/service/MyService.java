package com.spring.dbs.service;

import com.spring.dbs.entity.order.OrderInfo;
import com.spring.dbs.entity.product.ProductInfo;
import com.spring.dbs.mapper.order.OrderMapper;
import com.spring.dbs.mapper.product.ProductMapper;
import com.spring.dbs.model.response.InfoResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-28 12:42
 * <p>
 * @since 1.0.0
 */
@Service
public class MyService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private ProductMapper productMapper;


    public InfoResponse findInfo(String orderNo) {
        InfoResponse response = new InfoResponse();

        OrderInfo orderInfo = orderMapper.queryByOrderNo(orderNo);
        response.setOrderInfo(orderInfo);

        if (null != orderInfo) {
            ProductInfo productInfo = productMapper.queryInfo(orderInfo.getProductCode());
            response.setProductInfo(productInfo);
        }

        return response;
    }


    @Transactional(
            value = "orderTxManager",
            rollbackFor = RuntimeException.class
    )
    public InfoResponse saveOrderInfo(boolean rollback) {
        InfoResponse response = new InfoResponse();
        String unicode = String.valueOf(System.currentTimeMillis());

        OrderInfo orderInfo = createOrderInfo(unicode);
        orderMapper.insert(orderInfo);
        response.setOrderInfo(orderInfo);

        if (rollback) {
            throw new RuntimeException("Just fuck throw an exception");
        }
        return response;
    }

    @Transactional(
            value = "productTxManager",
            rollbackFor = RuntimeException.class
    )
    public InfoResponse saveProductInfo(boolean rollback) {
        InfoResponse response = new InfoResponse();
        String unicode = String.valueOf(System.currentTimeMillis());

        ProductInfo productInfo = createProductInfo(unicode);
        productMapper.insert(productInfo);
        response.setProductInfo(productInfo);
        if (rollback) {
            throw new RuntimeException("Just fuck throw an exception");
        }
        return response;
    }


    /**
     * 多数据源事务有问题,卧槽
     *
     * @param rollback 是否回滚
     * @return InfoResponse
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public InfoResponse saveBothInfo(boolean rollback) {
        InfoResponse response = new InfoResponse();
        String unicode = String.valueOf(System.currentTimeMillis());

        OrderInfo orderInfo = createOrderInfo(unicode);
        orderMapper.insert(orderInfo);
        response.setOrderInfo(orderInfo);

        ProductInfo productInfo = createProductInfo(unicode);
        productMapper.insert(productInfo);
        response.setProductInfo(productInfo);
        if (rollback) {
            throw new RuntimeException("Just fuck throw an exception");
        }
        return response;

    }

    private OrderInfo createOrderInfo(String code) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo("O" + code);
        orderInfo.setPrice(BigDecimal.valueOf(10.05));
        orderInfo.setProductCode("P" + code);
        orderInfo.setCreateTime(new Date());

        return orderInfo;
    }

    private ProductInfo createProductInfo(String code) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCreateTime(new Date());
        productInfo.setPrice(BigDecimal.valueOf(100.04));
        productInfo.setProductCode("P" + code);
        productInfo.setProductName("orange");
        productInfo.setStock(100);

        return productInfo;
    }
}
