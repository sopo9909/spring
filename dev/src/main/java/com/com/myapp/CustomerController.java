package com.com.myapp;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
import java.util.Date;
@Controller
public class CustomerController {
	// 서비스를 호출하기 위해 CustomerService를 의존성을 주입.
	@Autowired
	CustomerService customerService;
	// /라는 곳으로 들어가면 ModelAndView에서의 Home을 실행한다. 이는 결과값을 main이라는 jsp를 실행시켜준다.
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView Home() {
		return new ModelAndView("/customer/main");
	}
	// 브라우저 주소가 /create 일 때, 실행되는 자바 컨트롤러 메소드를 작성
	// 브라우저 주소가 GET 방식으로 입력되었을 때, /customer/create의 jsp 경로의 뷰를 보여준다
	
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView Create() {
		return new ModelAndView("/customer/create");
	}
	
		// 입력 후 저장 버튼을 누르면, 서버가 해야 하는 일을 정의하는 것
		// RequestParam을 통해 쿼리 스트링 파라미터를 읽을 수 있게 한다.
		// Map 인터페이스는 (key:value)형식의 저장 방식을 사용함.
		// Key의 경우는 값을 저장하고 가져오기 위한 유일한 열쇠이며, value의 경우는 key에 종속된 데이터이다.
		// 키의 경우는 중복이 허용되지 않고 Value의 경우는 허용한다.
		// 가장 많이 사용하는 형태는 Map<K,V>으로 HashMap의 경우 key:value를 묶어 하나의 Entry형식으로 저장.
		// Map<String,Object>는 Map을 선언하는 것이다.
		// object는 변수가 아니라 그냥 모든 자료형을 언급한다.
		// map.get("X").toString();은 map 데이터를 문자열에 셋팅
		
	
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		//생성을 하면 그거의 생성된 id를 가져온다. 그를 통해 디테일로 넘겨준다.
		String id = this.customerService.create(map);
		if(id==null) {
			//create를 주면 연결해줌
			mav.setViewName("redirect:/create");
		}else {
			mav.setViewName("redirect:/detail?id="+id);
		}
		//mav를 실행시킨다.
		return mav;
	}
	
	@RequestMapping(value ="/detail",method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object>map) {
		// Map형태로 오니까 detailMap이라고 변수를 만들어준다.
		// Map<String, Object>를 map으로 한다.
		// 예를 들어 id = 31 : id = key, 31 = value
		// id 라는 키에 value값을 넣어준다. = #{id}
		Map<String, Object> detailMap = this.customerService.detail(map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",detailMap);
		//위에 것은 그대로 두고 map에서 뽑아온 것을 map.get("id).toString() 으로 해서 id를 뽑아온다 url 링크에서
		String id = map.get("id").toString();
		mav.addObject("id",id);//그다음에 id를 쓸 수 있도록 id를 넣어준다. 이 id는 jsp에서 사용된다.
		mav.setViewName("/customer/detail");
		return mav;
	}
	
	//이거 새로 만든 디바호
	@RequestMapping(value ="/listPage",method=RequestMethod.GET)
	public ModelAndView getListPage(@RequestParam Map<String, Object>map) {
		ModelAndView mav = new ModelAndView();
		int count = this.customerService.count();
		//이걸 고쳐보겠어요.
		int postNum;
		try {
			String post = map.get("postNum").toString();
			postNum=Integer.parseInt(post);
		}catch(NullPointerException e) {
			postNum =10;	
		}
		//여기까지 원래는 int postNum =10;
		//ceil은 나누고 그 위에 가장 큰 수 1/5 = 0.2지만 => 1로 표현함
		int pageNum =(int)Math.ceil((double)count/postNum);
		int num;
		
		try {
			//Integer.parseInt는 문자를 숫자로 변환해주는 공식
		num=Integer.parseInt(map.get("num").toString());
		}catch(NullPointerException e) {
			num=1;
		}
		//한 페이지에 몇 개의 게시글이 표시되는지
		int displayPost =(num-1)*postNum;
		//이거는 몇 개씩 표현되는지 확인하는 것 하단에 표시되는 것들이
		int pageNum_cnt = 5;
		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);
		// 표시되는 페이지 번호 중 첫번째 번호
		// 호영스 컬쳐에 제일 처음 
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		// 원래 int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
		// 총 페이지 갯수를 정하는 것
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)postNum));
		// 만약 초과되면 바꿔줌
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		// String tot = this.customerService.count(map);
		List<Map<String, Object>> list = this.customerService.listPage(displayPost, postNum);
		// 이것은 삼항 연산자 조건 ? X : Y 조건이 맞으면, X로 아니면 Y로 보내줌.
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum_tmp * pageNum_cnt >= count ? false : true;
		
		mav.addObject("postNum",postNum);
		mav.addObject("list",list);
		mav.addObject("pageNum",pageNum);
		mav.addObject("startPageNum", startPageNum);
		mav.addObject("endPageNum", endPageNum);
		mav.addObject("prev", prev);
		mav.addObject("next", next);
		mav.addObject("select", num);
		
		mav.setViewName("/customer/listPage");
		return mav;
	}
	//여기까지
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String,Object>map) {
		Map<String,Object> detailMap = this.customerService.detail(map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",detailMap);
		mav.setViewName("/customer/update");
		return mav;
	}
	
	@RequestMapping(value ="/update",method =RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object>map) {
		ModelAndView mav = new ModelAndView();
		boolean isUpdateSuccess = this.customerService.edit(map);
		if(isUpdateSuccess) {
			String id = map.get("id").toString();
			mav.setViewName("redirect:/detail?id="+id);
		}else {
			mav = this.update(map);
		}
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)  
	public ModelAndView deletePost(@RequestParam Map<String, Object> map) {  
		ModelAndView mav = new ModelAndView();  
		boolean isDeleteSuccess = this.customerService.remove(map);
		//성공했으면 1이 들어올거야 delete에서 영향 받은 것이 된다 =1이기 때문에 가능함.
		if (isDeleteSuccess) {  
			mav.setViewName("redirect:/list");  
		}else {  
			String id = map.get("id").toString();  
			mav.setViewName("redirect:/detail?id=" + id);  
		}  
		return mav;  
	}
	
	@RequestMapping(value = "/list")  
	public ModelAndView list(@RequestParam Map<String, Object> map) {  
		List<Map<String, Object>> list = this.customerService.list(map);  
		ModelAndView mav = new ModelAndView();  
		mav.addObject("data", list);  
		mav.setViewName("/customer/list");  
		return mav;  
	}
	
	@RequestMapping(value = "/search")  
	public ModelAndView search(@RequestParam Map<String, Object> map) {  
		List<Map<String, Object>> list = this.customerService.search(map);  
		ModelAndView mav = new ModelAndView();  
		mav.addObject("data", list);  
		if(map.containsKey("keyword")) {
			mav.addObject("keyword",map.get("keyword"));
		}
		mav.setViewName("/customer/search");  
		return mav;  
	}  
	
	@RequestMapping(value = "/search2")  
	public ModelAndView search2(@RequestParam Map<String, Object> map) {    
		long systemTime = System.currentTimeMillis();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sf3 = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		SimpleDateFormat sf4 = new SimpleDateFormat("yyyy-MM-dd kk");
		long s=0;
		String s1;
		ModelAndView mav = new ModelAndView();   
		if(map.containsKey("keyword2")) {
			if("none".equals(map.get("keyword2"))) 
			{s=systemTime;
			 s1=sf.format(s);
			 map.put("keyword2", s1);
			 mav.addObject("keyword2",s1);
			}
			else if("15s".equals(map.get("keyword2")))	
				{s= systemTime-15*1000;
				 s1=sf.format(s);
				 map.put("keyword2", s1);
				 mav.addObject("keyword2",s1);
				}
			else if("30s".equals(map.get("keyword2")))
				{s= systemTime-30*1000;
				 s1=sf.format(s);
				 map.put("keyword2", s1);
				 mav.addObject("keyword2",s1);
				}
			else if("1m".equals(map.get("keyword2")))		
				{s= systemTime-60*1000;
				 s1=sf3.format(s);
				 map.put("keyword2", s1);
				 mav.addObject("keyword2",s1);
				}
			else if("30m".equals(map.get("keyword2")))	
				{s= systemTime-1800*1000;
				 s1=sf3.format(s);
				 map.put("keyword2", s1);
				 mav.addObject("keyword2",s1);
				}
			else if("1h".equals(map.get("keyword2")))		
				{s= systemTime-3600*1000;
				 s1=sf4.format(s);
				 map.put("keyword2", s1);
				 mav.addObject("keyword2",s1);
				}
			else if("1d".equals(map.get("keyword2")))		
				{s= systemTime-86400*1000;
				 s1=sf2.format(s);
				 map.put("keyword2", s1);
				 mav.addObject("keyword2",s1);
			 	}
			else{
				mav.addObject("keyword2",map.get("keyword2"));}
				}
		List<Map<String, Object>> list = this.customerService.search2(map);
		mav.addObject("data", list); 
		mav.setViewName("/customer/search2");  
		return mav;  
	} 
	
	@RequestMapping(value = "/search3")  
	public ModelAndView search3(@RequestParam Map<String, Object> map) {  
		List<Map<String, Object>> list = this.customerService.search3(map);  
		ModelAndView mav = new ModelAndView();  
		mav.addObject("data", list);  
		if(map.containsKey("keyword3")) {
			mav.addObject("keyword3",map.get("keyword3"));
		}
		mav.setViewName("/customer/search3");  
		return mav;  
	} 

}