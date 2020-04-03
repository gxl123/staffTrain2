package com.xk.staff.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xk.staff.entity.Staff;

import java.util.List;

/**
 * @Author: gxl
 * @Date: 2020/4/3 2:15 下午
 */
public interface StaffMapper extends BaseMapper<Staff> {
    public List<Staff> myFindAll();

}
