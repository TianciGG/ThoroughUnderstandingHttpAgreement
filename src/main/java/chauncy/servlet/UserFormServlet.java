package chauncy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserFormServlet")
public class UserFormServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName=req.getParameter("userName");
		String pwd=req.getParameter("pwd");
		//自定义请求头
		String token = req.getHeader("token");
		System.out.println("userName:"+userName+"-----pwd:"+pwd+"-----token:"+token);
		resp.getWriter().write("success!");
	}
}
