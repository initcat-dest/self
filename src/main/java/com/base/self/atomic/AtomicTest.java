package com.base.self.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * class description TODO
 *
 * @author libo
 * @package com.base.self.atomic
 * @company initcat
 * @date 2020/1/9
 */
public class AtomicTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.addAndGet(1);
    }
}
