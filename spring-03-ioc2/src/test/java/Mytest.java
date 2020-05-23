import com.sonia.pojo.User;
import com.sonia.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
//        User user = new User();
//        user.show();
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserT user = context.getBean("usert", UserT.class);
        //结果可以发现，在调用show方法之前，User对象已经通过无参构造初始化了！
        //user.show();
    }
}
