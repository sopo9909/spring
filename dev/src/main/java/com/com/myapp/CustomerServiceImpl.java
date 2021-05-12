package com.com.myapp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDao customerDao;
	
	@Override
	public String create(Map<String,Object> map) {
		int affectRowCount = this.customerDao.insert(map);
		if (affectRowCount == 1) {
			return map.get("id").toString();
		}
		return null;
	}
	@Override
	public Map<String,Object> detail(Map<String,Object> map){
		return this.customerDao.selectDetail(map);
	}
	
	@Override  
	public boolean edit(Map<String, Object> map) {  
	int affectRowCount = this.customerDao.update(map);  
	return affectRowCount == 1;  
	}  
	
	@Override  
	public boolean remove(Map<String, Object> map) {  
	int affectRowCount = this.customerDao.delete(map);  
	return affectRowCount == 1;  

	}  
	@Override  
	public List<Map<String, Object>> list(Map<String, Object> map){  
	return this.customerDao.selectList(map);  
	}  
	@Override  
	public List<Map<String, Object>> search(Map<String, Object> map){  
	return this.customerDao.searchList(map);  
	}
	@Override  
	public List<Map<String, Object>> search2(Map<String, Object> map){  
	return this.customerDao.searchList2(map);  
	}
	@Override  
	public List<Map<String, Object>> search3(Map<String, Object> map){  
	return this.customerDao.searchList3(map);  
	}
}
