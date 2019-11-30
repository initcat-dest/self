package com.base.self.http;

import com.base.self.io.WriteTxtFileUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.TreeMap;

/**
 * class description
 *
 * @author libo
 * @package com.base.self.http
 * @company initcat
 * @date 2019/3/16
 */
public class RestTemplateTest {

    /**
     * 84题
     */
    private static String URL = "http://m.offcn.com/sydw/2019/1129/516236.html";
    /**
     * 47题
     */
//    private static String URL = "http://m.offcn.com/sydw/2019/1114/511724.html";

    public static void main(String[] args) {

        RestTemplate test = new RestTemplate();
//        ResponseEntity<String> testForEntity = test.getForEntity("http://m.offcn.com/sydw/2019/1114/511724.html", String.class);
//        System.out.println(testForEntity.toString());

        Map<Integer, String> map = new TreeMap<>();
        try {
            int i = 84;
            while (i > 0) {
                ResponseEntity<String> forEntity = test.getForEntity(URL, String.class);
//                    		System.out.println("===response===="+ forEntity);
                String response = forEntity.toString();
                if (!response.contains("<title>2019年事业单位面试热点题目及解析")) {
                    // 获取上一题的URL
                    String substring = response.substring(response.lastIndexOf("<li>上一篇：<a href=\""));
                    substring = substring.substring(0, substring.indexOf("\">"));
                    URL = substring.replace("<li>上一篇：<a href=\"http", "http");
                    continue;
                }
                System.out.println("开始解析第" + i + "题:" + URL);
                // 题目和答案
                String subject;
                if (response.contains("<p><strong>【导读】</strong></p>")) {
                    if (response.contains("<p><strong>相关推荐</strong></p>")) {
                        subject = response.substring(response.lastIndexOf("<p><strong>【导读】</strong></p>"), response.lastIndexOf("<p><strong>相关推荐</strong></p>"));
                    } else {
                        subject = response.substring(response.lastIndexOf("<p><strong>【导读】</strong></p>"), response.lastIndexOf("<p>相关推荐</p>"));
                    }
                } else {
                    if (response.contains("<p><strong>相关推荐</strong></p>")) {
                        subject = response.substring(response.lastIndexOf("<div class=\"zg_cont\" id=\"showid\">"), response.lastIndexOf("<p><strong>相关推荐</strong></p>"));
                    } else {
                        subject = response.substring(response.lastIndexOf("<div class=\"zg_cont\" id=\"showid\">"), response.lastIndexOf("<p>相关推荐</p>"));
                    }
                }
                subject = subject.replace("<p>中公事业单位考试网提供<a href=\"http://www.zgsydw.com/kaoshitiku/mianshijiqiao/msrd/\" target=\"_blank\"><span style=\"color: #000000\">面试热点题目</span></a>，希望可以帮助考生提高面试水平，顺利进军事业单位面试考试。</p>", "");
                subject = subject.replace("<p>", "");
                subject = subject.replace("<strong>", "");
                subject = subject.replace("</p>", "");
                subject = subject.replace("</strong>", "");
                subject = subject.replace("【导读】\n", String.valueOf(i) + " 原文链接：" + URL + "\n【导读】");
                subject = subject.replace("<div class=\"zg_cont\" id=\"showid\">", String.valueOf(i) + " 原文链接：" + URL + "\n【导读】");
                subject = subject.replace("&ldquo;", "“");
                subject = subject.replace("&rdquo;", "”");
                subject = subject.replace("&lsquo;", "‘");
                subject = subject.replace("&rsquo;", "’");
                subject = subject.replace("&middot;", "·");
                subject = subject + "\n\n";
                System.out.println(subject);
                map.put(i, subject);
                i--;
                // 获取上一题的URL
                String substring = response.substring(response.lastIndexOf("<li>上一篇：<a href=\""));
                substring = substring.substring(0, substring.indexOf("\">"));
                URL = substring.replace("<li>上一篇：<a href=\"http", "http");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 写入文件
        for (Integer integer : map.keySet()) {
            WriteTxtFileUtil.writeFileWithAppend("/Users/libo/Desktop/aa.txt", map.get(integer));
        }
        System.out.println("done");
    }
}
