import com.sonia.pojo.User;
import com.sonia.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
//        User user = new User();
//        user.show();
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //使用注解开发的话,context后面的getBean方法中的参数name需要是对象名的首字母小写,
        //例如,对象名是UserT,那么我们在getBean中的系数只可以写userT而不能写UserT
        UserT user = context.getBean("userT", UserT.class);
        //结果可以发现，在调用show方法之前，User对象已经通过无参构造初始化了！
        //user.show();
    }
}
