package com.base.self.design.filterpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * class description 单身过滤器-排除非单身
 *
 * @author libo
 * @package com.base.self.design.filterpattern
 * @company initcat
 * @date 2020/5/7
 */
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<>();
        for (Person person : persons) {
            if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}
