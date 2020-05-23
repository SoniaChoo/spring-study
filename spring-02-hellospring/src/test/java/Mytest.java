import com.sonia.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        //解析beans.xml文件,获取spring的上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //我们现在的对象都是由spring管理了.
        Hello hello = context.getBean("hello", Hello.class);
        hello.show();
        System.out.println(hello.toString());
    }
}
