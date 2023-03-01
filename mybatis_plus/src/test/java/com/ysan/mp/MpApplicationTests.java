package com.ysan.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysan.mp.enums.GradeEnum;
import com.ysan.mp.mapper.EmployeeMapper;
import com.ysan.mp.mapper.ProductMapper;
import com.ysan.mp.mapper.StudentMapper;
import com.ysan.mp.mapper.UserMapper;
import com.ysan.mp.pojo.Employee;
import com.ysan.mp.pojo.Product;
import com.ysan.mp.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MpApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    void contextLoads() {
        List<Employee> employees = employeeMapper.selectList(null);
        employees.forEach(System.out::println);
    }

    @Test
    void testInsert() {
//        int result = employeeMapper.insert(new Employee(null, "zhangsan", "zhangsan@qq.com", 0, 25));
//        System.out.println("result:" + result);
    }

    @Test
    void testUpdateById() {
        // 先查询
        Employee employee = employeeMapper.selectById(1);
        employee.setLastName("Jennie");

        // 再修改
        int result = employeeMapper.updateById(employee);
        System.out.println(result);
    }

    @Test
    void testSelectById() {
        Employee employee = employeeMapper.selectById(1);
        System.out.println(employee);
    }

    @Test
    void testSelectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("gender", 0);
        map.put("age", 25);
        List<Employee> employees = employeeMapper.selectByMap(map);
        employees.forEach(System.out::println);
    }

    @Test
    void testSelectBatchIds() {
        List<Employee> employees = employeeMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        employees.forEach(System.out::println);
    }

    @Test
    void testDeleteById() {
        int result = employeeMapper.deleteById(1);
        System.out.println(result);
    }


    @Test
    void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("gender", 0);
        map.put("age", 25);
        int result = employeeMapper.deleteByMap(map);
        System.out.println(result);
    }

    @Test
    void testDeleteBatchIds() {
        int result = employeeMapper.deleteBatchIds(Arrays.asList(4, 5, 6));
        System.out.println(result);
    }

    @Test
    void testSelectList1() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>();
        queryWrapper
                .like("last_name", "B")
                .eq("gender", 1)
                .gt("age", 24);
        List<Employee> employees = employeeMapper.selectList(queryWrapper);
        employees.forEach(System.out::println);
    }

    @Test
    void testSelectList2() {
        List<Employee> employees = employeeMapper.selectList(null);
        employees.forEach(System.out::println);
    }


    @Test
    void testSelectList3() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gender", 1);
        Integer count = employeeMapper.selectCount(queryWrapper);
        System.out.println(count);
    }


    @Test
    void testUpdate() {
        UpdateWrapper<Employee> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .eq("gender", 1)
                .gt("age", 25);
        Employee employee = new Employee();
        employee.setGender(0);
        employeeMapper.update(employee, updateWrapper);
    }

    @Test
    void testDelete() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("last_name", "Tom");
        int result = employeeMapper.delete(queryWrapper);
        System.out.println(result);
    }


    @Test
    void testPagination() {
        Page<Employee> page = new Page<>(1, 5);
        Page<Employee> employeePage = employeeMapper.selectPage(page, null);
        employeePage.getRecords().forEach(System.out::println);

        System.out.println("当前页：" + employeePage.getCurrent());
        System.out.println("总页数：" + employeePage.getPages());
        System.out.println("记录数：" + employeePage.getTotal());
        System.out.println("是否有上一页：" + employeePage.hasPrevious());
        System.out.println("是否有下一页：" + employeePage.hasNext());
    }



    @Test
    void testBlockAttack() {
        int delete = employeeMapper.delete(null);
        System.out.println(delete);
    }


    @Test
    void testOptimisticLocker() {
        Employee employee = employeeMapper.selectById(1);
        employee.setLastName("Bob");
        int result = employeeMapper.updateById(employee);
        System.out.println(result);
    }


    @Test
    void testDeleteAll() {
        userMapper.deleteAll();
    }


    @Test
    void testLogicDelete() {
        int result = studentMapper.deleteById(1);
        System.out.println(result);
    }

    @Test
    void testGradeEnum() {
        Student student = new Student();
        student.setName("王五");
        student.setGrade(GradeEnum.HIGH);
        int result = studentMapper.insert(student);
        System.out.println(result);
    }




    @Test
    void testInsertFill() {
        Student student = new Student();
        student.setName("小六");
        int result = studentMapper.insert(student);
        System.out.println(result);
    }


    @Test
    void testUpdateFill() {
        Student student = studentMapper.selectById(4);
        student.setName("李四-修改");
        student.setStatus(null);
        int result = studentMapper.updateById(student);
        System.out.println(result);
    }


    @Test
    void testCustomIdGenerator() {
        Product product = new Product();
        product.setPname("手机");
        int result = productMapper.insert(product);
        System.out.println(result);
    }
}
