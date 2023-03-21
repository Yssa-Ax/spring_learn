package com.ysan.mp.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author ysan
 * @since 2023-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品主键
     */
    @TableId(value = "pid", type = IdType.ASSIGN_ID)
    private Long pid;

    /**
     * 商品名称
     */
    private String pname;


}
