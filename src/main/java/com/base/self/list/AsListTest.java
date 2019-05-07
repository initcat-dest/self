package com.base.self.list;

import java.util.Arrays;
import java.util.List;

/**
 * class description
 *
 * @author libo
 * @package com.base.self.list
 * @company initcat
 * @date 2019/3/18
 */
public class AsListTest {
	public static void main(String[] args) {
		String[] strings = {"1", "2"};
		List<String> list = Arrays.asList(strings);
		list.add("1");
	}
}
