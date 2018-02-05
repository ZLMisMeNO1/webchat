/** 
 * Project Name:webchat 
 * File Name:IndexController.java 
 * Package Name:cn.i7baoz.blog.webchat.controller 
 * Date:2018年2月5日上午10:40:34 
 * 
 */  
  
package cn.i7baoz.blog.webchat.controller;  

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/** 
 * ClassName:IndexController 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年2月5日 上午10:40:34 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Controller
public class IndexController extends BaseController{
	
	@RequestMapping("/{room}")
	public ModelAndView index(
			@PathVariable(value="room") String room,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("index");
		//channel不存在
		if ( null == room || room.isEmpty() ) {
			//返回首页
			return modelAndView;
		}
		//channel非数字
		Integer c = null;
		try {
			c = Integer.valueOf(room);
		} catch ( Exception e ) {
			//返回首页
			return modelAndView;
		}
		//检测房间号是否存在
		//不存在返回首页
		
		//ws://localhost:7397
		String socketURI = "ws://" + request.getServerName() + ":" + c ;
		System.out.println(socketURI);
		modelAndView = new ModelAndView("chat/room");
		modelAndView.addObject("socketURI", socketURI);
		return modelAndView;
	}
}
 