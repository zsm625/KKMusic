package cn.com.zx221.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectMVServlet")
public class SelectMVServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 显示当前页码对应MV的LI
	 * 1.接收当前要显示的页码
	 * 2.接收查询条件
	 * 3.调用后面的service,获得当前页码要显示的所有食品的list
	 *    (将List设置到request中)
	 * 4.转向jsp显示li
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}

}
