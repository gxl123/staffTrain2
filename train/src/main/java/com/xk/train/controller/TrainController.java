package com.xk.train.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xk.train.entity.Staff;
import com.xk.train.entity.Train;
import com.xk.train.entity.TrainStaff;
import com.xk.train.feign.FeignStaffClient;
import com.xk.train.repository.TrainMapper;
import com.xk.train.repository.TrainStaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: gxl
 * @Date: 2020/4/3 3:23 下午
 */
@RestController
@RequestMapping("/train")
@RibbonClient( name = "staff" )
public class TrainController {

    @Bean
    @LoadBalanced //声明一个基于Ribbon的restTemplate
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FeignStaffClient feignStaffClient;

    @Autowired
    private TrainMapper trainMapper;

    @Autowired
    private TrainStaffMapper trainStaffMapper;

    /**
     * 使用Ribbon+restTemplate方式
     */
    @GetMapping("/showStaffPort")
    public String showStaffPort(){
        String staffPort = restTemplate.getForObject("http://staff/staff/getPort", String.class);
        return staffPort;
    }

    /**
     * 使用Feign方式,更简洁
     */
    @GetMapping("/showStaffPort2")
    public String showStaffPort2(){
        String staffPort = feignStaffClient.getPort();
        return staffPort;
    }

    @GetMapping("/findAll")
    public List<Train> findAll(){
       return trainMapper.selectList(null);
    }

    @GetMapping("/findStaffsByTrainId/{id}")
    public List<Staff> findStaffsByTrainId(@PathVariable("id") int id){
        QueryWrapper<TrainStaff> wrapper = new QueryWrapper<TrainStaff>();
        wrapper.eq("tid",id);
        List<TrainStaff> list = trainStaffMapper.selectList(wrapper);

        List<Integer> staffIds = new ArrayList<Integer>();
        Iterator<TrainStaff> ite = list.iterator();
        while (ite.hasNext()){
            int staffId = ite.next().getSid();
            staffIds.add(staffId);
        }
        List<Staff> staffs = new ArrayList<>();
//        Staff[] staffArray = restTemplate.getForObject("http://192.168.0.75:8081/staff/findAll", Staff[].class);
//        Staff[] staffArray = restTemplate.getForObject("http://192.168.0.75:8081/staff/myFindAll", Staff[].class);
        Staff[] staffArray = restTemplate.getForObject("http://staff/staff/myFindAll", Staff[].class);

        for(Staff staff : staffArray )
        {
            int staffID = staff.getId();
            staffIds.contains(staffID);
            staffs.add(staff);
        }
        return staffs;
    }
}
