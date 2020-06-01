package com.base.self.design.iterator;

import java.util.Iterator;

/**
 * class description 调用
 *
 * @author libo
 * @package com.base.self.design.iterator
 * @company initcat
 * @date 2020/4/7
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {

        NameRepository namesRepository = new NameRepository();

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}
