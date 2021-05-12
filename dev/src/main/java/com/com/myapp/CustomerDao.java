package com.com.myapp;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CustomerDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String,Object> map) {
		return this.sqlSessionTemplate.insert("customer.insert",map);
	}
	public Map<String,Object> selectDetail(Map<String, Object>map){
		return this.sqlSessionTemplate.selectOne("customer.select_detail",map);
	}
	public int update(Map<String, Object> map) {  
		return this.sqlSessionTemplate.update("customer.update", map);  
		}  
	public int delete(Map<String, Object> map) {  
		return this.sqlSessionTemplate.delete("customer.delete", map);  
		} 
	public List<Map<String, Object>> selectList(Map<String, Object> map) {  
		return this.sqlSessionTemplate.selectList("customer.select_list", map);  
		} 
	public List<Map<String, Object>> searchList(Map<String, Object> map) {  
		return this.sqlSessionTemplate.selectList("customer.search_list", map);  
		}
	public List<Map<String, Object>> searchList2(Map<String, Object> map) {  
		return this.sqlSessionTemplate.selectList("customer.search_list2", map);  
		}
	public List<Map<String, Object>> searchList3(Map<String, Object> map) {  
		return this.sqlSessionTemplate.selectList("customer.search_list3", map);  
		}
	
}
