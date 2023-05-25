package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/login")
public class SessionTest4 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//
		response.setContentType("text/html; charset=utf-8");//html 방식으로 들어오고 언어 반응 언어는 utf-8이다
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		if(session.isNew()) {
			if(user_id !=null) {
				session.setAttribute("user_id", user_id);//값을 세션에 저장
				out.println("<a href='login'>로그인상태확인</a>");
			}else {
				out.println("<a href='login2.html'>다시로그인하세요1</a>");
				session.invalidate();
			}
		}else {
			user_id=(String)session.getAttribute("user_id");//값을 세션에서받아옴
			System.out.println(user_id);//받아온값이있으면
			if(user_id !=null && user_id.length() != 0) {
				out.print("안녕하세요"+user_id+"님!!!");
			}else {
				out.print("<a href='login2.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}
		
	}
}
