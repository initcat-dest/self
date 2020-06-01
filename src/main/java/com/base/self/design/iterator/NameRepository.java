package com.base.self.design.iterator;

import java.util.Iterator;

/**
 * class description 名称仓库
 *
 * @author libo
 * @package com.base.self.design.iterator
 * @company initcat
 * @date 2020/4/7
 */
public class NameRepository {

    public String names[] = {"Robert", "John", "Julie", "Lora"};

    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            System.out.println(" hasNext ....");
            return index < names.length;
        }

        @Override
        public Object next() {
            System.out.println(" next ....");
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
