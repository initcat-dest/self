package com.base.self.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * fastjson格式化
 *
 * @author libo
 * @package com.base.self.json
 * @company xmiles
 * @date 2019/2/22
 */
public class FastjsonJsonFormat {

    private static final String jsonStr = "{\"name\":\"data\"," +
            "\"value\":\"{\\\"name\\\":\\\"张成军\\\"," +
            "\\\"gender\\\":\\\"1\\\"," +
            "\\\"phone\\\":\\\"15022719116\\\"," +
            "\\\"ip\\\":\\\"218.68.233.11\\\"," +
            "\\\"birthday\\\":\\\"1975-2-3\\\"," +
            "\\\"page_type\\\":\\\"CZ_WALLET_TGY\\\"," +
            "\\\"phead\\\":{\\\"pversion\\\":0,\\\"cversion\\\":0,\\\"channel\\\":1000,\\\"original_channel\\\":0," +
            "\\\"activity_channel\\\":0,\\\"sdk\\\":0,\\\"cip\\\":\\\"218.68.233.11\\\",\\\"cityid\\\":\\\"440100\\\"," +
            "\\\"gcityid\\\":\\\"440100\\\",\\\"platform\\\":\\\"android\\\",\\\"prdid\\\":\\\"-1\\\"," +
            "\\\"ua\\\":\\\"Mozilla/5.0 (Linux; Android 8.0.0; PRA-AL00X Build/HONORPRA-AL00X; wv) AppleWebKit/537.36 " +
            "(KHTML, like Gecko) Version/4.0 Chrome/68.0.3440.91 Mobile Safari/537.36 clicash_android v\\u003d1.757\\\"}}\"}";

    public static void main(String[] args) {
        FastjsonJsonFormat service = new FastjsonJsonFormat();
        // simple
        String ua = JSON.parseObject(JSON.parseObject(jsonStr).getString("value")).getJSONObject("phead")
                .getString("ua");
        System.out.println(ua);

        // complex
        JSONObject jsonObject = service.stringToJSONObject(jsonStr);
        String valueStr = service.getKeyValue(jsonObject, "value");
        JSONObject valueJSONObject  = service.stringToJSONObject(valueStr);
        String pheadJSONObjectStr = service.getKeyValue(valueJSONObject, "phead");
        JSONObject pheadJSONObject = service.stringToJSONObject(pheadJSONObjectStr);
        ua = service.getKeyValue(pheadJSONObject, "ua");
        System.out.println(ua);

        //
        System.out.println(service.getKeyValue(jsonStr, new String[]{"value", "phead", "ua"}));
    }

    /**
     * jsonString 转换成 JSONObject
     */
    private JSONObject stringToJSONObject(String jsonStr) {
        return JSON.parseObject(jsonStr);
    }

    /**
     * 获取JSONObject对象key对应的value
     */
    private String getKeyValue(JSONObject object, String key) {
        return object.getString(key);
    }

    /**
     * 获取jsonString中key对应的value
     */
    private String getKeyValue(String jsonStr, String[] keys) {
        String value = "";
        JSONObject jsonObject = stringToJSONObject(jsonStr);
        for (String key : keys) {
            jsonObject = StringUtils.isNotBlank(value) ? stringToJSONObject(value) : jsonObject;
            value = getKeyValue(jsonObject, key);
        }
        return value;
    }

}
