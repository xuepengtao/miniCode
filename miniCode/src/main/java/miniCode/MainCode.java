package miniCode;

import java.util.*;

public class MainCode {

    //构建数据
    static final String str = "abc,def,ghi,jkl,mno,pqrs,tuv,wxyz";

    private Map<String, ArrayList<String>> map;

    public List<String> testDemo(String[] input) {
        map = new HashMap<>();
        String[] strArr = str.split(",");
        for (Integer i = 2; i < 10; i++) {
            map.put(i.toString(), new ArrayList<String>(Arrays.asList(strArr[i - 2].split(""))));
        }
        List<String> recursion = recursion(input);
        return recursion;
    }

    /**
     * @param input
     * @return
     */
    private List<String> recursion(String[] input) {
        ArrayList<String> tempStrArr = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            String key = input[i];
            if (map.keySet().contains(key)) {
                ArrayList<String> stringValues = map.get(key);
                if (i == 0) {
                    //添加到新的数组中为了不不污染，原来的数据
                    tempStrArr.addAll(stringValues);
                    continue;
                } else {
                    //调用数据组合方法
                    tempStrArr = combination(tempStrArr, stringValues);
                }
            }
        }
        return tempStrArr;
    }

    /**
     * 组合数据
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private ArrayList<String> combination(ArrayList<String> arr1, ArrayList<String> arr2) {
        ArrayList<String> reStrArr = new ArrayList<String>();
        //遍历
        for (String s1 : arr1) {
            for (String s2 : arr2) {
                reStrArr.add(s1 + s2);
            }
        }
        return reStrArr;
    }
}
