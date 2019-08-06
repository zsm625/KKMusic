package cn.com.zx221.javaweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.zx221.javaweb.service.IMVService;
import cn.com.zx221.javaweb.service.impl.MVServiceImpl;
import cn.com.zx221.javaweb.vo.MVVO;

@WebServlet("/selectMVServlet")
public class SelectMVServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IMVService service = new MVServiceImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String path = req.getSession().getServletContext().getRealPath("/");
		// System.out.println(path);

		// mvArea=本地&mvType=儿歌
		String mvArea = req.getParameter("mvArea");
		String mvType = req.getParameter("mvType");
		int currPageNo = 1;// 当前页码
		int pageSize = 5;// 每页条数
		try {
			currPageNo = Integer.parseInt(req.getParameter("currPageNo"));
			pageSize = Integer.parseInt(req.getParameter("pageSize"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<MVVO> list = this.service.selectMV(currPageNo, pageSize, mvArea, mvType);
		req.setAttribute("list", list);
		// System.out.println("list size:" + list.size());
		req.getRequestDispatcher("html/AudioList.jsp").forward(req, resp);
	}

}
