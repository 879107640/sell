package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import com.imooc.repository.ProductCategoryRepository;
import com.imooc.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository ;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryRepository.getOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryList);
    }

    @Override
    public ProductCategory save(ProductCategory pc) {
        return productCategoryRepository.save(pc);
    }
}
