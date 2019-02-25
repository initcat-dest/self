package com.base.self.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.oracle.javafx.jmx.json.JSONException;

public class JsonCheckIsArr {
	public static void main(String[] args) throws JSONException {
//		String jsonStr = "{\"scm\":[{\"key1\":\"vlaue1\",\"key2\":\"vlaue2\"},{\"key11\":\"vlaue11\",\"key22\":\"vlaue22\"}]}";
//		String jsonStr = "[{\"key1\":\"vlaue1\",\"key2\":\"vlaue2\"},{\"key11\":\"vlaue11\",\"key22\":\"vlaue22\"}]";
//		String jsonStr = "[{\"expression\": \"1\", \"request\": \"invest_intent\"},{\"expression\": \"0\", \"request\": \"test\"}]";
//		Object json = new JSONTokener(jsonStr).nextValue();
//		System.out.println(json.toString());
//		System.out.println("is object:" + (json instanceof JSONObject));
//		System.out.println("is array:" + (json instanceof JSONArray));
//		System.out.println("done");
		
		String test = "{\"audit_img_count\":\"0\",\"audit_item\":[\"audit_name\",\"audit_phone\"]}";
		JsonObject jsonObject = JSONUtils.toJsonObject(test);
		JsonElement jsonElement = jsonObject.get("audit_item");
		JsonArray jsonArray = JSONUtils.toJsonArray(jsonElement);
		System.out.println(jsonArray.toString());
		for (JsonElement jsonElement2 : jsonArray) {
			System.out.println(jsonElement2.toString());
		}
	}
}
