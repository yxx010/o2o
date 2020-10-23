package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;
    @Test
    public void testQueryShop(){
        Shop shop=new Shop();
        shop=shopDao.queryByShopId(1);
        System.out.println(shop);
    }
    @Test
    public void testQueryShopList(){
        Shop shopCondition=new Shop();
        PersonInfo owner=new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        List<Shop> shopList=shopDao.queryShopList(shopCondition,0,5);
        int count=shopDao.queryShopCount(shopCondition);
        System.out.println("店铺列表的大小："+shopList.size());
        System.out.println("店铺总数："+count);
        owner.setUserId(null);
        shopCondition.setOwner(owner);
        shopList=shopDao.queryShopList(shopCondition,0,5);
        count=shopDao.queryShopCount(shopCondition);
        System.out.println("店铺列表的大小："+shopList.size());
        System.out.println("店铺总数："+count);
    }
    @Test
    //@Ignore //不执行
    public void testInsertShop(){
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
        shop.setShopName("测试的店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(0);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1, effectedNum);
        System.out.println(shop.getShopId());
    }

    @Test
    public void testUpdateShop(){
        Shop shop=new Shop();
        shop.setShopId(1L);
        shop.setShopName("修改测试的店铺");
        shop.setShopDesc("修改备注");
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1, effectedNum);
        System.out.println(shop.getShopId());
    }
}
