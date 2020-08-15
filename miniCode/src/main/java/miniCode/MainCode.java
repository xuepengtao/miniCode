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
        ArrayList<String> resurltStrArr = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            String inputKey = input[i];
            String[] keys = inputKey.split("");
            ArrayList<String> tempStrArr = new ArrayList<>();
            for (int j = 0; j < keys.length; j++) {
                String key = keys[j];
                if (map.keySet().contains(key)) {
                    ArrayList<String> stringValues = map.get(key);
                    //调用数据组合方法
                    tempStrArr = combination(tempStrArr, stringValues);
                }
            }
            resurltStrArr = combination(resurltStrArr, tempStrArr);
        }
        return resurltStrArr;
    }

    /**
     * 组合数据
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private ArrayList<String> combination(ArrayList<String> arr1, ArrayList<String> arr2) {
        if (arr1.size() ==0 ||arr2.size() ==0){
            if (arr1.size() >0) return arr1;
            if (arr2.size() >0) return arr2;
            return  null;
        }
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
