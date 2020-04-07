package com.xk.staff.controller;

import com.xk.staff.entity.Staff;
import com.xk.staff.repository.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Value("${server.port}")
    private String port;

    @Autowired
    private StaffMapper staffMapper;

    @GetMapping("/getPort")
    public String getPort(){
        return "当前端口是："+port;
    }

    @GetMapping("/findAll")
    public List<Staff> findAll(){
        List<Staff> result = staffMapper.selectList(null);
        return result;
    }

    @GetMapping("/myFindAll")
    public List<Staff> myFindAll(){
        List<Staff> result = staffMapper.myFindAll();
        return result;
    }

//    @GetMapping("/findAllByIds")
//    public List<Staff> findAllByIds(@RequestBody List<Integer> ids){
//        List<Staff> result = staffMapper.selectBatchIds(ids);
//        return result;
//    }
}
