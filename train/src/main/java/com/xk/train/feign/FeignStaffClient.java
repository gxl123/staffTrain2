package com.xk.train.feign;

import com.xk.train.entity.Staff;
import com.xk.train.feign.impl.FeignStaffError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author: gxl
 * @Date: 2020/4/5 11:30 下午
 */
@FeignClient(value = "staff",fallback = FeignStaffError.class)
public interface FeignStaffClient {

    @GetMapping("/staff/getPort")
    public String getPort();

    @GetMapping("/staff/findAll")
    public List<Staff> findAll();
}
