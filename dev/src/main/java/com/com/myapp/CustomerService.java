package com.com.myapp;

import java.util.List;
import java.util.Map;

public interface CustomerService {

	String create(Map<String, Object> map);

	Map<String, Object> detail(Map<String, Object> map);

	boolean edit(Map<String, Object> map);

	boolean remove(Map<String, Object> map);

	List<Map<String, Object>> list(Map<String, Object> map);

	List<Map<String, Object>> search(Map<String, Object> map);

}
