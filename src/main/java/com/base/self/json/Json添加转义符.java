package com.base.self.json;

import com.base.self.model.BaseTestModel;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class Json添加转义符 {

	public static void main(String[] args) {
//		BaseTestModel model = new BaseTestModel();
//		JsonObject data = new JsonObject();
//		data.addProperty("dataInfo", JSONUtils.toJson(model));
//		System.out.println(JSONUtils.toJson(data));

		JsonObject object = new JsonObject();
		List<BaseTestModel> list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			BaseTestModel test = new BaseTestModel();
			test._int = i;
			list.add(test);
		}
		object.addProperty("new_task_list", JSONUtils.toJsonString(list));
		System.out.println(object.toString());

		BaseTestModel temp0 = list.get(0);
		BaseTestModel temp1 = list.get(1);
		list.remove(0);
		list.remove(0);
		List<BaseTestModel> newList = new ArrayList<>();
		newList.addAll(list);
		newList.add(temp0);
		newList.add(temp1);
		object.addProperty("new_task_list", JSONUtils.toJsonString(newList));
		System.out.println(object.toString());
		
		String teString = "{\"$element_id\":153656939964034,\"$element_selecto\":\"banner\",\"$element_type\":192,\"$element_position\":1}";
		String json = JSONUtils.toJson(teString);
		System.out.println(json);
		
		JsonObject jsonObject = JSONUtils.toJsonObject(teString);
		System.out.println(jsonObject);
	}
	
	
	

}
