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
		String keyword = request.getParameter("keyword");
		String singer_initial = "热门";
		String singer_area = "全部";
		String singer_sex = "全部";
		String singer_type = "全部";
		if (keyword != null || !(keyword.trim().equals(""))) {
			byte[] bytes = keyword.getBytes("ISO-8859-1");
			keyword = new String(bytes, "UTF-8");
			if (!keyword.equals("热门,全部,全部,全部")) {
				String[] keywords = keyword.split(",");
				if (keywords.length != 0) {
					singer_initial = keywords[0].trim().equals("") ? "热门" : keywords[0];
					singer_area = keywords[1].trim().equals("") ? "全部" : keywords[1];
					singer_sex = keywords[2].trim().equals("") ? "全部" : keywords[2];
					singer_type = keywords[3].trim().equals("") ? "全部" : keywords[3];
				}
			}
		}
		/*System.out.println(singer_initial + singer_area + singer_sex + singer_type);*/

		List<SingerVo> singerList = singerService.findSinger(1, singer_initial, singer_area, singer_sex, singer_type);
		request.setAttribute("singerList", singerList);

		request.getRequestDispatcher("/WEB-INF/jsp/singer.jsp").forward(request, response);
	}

}
