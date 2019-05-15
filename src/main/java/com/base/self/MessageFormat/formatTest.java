package com.base.self.MessageFormat;

import java.text.MessageFormat;

/**
 * class description
 *
 * @author libo
 * @package com.base.self.MessageFormat
 * @company xmiles
 * @date 2019/4/19
 */
public class formatTest {

    public static void main(String[] args) {
        String test = MessageFormat.format("ddddd:{0}:{1}", "one","two");
        System.out.println(test);
    }

}
