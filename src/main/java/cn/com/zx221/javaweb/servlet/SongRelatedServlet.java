package cn.com.zx221.javaweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.zx221.javaweb.service.ISongService;
import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.vo.SlsongListVO;
import cn.com.zx221.javaweb.vo.SongListVO;

/**
 * Servlet implementation class SongRelatedServlet
 */
public class SongRelatedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 接收songlistId
		 */
		String songListId = request.getParameter("songListId");
		int songList_id = -1;
		try {
			songList_id = Integer.parseInt(songListId);
			System.out.println(songListId);
		} catch (Exception e) {
		}
		// 调用后面的service,获得页面要显示的playlist
		ISongService songService = ServiceFactory.getFactoryInstance().createSongService();
		List<SlsongListVO> slsonglistvo = songService.searchSlsongList(songList_id);
		// 将list设置到request中
		request.setAttribute("slsonglistvo", slsonglistvo);

		/**
		 * 接收歌单列表id取对应id的歌单项信息
		 */
		SongListVO songlistvo = songService.searchSongList(songList_id);
		request.setAttribute("songlistvo", songlistvo);
		// 转向playList_middle.jsp显示
		request.getRequestDispatcher("/WEB-INF/jsp/playList_middle.jsp").forward(request, response);

	}

}
