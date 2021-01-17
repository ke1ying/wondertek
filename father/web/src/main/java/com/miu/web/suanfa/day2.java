package com.miu.web.suanfa;

import com.miu.web.comment.Entry;
import org.apache.logging.log4j.util.Strings;

import java.util.*;

public class day2 {

    /*
     * 输如：人名（用“,”隔开，代表投票数，输出获得票数最多的人，若票数相同比较人名大小）
     * */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String names = s.nextLine();
        String arr[] = names.split(",");

/*        ArrayList<String> name = new ArrayList<>(Arrays.asList(arr));*/
        ArrayList<String> nameList = new ArrayList<>(arr.length);
        Collections.addAll(nameList,arr);
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < nameList.size(); i++) {
            if(!map.containsKey(nameList.get(i))){
                map.put(nameList.get(i),1);
            }else {
                int x = map.get(nameList.get(i));
                map.put(nameList.get(i),x+1);
            }
        }
        System.out.println(map);

        ArrayList<HashMap.Entry<String,Integer>> suanList = new ArrayList<>(map.entrySet());

        Collections.sort(suanList, new Comparator<HashMap.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().compareTo(o2.getValue()) == 0){
                    return o1.getKey().compareTo(o2.getKey());
                }else{
                    return o1.getValue().compareTo(o2.getValue());
                }
            }
        });
        System.out.println(suanList.get(0).getKey());


      /*  Scanner sc = new Scanner(System.in);
        String names = sc.nextLine();
        String arr[] = names.split(",");
        jisuan(arr);*/
    }




    private static void jisuan(String[] arr) {
        List list = Arrays.asList(arr);
        Map<String,Integer> map = new HashMap<>();
        for (Object li:list) {
            if(!map.containsKey(li.toString())){
                map.put(li.toString(),1);
            }else{
                int temp = map.get(li.toString());
                temp++;
                map.put(li.toString(),temp);
            }
        }
        //考点，Collections
        List<Map.Entry<String,Integer>> list1 = new ArrayList<>(map.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o2.getValue().compareTo(o1.getValue()) == 0){
                    return o1.getKey().compareTo(o2.getKey());
                }else{
                    return o2.getValue().compareTo(o1.getValue());
                }

            }
        });
        String result  = list1.get(0).getKey();
        System.out.println(result);
    }
}
