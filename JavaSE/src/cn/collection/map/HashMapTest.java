package cn.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Name: admin
 * Date: 2017/2/21
 * Time: 9:51
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("w","wzm001");
        map.put("w","wzm002");
        map.put("y","lili001");
        String a  = (String) map.get("w");
        System.out.println(a);
    }
}
