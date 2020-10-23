package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Shop;
import jdk.nashorn.internal.runtime.SharedPropertyMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {
    /**
     *
     * @param shopCondition
     * @param rowIndex 从第几行开始取
     * @param pageSize
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition")Shop shopCondition,@Param("rowIndex") int rowIndex,@Param("pageSize") int pageSize);

    /**
     * @param shopCondition
     * @return
     */
    int queryShopCount(@Param("shopCondition")Shop shopCondition);
    /**
     * 按店铺id查询店铺
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
