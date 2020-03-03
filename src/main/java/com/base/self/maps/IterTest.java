package com.base.self.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * class description TODO
 *
 * @author libo
 * @package com.base.self.maps
 * @company initcat
 * @date 2020/2/28
 */
public class IterTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "test001");
        map.put("2", "test002");
        for (String s : map.keySet()) {
            System.out.print("key>>>> " + s);
            System.out.print("    value>>> " + map.get(s));
            System.out.println();
        }
    }
}
