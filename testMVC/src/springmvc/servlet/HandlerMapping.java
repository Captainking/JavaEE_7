package springmvc.servlet;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HandlerMapping {

	Method method;
	
	public void setClassNames(String fileName) {
			
		
	}
	public String[] getMethod(String methodname) {
		String []str=new String[2];
		try {
			
	        
	        
                Getallclass getallclass=new Getallclass("springmvc.controller");
                //测试部分
            	Set<String> classNames = getallclass.getClassNames();
        		 if (classNames != null) {
        		 for (String className : classNames) {//获取了每一个包下的所有类
        		 Class clazz = Class.forName(className);
                 Method[] methods = clazz.getMethods();
                 for (Method method : methods) {
                     String methodName = method.getName();
                     if(methodName.equals(methodname)){
                    	 str[0]=className;
                    	 str[1]=methodName;
                    	 return str;
                     }
        		 
        		 }
        		 }
        		 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
