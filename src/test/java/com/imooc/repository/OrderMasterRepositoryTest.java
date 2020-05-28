package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
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
public class OrderMasterRepositoryTest {


    @Autowired
    private OrderMasterRepository orderMasterRepository;

    private final String OpenID="123";

    @Test
    public void saveOrderMaster(){
        OrderMaster orderMaster = new OrderMaster();

        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("名字2");
        orderMaster.setBuyerPhone("15911111111");
        orderMaster.setBuyerAddress("上海市");
        orderMaster.setBuyerOpenid(OpenID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = new PageRequest(0,1);

        Page <OrderMaster>page = orderMasterRepository.findByBuyerOpenid(OpenID,pageRequest);
        Assert.assertNotEquals(0,page.getTotalPages());
//        System.out.println(page.getTotalElements());
    }
}