package cn.com.zx221.javaweb.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.zx221.javaweb.service.IUserService;
import cn.com.zx221.javaweb.service.ServiceFactory;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("nickname");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phonenumber");
		String sms = request.getParameter("sms");
		if (userName != null) {
			byte[] bytes = userName.getBytes("ISO-8859-1");
			userName = new String(bytes, "UTF-8");
		}
		if (password != null) {
			byte[] bytes1 = password.getBytes("ISO-8859-1");
			password = new String(bytes1, "UTF-8");
		}
		if (phoneNumber != null) {
			byte[] bytes2 = phoneNumber.getBytes("ISO-8859-1");
			phoneNumber = new String(bytes2, "UTF-8");
		}
		if (sms != null) {
			byte[] bytes3 = sms.getBytes("ISO-8859-1");
			sms = new String(bytes3, "UTF-8");
		}
		System.out.println(userName + "," + password + "," + phoneNumber + "," + sms);
		IUserService userService = ServiceFactory.getFactoryInstance().createIUserService();
		Date registDate = new Date(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.format(registDate);
		boolean flag = userService.regist(userName, password, phoneNumber, registDate);
		System.out.println(flag);
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("sms");
		System.out.println(code);
		boolean registFlag = false;
		if (!code.equals(sms)) {
			request.setAttribute("codeFlag", registFlag);
			request.getRequestDispatcher("registUIServlet").forward(request, response);
		} else {
			if (flag != true) {
				request.setAttribute("registFlag", registFlag);
				request.getRequestDispatcher("registUIServlet").forward(request, response);
			} else {
				request.getRequestDispatcher("loginUIServlet").forward(request, response);
			}
		}
	}
}
