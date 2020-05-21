package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ShopCategoryServiceTest extends BaseTest {
    @Autowired
    ShopCategoryService shopCategoryService;
    @Test
    public void testShopCategoryService(){
        ShopCategory shopCategory=new ShopCategory();
        ShopCategory parent=new ShopCategory();
        parent.setShopCategoryId(12L);
        shopCategory.setParent(parent);
        List<ShopCategory> list=shopCategoryService.getShopCategoryList(shopCategory);
        assertEquals(3,list.size());
        System.out.println(list);
    }
}
