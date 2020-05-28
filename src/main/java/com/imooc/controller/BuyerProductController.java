package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.ProductCategoryService;
import com.imooc.service.ProductInfoService;
import com.imooc.utils.ResultVOutil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/list")
    public ResultVO list(){

        //查出所有上架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

         //通过商品获取所有商家商品的类目TYPE
        List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
        for (ProductInfo productInfo:productInfoList) {
                categoryTypeList.add(productInfo.getCategoryType());
        }

        //jdk8 lambda表达式
        /*List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
                */
        //查询所有的类目
        List <ProductCategory>productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //数据拼装
        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory pcList:productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(pcList.getCategoryName());
            productVO.setCategoryType(pcList.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo piList:productInfoList) {
                if(piList.getCategoryType().equals(productVO.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
//                    productInfoVO.setPorductId(piList.getProductId());
//                    productInfoVO.setProductName(piList.getProductName());
//                    productInfoVO.setProductDescription(piList.getProductDescription());
//                    productInfoVO.setProductIcon(piList.getProductIcon());
//                    productInfoVO.setProductPrice(piList.getProductPrice());
                    //复制相同参数到productInfoVO中
                    BeanUtils.copyProperties(piList,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOutil.success(productVOList);
    }

}
