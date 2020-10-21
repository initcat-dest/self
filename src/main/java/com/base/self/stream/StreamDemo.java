package com.base.self.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * class description TODO
 *
 * @author libo
 * @package com.base.self.stream
 * @company initcat
 * @date 2020/6/21
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(String.valueOf(i));
        }
        boolean b = list.stream().anyMatch(t -> t.equals("1"));
        System.out.println(b);
    }


}
