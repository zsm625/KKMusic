package cn.com.zx221.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.zx221.javaweb.service.IUserService;
import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.vo.UserVO;

/**
 * Servlet implementation class MyMusicServlet
 */
public class MyMusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUserService userService = ServiceFactory.getFactoryInstance().createIUserService();
		HttpSession session = request.getSession();
		if (session == null) {
			// 没有登录成功，跳转到登录页面
			response.sendRedirect("LoginUIServlet");
		} else {
			UserVO userVO = (UserVO) session.getAttribute("userVO");
			if (userVO == null) {
				response.sendRedirect("LoginUIServlet");
			} else {
				 int userId = userVO.getUserId();
				 UserVO user = userService.findUserById(userId);
				request.getRequestDispatcher("/WEB-INF/jsp/myMusic.jsp").forward(request, response);
			}
		}
	}

}
