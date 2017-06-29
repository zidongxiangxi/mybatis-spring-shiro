package com.xw.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * JSON相关操作接口
 * 
 * @author xdchen
 *
 */
public class JsonUtil {

	/**
	 * 对象转为json字符串格式<br>
	 * 
	 * 格式化时间为yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @param obj
	 *            可以入参null
	 * @return
	 * @author xdchen
	 */
	public static String toJSONString(Object obj) {
		try {
			return JSONObject.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss",
					SerializerFeature.WriteDateUseDateFormat);
		} catch (Exception e) {
			throw new RuntimeException("对象转换成JSON字符串出错[" + obj + "]", e);
		}
	}

	public static class JSONEntity {
		public JSONEntity(Object value) {
			if (value instanceof JSONArray) {
				JSONArray jsonArray = (JSONArray) value;
				this.size = jsonArray.size();
			} else {
				this.size = 1;
			}
			this.value = value;
		}

		private int size;
		private Object value;

		public int getSize() {
			return size;
		}

		public Object getValue() {
			return value;
		}

	}

	/**
	 * 解析JSON字符串成为一个Object，结果可能是JSONArray(多个)或JSONObject(单个)
	 * 
	 * @param jsonStr
	 *            要解析的JSON字符串
	 * @return
	 */
	public static JSONEntity parseJSONStr2JSONEntity(String jsonStr) {
		try {
			return new JSONEntity(JSON.parse(jsonStr));
		} catch (Exception e) {
			throw new RuntimeException("JSON格式错误: " + jsonStr, e);
		}
	}

	/**
	 * 字符串转为JSON对象,注意数组类型会抛异常[{name:\"xdchen\"}]
	 * 
	 * @param jsonStr
	 * @return
	 * @author xdchen
	 */
	public static JSONObject parseJSONStr2JSONObject(String jsonStr) {
		try {
			return (JSONObject) JSONObject.parse(jsonStr);
		} catch (Exception e) {
			throw new RuntimeException("JSON格式错误: " + jsonStr, e);
		}
	}

	/**
	 * 字符串转为JSON数组,注意对象类型,非数组的会抛异常{name:\"xdchen\"}
	 * 
	 * @param jsonStr
	 * @return
	 * @author xdchen
	 */
	public static JSONArray parseJSONStr2JSONArray(String jsonStr) {
		try {
			return (JSONArray) JSONArray.parse(jsonStr);
		} catch (Exception e) {
			throw new RuntimeException("JSON格式错误: " + jsonStr, e);
		}
	}

	/**
	 * 字符串转为某个类
	 * 
	 * @param jsonStr
	 * @param clazz
	 * @return
	 * @author xdchen
	 */
	public static <T> T parseJSONStr2T(String jsonStr, Class<T> clazz) {
		try {
			return JSONObject.parseObject(jsonStr, clazz);
		} catch (Exception e) {
			throw new RuntimeException("JSON格式错误: " + jsonStr, e);
		}
	}

	/**
	 * 字符串转为某个类的列表
	 * 
	 * @param jsonStr
	 * @param clazz
	 * @return
	 * @author xdchen
	 */
	public static <T> List<T> parseJSONStr2TList(String jsonStr, Class<T> clazz) {
		try {
			return JSONObject.parseArray(jsonStr, clazz);
		} catch (Exception e) {
			throw new RuntimeException("JSON格式错误: " + jsonStr, e);
		}
	}
}
