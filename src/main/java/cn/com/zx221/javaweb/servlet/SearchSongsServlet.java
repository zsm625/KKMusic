package cn.com.zx221.javaweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.zx221.javaweb.service.ISongService;
import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.vo.SongListVO;

/**
 * Servlet implementation class SearchSongsServlet
 */

public class SearchSongsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 接收标签名称
		 */
		String songTypeName = request.getParameter("songTypeName");
		System.out.println(songTypeName);
		// 调用后面的service,获得页面要显示的songlist
		ISongService songService = ServiceFactory.getFactoryInstance().createSongService();
		List<SongListVO> songlist = songService.seacheSongList(songTypeName);
		// 将list设置到request中
		request.setAttribute("songlist", songlist);
		// 转向songList_middle.jsp显示li
		request.getRequestDispatcher("/WEB-INF/jsp/songList_middle.jsp").forward(request, response);

	}

}
