package springmvc.servlet;

import javax.servlet.http.HttpServlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import sun.util.resources.cldr.ss.CalendarData_ss_SZ;
public class DispatcherServlet extends HttpServlet{


    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	System.out.println(System.getProperty("user.dir"));
    	String string;
        // 获取方法名字
        String servletPath = request.getServletPath();// /xxxxxx.do
        // 去掉斜杠和.do
        String methodName = servletPath.substring(1, servletPath.length() - 3);// xxxxxx
        try {
            // 利用反射获取方法
        	if(methodName.equals("hello")){
        	 HandlerMapping h=new HandlerMapping();
     		String []strings=h.getMethod(methodName);
     		System.out.println("======"+strings[0]+strings[1]);
     		Class c = Class.forName(strings[0]);
     		Object yourObj = c.newInstance();
     		Method m=c.getDeclaredMethod(strings[1]);
     		request.getRequestDispatcher("/"+(String)m.invoke(yourObj)).forward(request,response);;
     		
     	
//            response.setContentType("text/html");
//
//            // 实际的逻辑是在这里
//            PrintWriter out = response.getWriter();
//            out.println("<h1>" + (String)m.invoke(yourObj) + "</h1>");
        	}else if(methodName.equals("add")){
        		
        	   System.out.println(request.getParameter("a")+request.getParameter("b"));
        		HandlerMapping h=new HandlerMapping();
         		String []strings=h.getMethod(methodName);
         		System.out.println("======"+strings[0]+strings[1]);
         		Class c = Class.forName(strings[0]);
         		Object yourObj = c.newInstance();
         		Method m=c.getDeclaredMethod(strings[1],Integer.class,Integer.class);
         		
         		
         	
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<h1>" +request.getParameter("a")+" + "+ request.getParameter("b")+"="+ (int)m.invoke(yourObj,Integer.parseInt(request.getParameter("a")),Integer.parseInt(request.getParameter("b"))) + "</h1>");
        	}
        } catch (Exception e) {
            // TODO: handle exception
        }
       
    }
}