package com.xk.train.controller;

import com.xk.train.entity.Staff;
import com.xk.train.entity.Train;
import com.xk.train.repository.TrainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: gxl
 * @Date: 2020/4/3 3:23 下午
 */
@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainMapper trainMapper;

    @GetMapping("/findAll")
    public List<Train> findAll(){
       return trainMapper.selectList(null);
    }

    @GetMapping("/findStaffsByTrainId/{id}")
    public List<Staff> findStaffsByTrainId(@PathVariable("id") int id){
        return null;
    }
}
