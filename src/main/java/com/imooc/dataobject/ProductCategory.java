package com.imooc.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.Date;

/*
*
* springboot采用表名对应的类名，Product_Category,且忽略下划线
* 如果需要不同，采用@Table（name = '表名'）的写法
* */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Entity
@Proxy(lazy = false)
//@DynamicUpdate   //如果添加updatetime，由于会取出该时间，但是不会修改，导致不会实现自动修改，则添加该字段。
@Data  //lombak 自动补全get、set、tostring方法 ， 也有@Setter等的写法
public class ProductCategory implements Serializable{

    //类目id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    //类目名字
    private String categoryName;

    //类目编号
    private Integer categoryType;

   // private Date createTime;

    //private Date updateTime;

    public ProductCategory() {
    }

    public  ProductCategory(String categoryName,Integer categoryType){
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
