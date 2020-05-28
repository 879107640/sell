package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.hibernate.criterion.Order;
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
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setDetailId("123456780");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://xxxx.png");
        orderDetail.setProductId("123457");
        orderDetail.setProductName("奶茶");
        orderDetail.setProductPrice(new BigDecimal(12));
        orderDetail.setProductQuantity(2);

        OrderDetail result = orderDetailRepository.save(orderDetail);

        Assert.assertNotNull(result);


    }

    @Test
    public void findByOrderId() {

        List<OrderDetail> list = orderDetailRepository.findByOrderId("123456");
        Assert.assertNotEquals(0,list.size());
    }
}