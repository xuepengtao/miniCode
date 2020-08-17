package miniCode;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

public class ConsolePrintingServiceImplTest {

    private static ConsolePrintlnServiceImpl psl;

    @BeforeClass
    public static void before() {
        psl = new ConsolePrintlnServiceImpl(1);
    }

    @Test
    public void testWriter() {
        new ConsolePrintlnServiceImpl(1).writer();
    }

    /**
     * 获取英文字母
     */
    @Test
    public void testGetWordsByNum() {
        char c = '3';
        String wordStr = psl.getWordByCharNum(c);
        assert(wordStr != null&& !"".equals(wordStr));
        System.out.println("wordStr: " + wordStr);
    }

    /**
     * 输出组合
     */
    @Test
    public void testCombination() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "a,b,c");
        map.put(1, "d,e,f");
        psl.combination(map);
    }
}
