package cn.com.zx221.javaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class CharsetFilter
 */
public class CharsetFilter implements Filter {

	private String charset = "utf-8";

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("字符编码:" + this.charset);
		request.setCharacterEncoding(this.charset);
		response.setCharacterEncoding(this.charset);
		response.setContentType("text/html;charset=" + this.charset);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String charset = fConfig.getInitParameter("charset");
		if (charset != null) {
			this.charset = charset;
		}
	}

	@Override
	public void destroy() {
	}

}
