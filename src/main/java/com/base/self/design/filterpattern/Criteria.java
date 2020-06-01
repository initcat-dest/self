package com.base.self.design.filterpattern;

import java.util.List;

/**
 * interface description 标准
 * Criteria 接口和实现了该接口的实体类，来过滤 Person 对象的列表
 *
 * @author libo
 * @package com.base.self.design.filterpattern
 * @company initcat
 * @date 2020/5/7
 */
public interface Criteria {

    List<Person> meetCriteria(List<Person> persons);

}