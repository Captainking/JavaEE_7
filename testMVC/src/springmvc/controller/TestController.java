package springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestController {

	public String hello(){
		return "helloworld.jsp";
	}
	public int add(Integer a,Integer b)
	{
		return a+b;
	}
}
