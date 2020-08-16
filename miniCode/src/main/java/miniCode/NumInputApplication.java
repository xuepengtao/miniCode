package miniCode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NumInputApplication {
    public static void main(String[] args) {
        //需要把监听器加入到spring容器中
        SpringApplication application = new SpringApplication(NumInputApplication.class);
        application.addListeners(new CustomListener());
        //Set<ApplicationListener<?>> listeners = application.getListeners();
        ConfigurableApplicationContext context = application.run(args);
        //发布事件
        context.publishEvent(new ConsolePrintlnServiceImpl(new Object()));
        context.close();
    }
}
