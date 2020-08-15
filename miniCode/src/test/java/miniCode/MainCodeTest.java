package miniCode;

import org.junit.Test;

import java.util.List;


public class MainCodeTest {

    @Test
    public void demo() {
        //构建数据
        String[] input = {"2", "0", "9", "7"};
        MainCode mainCode = new MainCode();
        //调用方法
        List<String> outPut = mainCode.testDemo(input);
        //测试断言
        assert (outPut.size() > 0);
        System.out.println("outPut: " + outPut);
    }
}
