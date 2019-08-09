package cn.com.zx221.javaweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.zx221.javaweb.service.IMVService;
import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.vo.MVVO;

@WebServlet("/selectMVServlet")
public class SelectMVServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

//	private IMVService service = new MVServiceImpl();
	IMVService service = ServiceFactory.getFactoryInstance().createMVService();

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String path = req.getSession().getServletContext().getRealPath("/");
		// System.out.println(path);

		String mvArea = req.getParameter("mvArea");
		String mvType = req.getParameter("mvType");

		String isNew = req.getParameter("isNew");

		int currPageNo = 1;// 当前页码
		int pageSize = 5;// 每页条数

		try {
			currPageNo = Integer.parseInt(req.getParameter("currPageNo"));
			pageSize = Integer.parseInt(req.getParameter("pageSize"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获得mv集合
		List<MVVO> list = this.service.selectMV(currPageNo, pageSize, mvArea, mvType, isNew);
		req.setAttribute("list", list);
		// 获得页数
		int maxPage = 7;

		// 第几页(及当前页)
		req.setAttribute("currPageNo", currPageNo);
		// 共几页(及最大页)
		req.setAttribute("maxPage", maxPage);
		System.out.println("list size:" + list.size());
		req.getRequestDispatcher("WEB-INF/jsp/AudioList.jsp").forward(req, resp);
	}

}
