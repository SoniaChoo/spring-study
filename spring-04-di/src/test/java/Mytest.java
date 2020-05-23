import com.sonia.pojo.Student;
import com.sonia.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        Student student = context.getBean("student", Student.class);
//        System.out.println(student.getName());
//        System.out.println(student.getAddress());
//        System.out.println(student.toString());


        }
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("userBean.xml");
        User user = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user == user2);
    }


}
