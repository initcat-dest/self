package com.base.self.sort;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.*;

/**
 * class description 拼音排序
 *
 * @author libo
 * @package com.base.self.sort
 * @company initcat
 * @date 2020/4/27
 */
public class PinYinSort {

    public static void main(String[] args) {
        String citys = "重庆市,北京市,上海市,天津市,河北省,山西省,辽宁省,吉林省,黑龙江省,江苏省,浙江省,安徽省,福建省,江西省,山东省,河南省,湖北省,湖南省,广东省,海南省,四川省,贵州省,云南省,陕西省,甘肃省,青海省,台湾省,广西壮族自治区,宁夏回族自治区,西藏自治区,新疆维吾尔自治区,内蒙古自治区,香港特别行政区,澳门特别行政区";

        String[] cityArr = citys.split(",");
        sortByPinyin(cityArr);
        Arrays.stream(cityArr).forEach(System.out::println);
    }

    private static void sortByPinyin(String[] cityArr) {
        HanyuPinyinOutputFormat pinyinOutputFormat = new HanyuPinyinOutputFormat();
        Arrays.sort(cityArr, (o1, o2) -> {
            String province1 = null;
            String province2 = null;
            try {
                province1 = PinyinHelper.toHanYuPinyinString(o1, pinyinOutputFormat, " ", true);
                province2 = PinyinHelper.toHanYuPinyinString(o2, pinyinOutputFormat, " ", true);
            } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                badHanyuPinyinOutputFormatCombination.printStackTrace();
            }
            return province1.compareTo(province2);
        });
    }
}
