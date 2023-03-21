package com.ysan.mp.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @author Administrator
 * @description
 * @since 2023/2/16 14:05
 **/
public class MyMappedStatement extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        // 接口中的方法名
        String method = "deleteAll";
        // 该方法执行语句
        String sql = "delete from " + tableInfo.getTableName();
        // 创建SqlSource
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        // 构造一个删除的MappedStatement并返回
        return this.addDeleteMappedStatement(mapperClass, method, sqlSource);
    }
}
