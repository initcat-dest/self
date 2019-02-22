package com.base.self.iterator;

import java.util.*;

public class TestIterator {

	public static void main(String[] args) {
		// 1、创建多个狗狗对象
		Dog ououDog = new Dog(1, "欧欧", "雪娜瑞");
		Dog yayaDog = new Dog(2, "亚亚", "拉布拉多");
		Dog meimeiDog = new Dog(3, "美美", "雪娜瑞");
		Dog feifeiDog = new Dog(4, "菲菲", "拉布拉多");

		// 2、创建ArrayList集合对象并把多个狗狗对象放入其中
		List<Dog> dogs = new ArrayList<Dog>();
		dogs.add(ououDog);
		dogs.add(yayaDog);
		dogs.add(meimeiDog);
		dogs.add(feifeiDog);
		// dogs.add(2, feifeiDog); //添加的时候，指定位置
		List<Dog> newdogs = null;
		if (dogs != null && dogs.size() > 0) {
			newdogs = new ArrayList<Dog>(new HashSet<Dog>(dogs));
		}

		Collections.sort(newdogs, new Comparator<Dog>() {
			@Override
			public int compare(Dog o1, Dog o2) {
				if (o1.getIndex() > o2.getIndex()) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		
		// 3、通过迭代器依次输出集合中所有狗狗的信息
		System.out.println("使用Iterator遍历，所有狗狗的昵称和品种分别是：");
		Iterator it = newdogs.iterator(); // 调用集合的iterator方法
		while (it.hasNext()) { // 循环遍历
			Dog dog = (Dog) it.next(); // 遍历出来的对象默认是 object 类型，需要转换
			System.out.println(dog.getName() + "\t" + dog.getIndex());
		}
	}
}
