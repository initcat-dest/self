package com.base.self.test;

/**
 * class description
 *
 * @author libo
 * @package com.base.self.test
 * @company initcat
 * @date 2019/3/22
 */
public class BeanUtilsTestDemo {

	private Integer id;

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BeanUtilsTestDemo{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
