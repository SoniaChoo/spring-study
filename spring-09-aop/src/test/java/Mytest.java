import com.sonia.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //动态代理代理的是一个接口,所以不可以返回一个具体实现类UserServiceImpl,而是应该返回接口类型
        //UserServiceImpl userServiceImpl = context.getBean("userServiceImpl", UserServiceImpl.class);
        UserService userService = (UserService)context.getBean("userServiceImpl");
        userService.add();
    }

//    public class MyTest {
//        @Test
//        public void test(){
//            ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//            UserService userService = (UserService) context.getBean("userServiceImpl");
//            userService.select();
//        }
//    }
}
