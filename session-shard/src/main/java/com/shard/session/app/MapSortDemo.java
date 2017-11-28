package com.shard.session.app;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class MapSortDemo {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("x", "a");
		map.put("a", "x");
		System.out.println(JSON.toJSONString(map));

	}
}
