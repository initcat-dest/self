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
        map.put("1", "2");
        map.get("1");

    }
}
