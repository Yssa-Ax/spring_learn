package com.ysan.dao;

import com.ysan.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Administrator
 * @description
 * @since 2023/2/2 16:40
 **/
public class StudentDao {

    private SqlSessionFactory sqlSessionFactory;

    public StudentDao(String configPath) throws IOException {
        // Resources 从类路径中加载资源
        InputStream inputStream = Resources.getResourceAsStream(configPath);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public List<Student> findAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Student> findAll = sqlSession.selectList("findAll");
        sqlSession.close();
        return findAll;
    }

    public int addStudent(Student student) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int insert = sqlSession.insert("insert", student);
        sqlSession.commit();
        sqlSession.close();
        return insert;
    }

    public int deleteStudent(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int delete = sqlSession.delete("delete", id);
        sqlSession.commit();
        sqlSession.close();
        return delete;

    }
}
