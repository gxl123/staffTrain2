package com.xk.train.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: gxl
 * @Date: 2020/4/3 5:20 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_train_staff")
public class TrainStaff {
    private int id;
    private int sid;
    private int tid;
}
