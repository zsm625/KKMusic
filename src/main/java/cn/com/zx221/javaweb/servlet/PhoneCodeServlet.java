package cn.com.zx221.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.zx221.javaweb.smsVerification.PhoneCode;

/**
 * Servlet implementation class PhoneCodeServlet
 */
public class PhoneCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phoneNumber = request.getParameter("phonenumber");
		String sms = request.getParameter("sms");
		if (phoneNumber != null) {
			byte[] bytes2 = phoneNumber.getBytes("ISO-8859-1");
			phoneNumber = new String(bytes2, "UTF-8");
		}
		if (sms != null) {
			byte[] bytes3 = sms.getBytes("ISO-8859-1");
			sms = new String(bytes3, "UTF-8");
		}
		System.out.println(phoneNumber+sms);
		PhoneCode phoneCode = new PhoneCode();
		phoneCode.getPhonemsg(phoneNumber);
		String code = phoneCode.code;
		HttpSession session = request.getSession();
		session.setAttribute("sms", code);
		//boolean flag1 = code.equals(sms);
	}

}
