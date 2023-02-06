package com.ysan.entity;

import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @description
 * @since 2023/1/31 10:17
 **/
@Component(value="repository")
public class Repository {
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "dataSource=" + dataSource +
                '}';
    }
}


