package com.galaxy.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName(value = "tb_emp")//指定表明
public class Emp {

    //value与数据库逐渐列名一致，若实体类属性名与表主键列名一致可省略value
//    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //若没有开启驼峰命名，或者表中列名不符合驼峰规则，可通过该注解指定数据库表中的列名，
    // exist标明数据表中有没有对应列
//    @TableField(value = "user_name",exist = true)
    private String userName;
    private String email;
    private Integer gender;
    private Integer age;

    @TableLogic//标记逻辑删除属性
    private Integer logicFlag;
}
