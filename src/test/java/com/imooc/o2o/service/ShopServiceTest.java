package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;
    @Test
    public void testQueryShopListAndCount(){
        Shop shopCondition=new Shop();
        ShopCategory sc=new ShopCategory();
        sc.setShopCategoryId(1L);
        shopCondition.setShopCategory(sc);
        ShopExecution se= shopService.getShopList(shopCondition,1,20);
        System.out.println("店铺列表第1页数量："+se.getShopList().size());
        System.out.println("该分类店铺总数："+se.getCount());
        se= shopService.getShopList(shopCondition,2,20);
        System.out.println("店铺列表第2页数量："+se.getShopList().size());

    }
    @Test
    public void testAddShop(){
        Shop shop=new Shop();
        PersonInfo owner=new PersonInfo();
        Area area=new Area();
        ShopCategory shopCategory=new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺1");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(0);
        shop.setAdvice("审核中");
        File shopImg=new File("/Users/yangxiaoxiao/Desktop/1.jpg");
        InputStream inputStream= null;
        try {
            inputStream = new FileInputStream(shopImg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ShopExecution se=shopService.addShop(shop,inputStream,shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }
    @Test
    public void testModifyShop() throws FileNotFoundException {
        Shop shop=new Shop();
        shop.setShopId(1L);
        shop.setShopName("店铺名称修改");
        File shopImg=new File("/Users/yangxiaoxiao/Desktop/1new.jpg");
        InputStream is=new FileInputStream(shopImg);
        ShopExecution shopExecution=shopService.modifyShop(shop,is,"1new.jpg");
        System.out.println(shopExecution.getShop().getShopImg());
    }
}
