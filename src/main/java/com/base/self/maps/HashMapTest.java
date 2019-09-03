package com.base.self.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * class description
 *
 * @author libo
 * @package com.base.self.maps
 * @company xmiles
 * @date 2019/4/23
 */
public class HashMapTest {
    public static void main(String[] args) {
        System.out.println("start");
        Map<String, String> map = new HashMap(2);
        map.put("1", "2");
        System.out.println("put 01 end");
        map.put("1", "3");
        System.out.println("put 02 end");
        map.put("2", "3");
        System.out.println("put 03 end");
        map.get("1");
        System.out.println("get end");
    }
}
