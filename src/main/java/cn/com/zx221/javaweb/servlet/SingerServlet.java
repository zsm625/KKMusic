package cn.com.zx221.javaweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.service.SingerService;
import cn.com.zx221.javaweb.vo.SingerVo;

/**
 * Servlet implementation class SingerServlet
 */
public class SingerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SingerService singerService = ServiceFactory.getFactoryInstance().createSingerService();
		List<SingerVo> singerList = singerService.findSinger(2,null, null, null, null);
		System.out.println(singerList.size());
		request.setAttribute("singerList", singerList);
		int pageNumber = singerService.PageNumber(null, null, null, null);
		request.setAttribute("pageNumber", pageNumber);
		request.getRequestDispatcher("/WEB-INF/jsp/singer.jsp").forward(request, response);
	}

}
