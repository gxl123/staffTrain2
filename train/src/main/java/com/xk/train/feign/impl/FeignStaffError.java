package com.xk.train.feign.impl;

import com.xk.train.feign.FeignStaffClient;
import org.springframework.stereotype.Component;

/**
 * @Author: gxl
 * @Date: 2020/4/5 11:43 下午
 * feign熔断机制实现
 */
@Component
public class FeignStaffError implements FeignStaffClient {
    @Override
    public String getPort() {
        return "系统维护中！！！";
    }
}
