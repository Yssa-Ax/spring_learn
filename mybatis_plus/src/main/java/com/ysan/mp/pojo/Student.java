package com.ysan.mp.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import com.ysan.mp.enums.GradeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 学生
 * </p>
 *
 * @author ysan
 * @since 2023-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学生年龄
     */
    private Integer age;

    /**
     * 学生年纪
     */
    private GradeEnum grade;

    /**
     * 学生状态
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String status;

    /**
     * 是否删除（0:未删除、1:已删除）
     */
    private Integer deleted;


}
