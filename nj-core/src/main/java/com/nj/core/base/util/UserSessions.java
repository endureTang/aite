package com.nj.core.base.util;

import java.util.HashMap;
import java.util.Map;

public class UserSessions {

	@SuppressWarnings("rawtypes")
	private static final ThreadLocal USER_SESSIONS = new ThreadLocal();

	protected UserSessions() {
	}

	@SuppressWarnings("unchecked")
	public static <T> T get(String attribute, Class<T> clazz) {
		return (T) get(attribute);
	}

	public static Object get(String attribute) {
		Map<?, ?> map = (Map<?, ?>) USER_SESSIONS.get();
		return map.get(attribute);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void set(String attribute, Object value) {
		Map map = (Map) USER_SESSIONS.get();

		if (map == null) {
			map = new HashMap();
			USER_SESSIONS.set(map);
		}

		map.put(attribute, value);
	}

}
