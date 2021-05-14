package com.com.myapp;
import java.util.HashMap;
//매퍼 XML을 실행시키는 DAO클래스
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CustomerDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	//SqlSessionTemplate
	//SqlSession의 구문을 실행하는 메서드는 selectOne, selectList, select, selectMap, insert, update, delete가 있다. 
	//selectOne 메서드는 한 개 이상의 객체나 null이 return된다면 예외가 발생하므로, 객체가 얼마나 리턴될지 모른다면 selectList 메서드를 사용해야 한다. 
	//insert, update, delete 메서드에 의해 리턴되는 값은 실행된 구문에 의해 영향을 받은 레코드수를 표시한다
	
	//서비스 임플의 create를 실행시키면, insert가 실행된다. 이것은 xml의 insert를 보내고 입력이 다 끝난 후, keyProperty="id"를 통해 내보낸다.
	public int insert(Map<String,Object> map) {
		return this.sqlSessionTemplate.insert("customer.insert",map);
	}
	public Map<String,Object> selectDetail(Map<String, Object>map){
		return this.sqlSessionTemplate.selectOne("customer.select_detail",map);
	}
	//selectOne은 데이터를 한 개만 가져올 때 사용한다. 만약 쿼리 결과 행 수가 0개면,selectOne 메소드는 null을 반환하게 되며, 쿼리 결과가 여러 개면 TooManyResult 라는 예외를 던진다.
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
	//이거 새로하는 count
	public int count(){
		return this.sqlSessionTemplate.selectOne("customer.count");
	}
	public List<Map<String, Object>> listPage(int displayPost, int postNum) {
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		data.put("displayPost", displayPost);
		data.put("postNum",postNum);
		return this.sqlSessionTemplate.selectList("customer.listPage",data);
	}
}
