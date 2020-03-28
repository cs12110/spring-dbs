package com.spring.dbs.conf.properties;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-28 12:12
 * <p>
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "datasource.order")
public class OrderDataSourceProperties extends BasicDataSourceProperties {

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
