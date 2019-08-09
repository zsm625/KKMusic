package cn.com.zx221.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.zx221.javaweb.service.IMVService;
import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.vo.MVVO;

public class SelectMVByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceFactory factory = ServiceFactory.getFactoryInstance();
	private IMVService service = factory.createMVService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pkId = request.getParameter("pkId");
		Integer id = null;
		try {
			id = Integer.parseInt(pkId);
			MVVO mvvo = this.service.selectMyById(id);
			request.setAttribute("mvvo", mvvo);
			System.out.println(mvvo.getClass().getName());

			if (mvvo != null) {
				// 跳转播放页面
				request.getRequestDispatcher("WEB-INF/jsp/PlayMv.jsp").forward(request, response);
			} else {
				// TODO 跳转错误页面
//				request.getRequestDispatcher("WEB-INF/jsp/isError.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
