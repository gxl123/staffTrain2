package com.xk.staff.controller;

import com.xk.staff.entity.Staff;
import com.xk.staff.repository.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: gxl
 * @Date: 2020/4/3 2:13 下午
 */
@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffMapper staffMapper;

    @GetMapping("/myFindAll")
    public List<Staff> myFindAll(){
        List<Staff> result = staffMapper.myFindAll();
        return result;
    }
}
