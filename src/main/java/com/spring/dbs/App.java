package com.spring.dbs;

import com.alibaba.fastjson.JSON;
import com.spring.dbs.conf.properties.OrderDataSourceProperties;
import com.spring.dbs.conf.properties.ProductDataSourceProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 *
 * 开启事务管理
 * <p>
 *
 * @author cs12110 create at 2020-03-28 12:07
 * <p>
 * @since 1.0.0
 */
@Slf4j
@SpringBootApplication
@EnableTransactionManagement
public class App {

    @Resource
    private OrderDataSourceProperties orderDatasourceProperties;

    @Resource
    private ProductDataSourceProperties productDatasourceProperties;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    @PostConstruct
    public void init() {
        log.info("Function[init] order:{}", JSON.toJSONString(orderDatasourceProperties));
        log.info("Function[init] product:{}", JSON.toJSONString(productDatasourceProperties));
    }
}
