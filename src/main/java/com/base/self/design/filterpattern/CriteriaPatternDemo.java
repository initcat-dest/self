package com.base.self.design.filterpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * class description 测试
 *
 * @author libo
 * @package com.base.self.design.filterpattern
 * @company initcat
 * @date 2020/5/7
 */
public class CriteriaPatternDemo {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Robert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));


        Criteria male = new CriteriaMale();

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        Criteria female = new CriteriaFemale();

        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(persons));

        Criteria single = new CriteriaSingle();

        Criteria singleMale = new AndCriteria(single, male);
        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));

        Criteria singleOrFemale = new OrCriteria(single, female);

        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));
    }

    public static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName()
                    + ", Gender : " + person.getGender()
                    + ", Marital Status : " + person.getMaritalStatus()
                    + " ]");
        }
    }
}
