package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService ;

    @Test
    public void findOne() {
        ProductInfo result = productInfoService.findOne("123456");
        Assert.assertNotNull(result);
    }

    @Test
    public void findUpAll() {
        Assert.assertNotEquals(0,productInfoService.findUpAll().size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0,3);
        Page<ProductInfo> page = productInfoService.findAll(pageRequest);
        System.out.println(page.getTotalElements());
    }

    @Test
    public void save() {

        ProductInfo pi = new ProductInfo() ;
        pi.setProductId("123458");
        pi.setProductName("棒棒冰");
        pi.setProductPrice(new BigDecimal(0.50));
        pi.setProductStock(1000);
        pi.setProductDescription("it is very cool");
        pi.setProductIcon("1.jpg");
        pi.setProductStatus(ProductStatusEnum.UP.getCode());
        pi.setCategoryType(3);

        ProductInfo productInfo = productInfoService.save(pi);
        Assert.assertNotNull(productInfo);
    }
}