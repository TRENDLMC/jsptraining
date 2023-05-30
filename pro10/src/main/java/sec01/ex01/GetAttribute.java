package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/get")
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		ServletContext ctx=getServletContext();
		HttpSession session=request.getSession();
		String ctxMesg=(String) ctx.getAttribute("context");
		String sesMesg=(String) session.getAttribute("session");
		String reqMesg=(String) request.getAttribute("request");
		out.print("context값 :"+ctxMesg+"<br>");
		out.print("sessuion값 :"+sesMesg+"<br>");
		out.print("request값 :"+reqMesg+"<br>");
	}

}
