package com.base.self.design.filterpattern;

import java.util.List;

/**
 * class description 与条件过滤（同时满足两个条件）
 *
 * @author libo
 * @package com.base.self.design.filterpattern
 * @company initcat
 * @date 2020/5/7
 */
public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
