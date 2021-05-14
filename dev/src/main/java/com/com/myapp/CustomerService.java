package com.com.myapp;

import java.util.List;
import java.util.Map;
//서비스는 Dao를 호출한 결과를 바로 리턴하는 일만 한다.
public interface CustomerService {

	String create(Map<String, Object> map);

	Map<String, Object> detail(Map<String, Object> map);

	boolean edit(Map<String, Object> map);

	boolean remove(Map<String, Object> map);

	List<Map<String, Object>> list(Map<String, Object> map);

	List<Map<String, Object>> search(Map<String, Object> map);

	List<Map<String, Object>> search2(Map<String, Object> map);

	List<Map<String, Object>> search3(Map<String, Object> map);
	//이거 새로하는 count
	int count();

	List<Map<String, Object>> listPage(int displayPost, int postNum);

}
