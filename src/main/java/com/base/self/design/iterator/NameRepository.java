package com.base.self.design.iterator;

import java.util.Iterator;

/**
 * class description TODO
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
            if (index < names.length) {
                return true;
            }
            return false;
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
