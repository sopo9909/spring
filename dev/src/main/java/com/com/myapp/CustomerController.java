package com.com.myapp;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView Home() {
		return new ModelAndView("/customer/main");
	}
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView Create() {
		return new ModelAndView("/customer/create");
	}
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		String id = this.customerService.create(map);
		if(id==null) {
			mav.setViewName("redirect:/create");
		}else {
			mav.setViewName("redirect:/detail?id="+id);
		}
		return mav;
	}
	@RequestMapping(value ="/detail",method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object>map) {
		Map<String, Object> detailMap = this.customerService.detail(map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",detailMap);
		String id = map.get("id").toString();
		mav.addObject("id",id);
		mav.setViewName("/customer/detail");
		return mav;
	}
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
		List<Map<String, Object>> list = this.customerService.search2(map);  
		ModelAndView mav = new ModelAndView();  
		mav.addObject("data", list);  
		if(map.containsKey("keyword2")) {
			mav.addObject("keyword2",map.get("keyword2"));
		}
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