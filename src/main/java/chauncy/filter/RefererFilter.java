package chauncy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**   
 * @classDesc: 功能描述(防止盗用下载过滤器)  
 * @author: ChauncyWang
 * @createTime: 2019年4月9日 下午3:55:14   
 * @version: 1.0  
 */  
public class RefererFilter implements Filter{
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		//每次的请求来源
		String referer = httpRequest.getHeader("referer");
		//获取请求地址
		String serverName = httpRequest.getServerName();
		System.out.println("referer:"+referer+"-----serverName:"+serverName);
		//referer == null表示用户直接通过链接访问资源
		if(referer == null || !referer.contains(serverName)){
			httpRequest.getRequestDispatcher("/static/error.png").forward(httpRequest, httpResponse);
			return;
		}
		chain.doFilter(httpRequest, httpResponse);
	}
	
	public void destroy() {
		
	}

}
