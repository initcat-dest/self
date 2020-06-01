package com.base.self.design.filterpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * class description 性别过滤器-排除非女性
 *
 * @author libo
 * @package com.base.self.design.filterpattern
 * @company initcat
 * @date 2020/5/7
 */
public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("FEMALE")) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
