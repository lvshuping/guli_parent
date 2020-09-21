package com.lsp.guli.service.edu.service.impl;

import com.lsp.guli.service.edu.entity.Product;
import com.lsp.guli.service.edu.mapper.ProductMapper;
import com.lsp.guli.service.edu.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsp
 * @since 2020-09-21
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
