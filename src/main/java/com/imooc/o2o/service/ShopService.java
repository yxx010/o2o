package com.imooc.o2o.service;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.exceptions.ShopOperationException;

import java.io.File;
import java.io.InputStream;

public interface ShopService {
    ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);
    Shop getByShopId(long shopId);
    ShopExecution modifyShop (Shop shop, InputStream shopImgInputStream,String fileName) throws ShopOperationException;
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) throws ShopOperationException;

}
