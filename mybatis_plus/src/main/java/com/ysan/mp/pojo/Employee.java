package com.ysan.mp.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

/**
 * @author Administrator
 * @description
 * @since 2023/2/14 14:18
 **/


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("tbl_employee")
public class Employee {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "last_name")
    private String lastName;
    @TableField(value = "email")
    private String email;
    @TableField(value = "gender")
    private Integer gender;
    @TableField(value = "age")
    private Integer age;

    @Version
    private Integer version;
}
