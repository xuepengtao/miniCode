package miniCode;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.Any;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class NumInputApplicationTest {

    @Test
    void contextLoads() {
        // 创建一个计时器
        Timer timer = new Timer();
        // 开启一个计时调度，延迟 0毫秒（也就是立即开始执行），调度评率： 1秒
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 生成随机数逻辑
                Random r = new Random();
                int num = r.nextInt(10) + 1;
                System.out.println("随机数为：" + num);
            }
        }, 0L, 1000L);
        // timer.cancel();  // 关闭计时器
    }
    @Test
    void test(){
       String[] args = {"1","2"};
       NumInputApplication.main(args);
    }
}
