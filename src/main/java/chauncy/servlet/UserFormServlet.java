package chauncy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

@WebServlet("/UserFormServlet")
public class UserFormServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("使用Get请求访问，即将跳转到POST请求");
		this.doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName=req.getParameter("userName");
		String pwd=req.getParameter("pwd");
		//自定义请求头
		String token = req.getHeader("token");
		System.out.println("userName:"+userName+"-----pwd:"+pwd+"-----token:"+token);
		/* 1.使用后台response添加header解决ajax请求跨域问题
		 * //以下这句话只针对本请求可以支持跨域，如果想让所有请求都能跨域就要在Filter中使用这句话。
		 * resp.setHeader("Access-Control-Allow-Origin", "*");//第二个参数：*表示允许所有网站，前端可以跨域访问，也可固定写死某个网站URL地址。
		 */	
		//2.使用jsonp解决ajax请求跨域问题
		String jsonpCallback = req.getParameter("jsonpCallback");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");	
		//返回形式，必须加上前台获取的参数，而且必须是JsonObject对象
		resp.getWriter().write(jsonpCallback+"("+jsonObject.toString()+")");
	}
}
