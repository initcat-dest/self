package com.base.self.http;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * class description
 *
 * @author libo
 * @package com.base.self.http
 * @company xmiles
 * @date 2019/3/16
 */
public class RestTemplateTest {

	public static void main(String[] args) {
		RestTemplate test = new RestTemplate();
		ResponseEntity<String> forEntity = test.getForEntity("http://baidu.com", String.class);
		System.out.println("===response===="+ forEntity);
	}
}
