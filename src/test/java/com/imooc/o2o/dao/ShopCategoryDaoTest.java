package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Test
    public void testShopCategoryDao(){
        List<ShopCategory> list=shopCategoryDao.queryShopCategory(new ShopCategory());
        //查询parent is not null的
        assertEquals(13,list.size());

        ShopCategory shopCategoryCondition=new ShopCategory();
        ShopCategory shopCategory1=new ShopCategory();
        shopCategory1.setShopCategoryId(12L);
        shopCategoryCondition.setParent(shopCategory1);

        list=shopCategoryDao.queryShopCategory(shopCategoryCondition);
        assertEquals(3,list.size());
        System.out.println(list.get(0).getShopCategoryName());

    }
}
