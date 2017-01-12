package com.cn.yk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public void init(ServletConfig config)  throws ServletException{
    	 /**
          * ��д��Servlet��init������һ��Ҫ�ǵõ��ø����init������
          * ������service/doGet/doPost������ʹ��getServletContext()������ȡServletContext����ʱ
          * �ͻ����java.lang.NullPointerException�쳣
          */
         super.init(config); 
         System.out.println("---loginServlet��ʼ����ʼ---");
     }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try{
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Myfisrt</title>");
	        out.println("<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'></meta>");
			out.println("<link href='css/login.css' rel='stylesheet' type='text/css' />");
			out.println("<script src='js/jquery-1.11.1.min.js'></script>");
			out.println("<script src='js/login.js'></script>");
	        out.println("</head>");
			out.println("<body bgcolor=#CED2FF>");
			out.println("<h2>��¼ҳ��</h2>");
//			out.println("<form action='js/login.js'>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>����:<input type='text' class='username' placeholder='�����û���' name='username' id='username'/></th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>���룺<input type='password' class='password' placeholder='��������' name='password' id='pass'/></th>");
			out.println("</tr>");
			out.println("<tr colspan=3>");
		    out.println("<th><input type=checkbox id='checkbox' name='keep' value='��������'>�����������½</input></th>");
			out.println("<th><input class='submit' type='submit' value='��¼'></input></th>");
			out.println("<th><input type='reset' value='����'></input></th>");
			out.println("</tr>");
//			out.println("</form>");
			out.println("</html>");
		}finally{
			out.close();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
    public void destroy(){
    	super.destroy();
    	System.out.println("destroy------------loginservlet");
    }
}
