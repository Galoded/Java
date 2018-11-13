package cn.supreme.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//使用controller接口可以实现后端处理器逻辑
public class UserController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 接受请求，调用业务方法，封装数据，返回结果数据 
		ModelAndView mv = new ModelAndView();
		mv.addObject("world","donghao");
		// mv.setViewName("WEB-INF/view/hello.jsp");
		mv.setViewName("hello");
		return mv;
	}

}
