package com.jimmy.core.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.jimmy.core.dto.UserDto;

/**  
 * springmvc controller 层常规代码
 *  
 * @author Jimmy.Fang
 * @date 2018年3月15日  新建  
 */
@Controller
//表示当前类是一个controller
@RequestMapping("/order") 
//类定义处未标注 @RequestMapping,则方法处标记的 URL 相对于WEB 应用的根目录,一般定义的是一个模块的别名
public class SpringmvcController1 {
	
	/**
	 * 最简单获取页面传递参数id=2
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/findById",method=RequestMethod.GET) 
	public String getOrderById(int id){
		System.out.println(1);
		return "success";
	}
	/**
	 * 严格格式，通过占位符方式获取
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/findById/{id}",method=RequestMethod.GET) 
	public String getOrderById2(@PathVariable("id") int id){
		System.out.println(2);
		//使用占位符
		return "success";
	}
	
	/***
	 *  GET 用来获取资源,
　　　　　　 POST 用来新建资源,
　　　　　　 PUT 用来修改资源,
　　　　　　 DELETE 用来删除资源。
	 * @param id  传递的参数必须填，默认值10
	 * @return
	 */
	@RequestMapping(value="/findById",method=RequestMethod.POST) 
	public String getOrderById3(@RequestParam(value="id",required=true,defaultValue="10") int id){
		System.out.println(3);
		//限定参数名字，默认值，是否必须传递
		return "success";
	}
	
	/**
	 * 返回ModelAndView,携带对象到页面，如果使用返回值是string也可以做到，非常灵活
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/mv",method=RequestMethod.GET) 
	public ModelAndView modeldemo(@RequestParam(value="id",required=true,defaultValue="10") int id){
		ModelAndView mv = new ModelAndView("success");
		System.out.println(4);
		
		//模型
        mv.addObject("message","此信息能传给跳转后的视图中");
		return mv;
	}
	
	//==================================================================传参===================================================================
	/**
	 * 获取页面参数方法使用HttpServletRequest获取，使用Model接口传递到下一步
	 * 
	 * 方法中获得request，reponse
	 */
	@RequestMapping(value="/mv2",method=RequestMethod.GET) 
	public ModelAndView modeldemo2(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("success");
		System.out.println(4);
		model.addAttribute("name", request.getParameter("name"));
	    model.addAttribute("password", request.getParameter("password"));
		//模型
        mv.addObject("message","此信息能传给跳转后的视图中");
		return mv;
	}
	
	/**
     * 自动注入bean属性，自动通过页面传递组装成userdto
     */
    @RequestMapping("/login")
    public String login(UserDto user,Model model){
        model.addAttribute("name", user.getUserName());
        model.addAttribute("password", user.getPassword());
        System.out.println(JSON.toJSON(user));
        return "success";
    }
	
	/**
	 * 返回json对象
	 * @return
	 */
	@RequestMapping(value="/getUserList",produces="text/html;charset=UTF-8" )//有2种方式，一种在这里显示配置，一种去配置springmvc.xml
	@ResponseBody
	public List<UserDto> findList(){
		List<UserDto> lists = new ArrayList<UserDto>();
		UserDto user = new UserDto();
		user.setAge(10);
		user.setUserName("fangjian");
		user.setPassword("123456");
		lists.add(user);
		return lists;
	}
}
