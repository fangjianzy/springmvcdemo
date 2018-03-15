package com.jimmy.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**  
 * 类说明   
 *  
 * @author Jimmy.Fang
 * @date 2018年3月15日  新建  
 */
@Controller
//表示当前类是一个controller
@RequestMapping("/order") 
//类定义处未标注 @RequestMapping,则方法处标记的 URL 相对于WEB 应用的根目录,一般定义的是一个模块的别名
public class SpringmvcController1 {
	
	//具体方法
	@RequestMapping(value="/findById",method=RequestMethod.GET) 
	public String getOrderById(int id){
		
		return "success";
	}
	
	//具体方法2
	@RequestMapping(value="/findById/{id}",method=RequestMethod.GET) 
	public String getOrderById2(@PathVariable("id") int id){
		//使用占位符
		return "success";
	}
	
	/***
	 * ☐ GET 用来获取资源,
　　　　　　☐ POST 用来新建资源,
　　　　　　☐ PUT 用来修改资源,
　　　　　　☐ DELETE 用来删除资源。
	 * @param id
	 * @return
	 */
	//具体方法3
	@RequestMapping(value="/findById",method=RequestMethod.POST) 
	public String getOrderById3(@RequestParam(value="id",required=true,defaultValue="10") int id){
		//限定参数名字，默认值，是否必须传递
		return "success";
	}
}
