package com.imooc.o2o.dto;

import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;
import lombok.Data;

import java.util.List;
@Data
public class ShopExecution {
    //结果标识
    private int state;
    //状态标识
    private String stateInfo;
    //店铺的数量
    private int count;


    private Shop shop;

    private List<Shop> shopList;
    //店铺操作失败时使用的构造器
    public ShopExecution(ShopStateEnum stateEnum){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
    }
    //店铺操作成功的构造器
    public ShopExecution(ShopStateEnum stateEnum,Shop shop){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.shop=shop;
    }

    //店铺操作成功的构造器，返回列表
    public ShopExecution(ShopStateEnum stateEnum,List<Shop> shopList){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.shopList=shopList;
    }


}
