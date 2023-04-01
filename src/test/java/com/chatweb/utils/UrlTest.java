package com.chatweb.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlTest {


	@Test
	public void testUrl() throws Exception {

		try {
			String bing = "https://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1&mkt=zh-cn";
			String content = URLUtil.getURLContent(bing);

			//JSONArray jsonArray = (JSONArray) JSONValue.parse(content);
			//JSONParser jsonParser = new JSONParser();

            JSONObject rowData = JSONObject.parseObject(content);

            Object o = rowData.get("images");

           // System.out.println(o.toString());

            JSONArray array = (JSONArray)o;

            JSONObject object = (JSONObject)array.get(0);

            System.out.println(object.toJSONString());

            Object url = object.get("url");

			//JSONObject jsonObject= JSON.parseObject(content);

			//Object obj= JSONValue.parse(content);




			//JSONArray array=(JSONArray)obj;
			//JSONObject obj2=(JSONObject)array.get(1);
			//JSONObject jsonObject=(JSONObject)obj;

		} catch (Exception ex){
			System.out.println(ex.toString());
		}


		//JSONObject obj2=(JSONObject)array.get(1);
	}

	private Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			//log.error(e.getMessage(),e);
			return null;
		}
	}

	private List getFiledsInfo(Object o){
		Field[] fields=o.getClass().getDeclaredFields();
		String[] fieldNames=new String[fields.length];
		List list = new ArrayList();
		Map infoMap=null;
		for(int i=0;i<fields.length;i++){
			infoMap = new HashMap();
			infoMap.put("type", fields[i].getType().toString());
			infoMap.put("name", fields[i].getName());
			infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
			list.add(infoMap);
		}
		return list;
	}

}