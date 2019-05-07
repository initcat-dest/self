package com.base.self.list;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * class description
 *
 * @author libo
 * @package com.base.self.list
 * @company initcat
 * @date 2019/3/28
 */
public class OffsetTest {

	static class Config {
		int id;
		int sort;
		// 理论偏移量
		int llOffset;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getSort() {
			return sort;
		}

		public void setSort(int sort) {
			this.sort = sort;
		}

		public int getLlOffset() {
			return llOffset;
		}

		public void setLlOffset(int llOffset) {
			this.llOffset = llOffset;
		}
	}

	// 1, 10, 4, 7, 13, 25, 28, 22, 31, 16, 19, 34, 37, 40, 43, 46, 52, 49
	// List<Integer> list = Lists.newArrayList(1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52);

	public static void main(String[] args) {
		List<Config> configs = new ArrayList<>();
		List<Integer> list = Lists.newArrayList(1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52);
		Config config;
		for (Integer sort : list) {
			config = new Config();
			config.sort = sort;
			config.id = sort;
			configs.add(config);
		}
		List<Config> sourceConfigs = configs.stream().sorted(Comparator.comparing(Config::getSort)).collect(Collectors.toList());
		List<Config> config0 = getConfigs(sourceConfigs, getCurrentConfig(configs, 1), 100);
		List<Config> configs1 = getConfigs(config0, getCurrentConfig(configs, 4), 2);
		List<Config> configs2 = getConfigs(configs1, getCurrentConfig(configs, 7), 2);
		List<Config> configs3 = getConfigs(configs2, getCurrentConfig(configs, 16), 5);
		List<Config> configs4 = getConfigs(configs3, getCurrentConfig(configs, 19), 5);
		List<Config> configs5 = getConfigs(configs4, getCurrentConfig(configs, 22), 2);
		List<Config> configs6 = getConfigs(configs5, getCurrentConfig(configs, 49), 10);
		List<Config> configs7 = getConfigs(configs6, getCurrentConfig(configs, 52), 3);

		for (Config config1 : configs7) {
			if (config1.getLlOffset() != 0) {
				config1.sort = config1.llOffset;
			}
		}
		System.out.println("最终结果");
		System.out.println("10, 4, 7, 13, 25, 28, 22, 31, 16, 19, 34, 37, 40, 43, 46, 52, 49, 1");
		List<Config> finalConfigs = configs7.stream().sorted(Comparator.comparing(Config::getSort)).collect(Collectors.toList());
		finalConfigs.stream().map(configTemp -> configTemp.id + ", ").forEach(System.out::print);
//		System.out.println();
//		finalConfigs.stream().map(configTemp -> configTemp.llOffset + ", ").forEach(System.out::print);
//		System.out.println();
//		finalConfigs.stream().map(configTemp -> configTemp.sort + ", ").forEach(System.out::print);

	}

	private static Config getCurrentConfig(List<Config> configs, int id) {
		return configs.stream().filter(temp -> temp.id == id).collect(Collectors.toList()).get(0);
	}

	private static List<Config> getConfigs(List<Config> configs, Config currentConfig, int offset) {
		int trueOffset = 0;
		int currentSort = currentConfig.sort;
		int currentId = currentConfig.id;
		int i = currentSort + offset;
		for (Config config : configs) {
			if (i < config.sort) {
				trueOffset++;
			}
		}
		// 实际偏移量 小于 指定偏移量
		boolean doAllOffset = trueOffset > offset;
		if (doAllOffset) {
			int temp = 1;
			for (Config newConfig : configs) {
				newConfig.sort = temp;
				temp++;
			}
		}

		int targetSort = currentSort + offset;
		for (Config newConfig : configs) {
			int sort = newConfig.getSort();
			if (sort <= targetSort && newConfig.id != currentId) {
				newConfig.sort = newConfig.sort - 1;
			}
			if (!doAllOffset) {
				if (newConfig.llOffset != 0 && newConfig.getSort() > targetSort) {
					newConfig.sort = newConfig.sort + offset;
					newConfig.llOffset = newConfig.llOffset + offset;
				}
			} else {
				if (newConfig.getSort() >= targetSort && newConfig.id != currentId) {
					newConfig.sort = newConfig.sort + offset;
				}
			}
			if (newConfig.id == currentId) {
				if (!doAllOffset) {
					newConfig.llOffset = targetSort;
				}
				newConfig.sort = targetSort;
			}
		}
		System.out.println("currentSort:" + currentSort + " 偏移:" + offset);
//		System.out.println("原始ID排序: 1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52");
		System.out.println("目标ID排序: 10, 4, 7, 13, 25, 28, 22, 31, 16, 19, 34, 37, 40, 43, 46, 52, 49, 1");
		List<Config> newConfigs = configs.stream().sorted(Comparator.comparing(Config::getSort)).collect(Collectors.toList());
		System.out.print("偏移ID排序: ");
		newConfigs.stream().map(configTemp -> configTemp.id + ", ").forEach(System.out::print);
		System.out.println();
		newConfigs.stream().map(configTemp -> configTemp.sort + ", ").forEach(System.out::print);
		System.out.println();
		return newConfigs;

	}
}
