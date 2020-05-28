package com.imooc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

//    private final Logger logger = LoggerFactory.getLogger(Logger.class);

    @Test
    public void Test1(){
        String username = "SELL";
        String password = "123456";
        log.info("--------info");
        log.debug("------debug");
        log.error("------error");
        log.info("username: {} ， password: {} " ,username,password);


    }
}
