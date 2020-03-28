package com.spring.dbs.conf.properties;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-28 12:16
 * <p>
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "datasource.product")
public class ProductDataSourceProperties extends BasicDataSourceProperties {

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
