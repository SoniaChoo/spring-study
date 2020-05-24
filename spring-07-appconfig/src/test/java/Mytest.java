import com.sonia.config.SoniaConfig;
import com.sonia.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mytest {
    public static void main(String[] args){
        //如果完全使用了配置类方式去做,我们就只能通过AnnotationConfig上下文来获取容器,通过配置类的class对象加载.
        //但是如果不是完全用配置类,任然有xml文件,那么我们还是用ClassPath上下文来获取容器.
        ApplicationContext context = new AnnotationConfigApplicationContext(SoniaConfig.class);
        User user = context.getBean("getUser", User.class);
        System.out.println(user);
    }
}
