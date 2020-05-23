import com.soina.dao.UserDaoImpl;
import com.soina.dao.UserDaoMysqlImpl;
import com.soina.dao.UserDaoOracleImpl;
import com.soina.service.UserService;
import com.soina.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        //用户实际调用的是业务层,dao层用户不需要直接接触
        //业务层在这里就是做一个事情,调dao层去查
        //传统写法
        //UserService userService = new UserServiceImpl();

        //加入set后的写法
//        UserServiceImpl userServiceImpl = new UserServiceImpl();
//        userServiceImpl.setUserDao(new UserDaoMysqlImpl());
//        userServiceImpl.getUser();
        //用spring管理对象

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        UserDaoImpl userDaoImpl = context.getBean("userDaoImpl", UserDaoImpl.class);
//        userDaoImpl.getUser();
//
//        UserDaoMysqlImpl userDaoMysqlImpl = context.getBean("userDaoMysqlImpl", UserDaoMysqlImpl.class);
//        userDaoMysqlImpl.getUser();


        UserServiceImpl userServiceImpl = context.getBean("userServiceImpl",UserServiceImpl.class);

        userServiceImpl.getUser();
    }
}
