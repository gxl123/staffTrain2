package com.xk.staff.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xk.staff.entity.Department;

import java.util.List;

/**
 * @Author: gxl
 * @Date: 2020/4/3 2:18 下午
 */
public interface DepartmentMapper extends BaseMapper<Department> {
    public List<Department> myFindAll();
}
