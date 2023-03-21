package com.ysan.mp.service.impl;

import com.ysan.mp.pojo.Product;
import com.ysan.mp.mapper.ProductMapper;
import com.ysan.mp.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author ysan
 * @since 2023-02-16
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
