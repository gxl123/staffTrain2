package com.xk.staff.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xk.staff.entity.Department;
import com.xk.staff.repository.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: gxl
 * @Date: 2020/4/3 2:19 下午
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("/findAll")
    public List<Department> findAll(){
        List<Department> result = departmentMapper.selectList(null);
        return result;
    }

    @GetMapping("/myFindAll")
    public List<Department> myFindAll(){
        List<Department> result = departmentMapper.myFindAll();
        return result;
    }

    @GetMapping("/findList/{current}/{size}")
    public List<Department>  findList(@PathVariable("current") Integer current,@PathVariable("size") Integer size) {
        Page<Department> page = new Page<>(current,size);

//        QueryWrapper<Department> wrapper = new QueryWrapper<>();
//        //设置查询条件
//        wrapper.like("name","后勤部");

        IPage<Department> iPage = this.departmentMapper.selectPage(page,null);
        System.out.println("数据总条数："+iPage.getTotal());
        System.out.println("数据总页数："+iPage.getPages());
        System.out.println("当前页数："+iPage.getCurrent());
        System.out.println("数据列表："+iPage.getRecords());
        return iPage.getRecords();
    }

    @PostMapping("/save")
    public Department save(@RequestBody Department department){
        int recordCount = departmentMapper.insert(department);
        int departmentID = department.getId();
        return department;
    }

    @PutMapping("/update")
    public int update(@RequestBody Department department){
        int recordCount = departmentMapper.updateById(department);
        return recordCount;
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable("id") int id){
        int recordCount = departmentMapper.deleteById(id);
        return recordCount;
    }

}
