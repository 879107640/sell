package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//domain,主键
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{

    public List<ProductCategory> findByCategoryTypeIn (List<Integer> categoryList);

}
