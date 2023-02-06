import com.ysan.dao.StudentDao;
import com.ysan.pojo.Student;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author Administrator
 * @description
 * @since 2023/2/2 17:21
 **/
public class SimpleTest {
    private StudentDao studentDao;

    @Before
    public void init() throws IOException {
        studentDao = new StudentDao("mybatis-config.xml");
    }

    @Test
    public void insertTest() {
        Student student = new Student();
        student.setName("yogurt");
        student.setAge(24);
        student.setGender(1);
        student.setScore(100);
        studentDao.addStudent(student);
    }

    @Test
    public void findAllTest() {
        List<Student> all = studentDao.findAll();
        all.forEach(System.out::println);
    }
}
