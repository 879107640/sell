package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory pc = repository.getOne(1);
        System.out.println(pc.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory pc = new ProductCategory("女生最爱榜",4);
        //pc.setCategoryName("女生最爱榜");
        //pc.setCategoryType("3");
        ProductCategory result = repository.save(pc);

    }

    @Test
    @Transactional   //测试数据不会添加到数据库中，会自动回滚
    public void updateTest(){
        ProductCategory pc = repository.getOne(2);
        pc.setCategoryType(3);
        repository.save(pc);
    }

    @Test
    public void deleteTest(){
        ProductCategory pc = new ProductCategory();

        repository.delete(pc);
    }

    @Test
    public void findByCategoryType(){
        List<ProductCategory> list = repository.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        System.out.println(list);
    }
}