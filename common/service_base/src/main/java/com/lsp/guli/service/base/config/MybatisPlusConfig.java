package com.lsp.guli.service.base.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 分页插件,个认觉得还是采用pageHelper会更方便些,但是在上个项目中使用pageHelper的时候出现了个问题
 * 分页的每页显示条数会变化,没有按照传进去的参数进行分页暂未知道什么原因,后边使用时注意
 * @author lsp
 * @since 2020/4/1
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.lsp.guli.service.*.mapper")
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
