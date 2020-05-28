package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryService {


    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryList);

    ProductCategory save(ProductCategory pc );
}
