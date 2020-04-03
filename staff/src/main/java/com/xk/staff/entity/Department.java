package com.xk.staff.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: gxl
 * @Date: 2020/4/3 2:17 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_department")
public class Department {
    @TableId(type = IdType.AUTO) //指定id类型为自增长
    private int id;
    private String name;

    @TableField(exist = false)
    private List<Staff> staffs;
}
