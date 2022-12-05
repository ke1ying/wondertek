package com.miu.web.huaWei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-11-24 18:18:58
 */
public class HwSF62 {

    /**
     * 输入一个只包含小写英文字母和数字的字符串，
     * 按照不同字符统计个数由多到少输出统计结果，
     * 如果统计的个数相同，则按照ASCII码由小到大排序输出。
     * <p>
     * <p>
     * 一个只包含小写英文字母和数字的字符串。
     * 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String newString = new StringBuffer(string).reverse().toString();
        List<String> stringList = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        HashMap<String, Long> map = new HashMap<>();
        for (int i = 0; i < newString.length(); i++) {
            map.put(String.valueOf(newString.charAt(i)), map.getOrDefault(String.valueOf(newString.charAt(i)), 0L) + 1);
            if (!stringList.contains(String.valueOf(newString.charAt(i)))) {
                stringBuffer.append(newString.charAt(i));
                stringList.add(String.valueOf(newString.charAt(i)));
            }
        }
        TreeMap<Long, List<String>> mapString = new TreeMap<>();
        Set<Map.Entry<String, Long>> entries = map.entrySet();
        Iterator<Map.Entry<String, Long>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Long> next = iterator.next();
            if(!mapString.containsKey(next.getValue())){
                // 不包含直接放入
                mapString.put(next.getValue(), Arrays.asList(next.getKey()));
            }else{
                // 包含则 增加
                List<String> stringList1 = mapString.get(next.getValue());
                List<String> stringListNew  = new ArrayList<>();
                stringListNew.addAll(stringList1);
                stringListNew.add(next.getKey());
                mapString.put(next.getValue(), stringListNew);
            }
        }
        // 根据个数排序

        Iterator<Map.Entry<Long, List<String>>> iteratorSort = mapString.entrySet().iterator();
        List<String> finalList = new ArrayList<>();
        while(iteratorSort.hasNext()){
            Map.Entry<Long, List<String>> next = iteratorSort.next();
            List<String> value = next.getValue();
            value = value.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            finalList.addAll(value);
        }

        for (int size = finalList.size()-1; size >= 0; size--) {
            System.out.print(finalList.get(size));
        }

    }

}