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
			// map id를 가져와서 보내준다. 그러면 컨트롤러에서 id를 받는다.
			return map.get("id").toString();
		}
		return null;
	}
	//컨트롤러에서 detail을 보내면 selectDetail이라는 것을 수행시킨다.
	//이것은 Dao의 selectOne을 수행시킨다.
	@Override
	public Map<String,Object> detail(Map<String,Object> map){
		return this.customerDao.selectDetail(map);
	}
	//SqlSessionTemplate에서 반환된 값이 1이라서 affectRowCount가 1이 된다.
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
	//이거 새로하는 count
	@Override
	public int count(){
		return this.customerDao.count(); 
	}
	@Override
	public List<Map<String, Object>> listPage(int displayPost,int postNum){
		return this.customerDao.listPage(displayPost,postNum); 
	}

}
