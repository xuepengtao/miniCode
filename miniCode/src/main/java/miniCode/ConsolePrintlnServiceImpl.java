package miniCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationEvent;
import org.springframework.util.StringUtils;

/**
 * 控制台打印
 */
public class ConsolePrintlnServiceImpl extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    public ConsolePrintlnServiceImpl(Object source) {
        super(source);
    }

    public void writer() {
        System.out.println("服务开启，请任意输入0-99的数据以开始组合");
        ConsoleListener cs = new ConsoleListener(new Scanner(System.in), new ConsoleListener.Action() {
            @Override
            public void act(String msg) {
                Map<Integer, String> map = new HashMap<Integer, String>();
                //不为空
                if (!StringUtils.isEmpty(msg)) {
                    boolean number = CustomUtil.isNumber(msg);
                    //是数字
                    if (number) {
                        for (int i = 0; i < msg.length(); i++) {
                            char c = msg.charAt(i);
                            //获取数字对应的字母
                            String value = getWordByCharNum(c);
                            map.put(i, value);
                        }
                    } else {
                        System.out.println("输入数据存在非法字符，请重新输入0~99之间的数据！");
                    }
                    combination(map);
                } else {
                    System.out.println("请输入数字！");
                }
            }

        });
        cs.listenInNewThread();
//        while (true) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    /**
     * 输出组合
     * @param map
     */
    public static void combination(Map<Integer, String> map) {// 控制台监听
        for (int i = 0; i < map.size(); i++) {
            String str1 = map.get(i);
            String[] strArr1 = str1.split(",");
            if (map.size() > 1) {
                for (int j = i + 1; j < map.size(); j++) {
                    String str2 = map.get(j);
                    String[] strArr2 = str2.split(",");
                    for (int k = 0; k < strArr1.length; k++) {
                        for (int k2 = 0; k2 < strArr2.length; k2++) {
                            String e = strArr1[k] + strArr2[k2];
                            if (!e.equals("11") && !e.equals("00")) {
                                System.out.print(e.replaceAll("0", "").replaceAll("1", "") + " ");
                            } else {
                                System.out.print(e);
                            }
                        }
                    }
                }
            } else {
                for (int d = 0; d < strArr1.length; d++) {
                    System.out.print(strArr1[d] + " ");
                }
            }
        }
        System.out.println("");
    }

    /**
     * 获取英文字母
     * @param num
     * @return
     */
    public static String getWordByCharNum(char num) {
        String wordStr = null;
        switch (num) {
            case '0':
                wordStr = "0";
                break;
            case '1':
                wordStr = "1";
                break;
            case '2':
                wordStr = "a,b,c";
                break;
            case '3':
                wordStr = "d,e,f";
                break;
            case '4':
                wordStr = "g,h,i";
                break;
            case '5':
                wordStr = "j,k,l";
                break;
            case '6':
                wordStr = "m,n,o";
                break;
            case '7':
                wordStr = "p,q,r,s";
                break;
            case '8':
                wordStr = "t,u,v";
                break;
            case '9':
                wordStr = "w,x,y,z";
                break;
        }
        return wordStr;
    }

    public static void main(String[] args) {
        char c = '3';
        String wordsByNum = getWordByCharNum(c);
        System.out.println("wordsByNum: "+wordsByNum);
    }
}
