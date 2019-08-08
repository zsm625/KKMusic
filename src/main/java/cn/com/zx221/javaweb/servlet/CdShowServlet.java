package cn.com.zx221.javaweb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.zx221.javaweb.service.ICdService;
import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.util.Constant;
import cn.com.zx221.javaweb.vo.CdVo;

/**
 * Servlet implementation class CdShowServlcet
 */
public class CdShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		byte[] bytes = keyword.getBytes("iso-8859-1");
		keyword = new String(bytes, "utf-8");
		ICdService cdS = ServiceFactory.getFactoryInstance().createCdService();
		List<CdVo> cdList = cdS.findCd(keyword);
		if (cdList != null) {
			request.setAttribute("cdList", cdList);
			request.getRequestDispatcher("/WEB-INF/jsp/cdList.jsp").forward(request, response);
		}

	}
//		request.setAttribute("listName", listName);

}
