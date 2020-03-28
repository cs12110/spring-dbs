package com.spring.dbs.mapper.product;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.dbs.entity.product.ProductInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/1 14:25
 * <p>
 * since: 1.0.0
 */
public interface ProductMapper extends BaseMapper<ProductInfo> {

    /**
     * query by productCode
     *
     * @param productCode productCode
     * @return ProductInfo
     */
    ProductInfo queryInfo(@Param("productCode") String productCode);
}
