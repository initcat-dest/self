package com.base.self.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * class description
 *
 * @author libo
 * @package com.base.self.maps
 * @company initcat
 * @date 2019/4/23
 */
public class HashMapTest {

    public static void main(String[] args) {
        System.out.println("start");
        int mapCapacity = 2;
        Map<String, String> map = new HashMap(mapCapacity);

        int n = mapCapacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        n = (n < 0) ? 1 : (n + 1);
        System.out.println(n);
        map.put("1", "2");
        System.out.println("put 01 end");
        map.put("2", "3");
        System.out.println("put 02 end");
//        map.put("2", "3");
//        System.out.println("put 03 end");
//        map.get("1");
//        System.out.println("get end");
    }
}
