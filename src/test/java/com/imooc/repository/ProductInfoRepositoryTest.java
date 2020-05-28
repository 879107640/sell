package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void save(){
        ProductInfo pi = new ProductInfo();
        pi.setProductId("123456");
        pi.setProductName("奶茶");
        pi.setProductPrice(new BigDecimal(12.00));
        pi.setProductStock(100);
        pi.setProductDescription("it is very delicious");
        pi.setProductIcon("1.jpg");
        pi.setProductStatus(1);
        pi.setCategoryType(2);

        ProductInfo productInfo = productInfoRepository.save(pi);
        Assert.assertNotNull(productInfo);

    }

    @Test
    public void findByProductStatus() {

        List<ProductInfo> result = productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0,result.size());
    }
}