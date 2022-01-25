package com.imooc.o2o.service;

import com.imooc.o2o.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getProductCategoryList(long shopId);
}
