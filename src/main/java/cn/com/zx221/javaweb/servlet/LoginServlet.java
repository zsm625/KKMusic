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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		boolean flag = false;
		String userName = request.getParameter("account");
		String myPassword = request.getParameter("password");
		IUserService userService = ServiceFactory.getFactoryInstance().createIUserService();
		String password = userService.findPassword(userName);
		//System.out.println(userName+"-----hhhh");
		if(password==null||!password.equals(myPassword)) {
			request.setAttribute("loginflag", flag);
			request.getRequestDispatcher("loginUIServlet").forward(request, response);
		}else {
			UserVO userVO = userService.findUser(userName);
			//System.out.println(userVO.getUserPassword()+"-----jjj");
			HttpSession session = request.getSession();
            session.setAttribute("userVO", userVO);
            request.getRequestDispatcher("html/singer/singer.html").forward(request, response);
		}
	}
}
