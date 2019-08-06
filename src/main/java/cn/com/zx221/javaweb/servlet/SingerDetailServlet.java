package cn.com.zx221.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.service.SingerService;
import cn.com.zx221.javaweb.vo.SingerVo;

/**
 * Servlet implementation class SingerDetailServlet
 */
public class SingerDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String singerid = request.getParameter("id");
		int singer_id = -1;
		try {
			singer_id = Integer.parseInt(singerid);
		}catch(Exception e) {}
		System.out.println(singer_id);
		SingerService singerService = ServiceFactory.getFactoryInstance().createSingerService();
		SingerVo singerVo = singerService.findSingerById(singer_id);
		System.out.println(singerVo);
		//System.out.println(singerVo.getSinger_areaId());
		request.setAttribute("singerVo", singerVo);
		request.getRequestDispatcher("/WEB-INF/jsp/singerDetail.jsp").forward(request, response);
	}

}
