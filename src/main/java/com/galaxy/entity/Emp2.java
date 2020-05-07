package com.galaxy.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName(value = "tb_emp")//指定表明
public class Emp2 extends Model<Emp2> {

    @Override
    protected Serializable pkVal() {
        return id;
    }

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
}
