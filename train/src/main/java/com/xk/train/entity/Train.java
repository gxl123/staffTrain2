package com.xk.train.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: gxl
 * @Date: 2020/4/3 3:23 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_train")
public class Train {
    @TableId(type = IdType.AUTO) //指定id类型为自增长
    private int id;
    private String name;
    private Date starttime;
    private Date endtime;
}
