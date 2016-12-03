package springmvc.servlet;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlerMapping h=new HandlerMapping();
		String []s=h.getMethod("turn");
	    System.out.println(s[0]+s[1]);
	}
}
