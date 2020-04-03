package com.xk.staff;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: gxl
 * @Date: 2020/4/3 4:08 下午
 */
@Configuration
public class StaffConfig {
    @Bean //配置分页插件
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}