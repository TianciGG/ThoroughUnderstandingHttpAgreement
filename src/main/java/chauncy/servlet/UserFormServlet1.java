package chauncy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

@WebServlet("/UserFormServlet1")
public class UserFormServlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		// resp.setHeader("Access-Control-Allow-Origin", "*");
		 String userName = req.getParameter("userName");
		 String sex= req.getParameter("sex");
		 System.out.println(userName + "----" + sex+"---"+req.getMethod());
		// JSONObject JSONObject1 = new JSONObject();
		// JSONObject1.put("success", "添加成功!");
		// resp.getWriter().write("callbackparam(" + JSONObject1.toJSONString()
		// + ")");

		try {
			resp.setContentType("text/plain");
			resp.setHeader("Pragma", "No-cache");
			resp.setHeader("Cache-Control", "no-cache");
			resp.setDateHeader("Expires", 0);
			PrintWriter out = resp.getWriter();
			JSONObject resultJSON = new JSONObject(); // 根据需要拼装json
			resultJSON.put("result", "content");
			String jsonpCallback = req.getParameter("jsonpCallback");// 客户端请求参数
			out.println(jsonpCallback + "(" + resultJSON.toJSONString() + ")");// 返回jsonp格式数据
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
