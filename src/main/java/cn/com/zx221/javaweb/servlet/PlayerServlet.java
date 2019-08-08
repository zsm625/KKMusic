package cn.com.zx221.javaweb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.zx221.javaweb.service.ISongListService;
import cn.com.zx221.javaweb.service.ISongService;
import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.vo.SongVo;

/**
 * Servlet implementation class PlayerServlet
 */
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response) 播放器返回上来的数据
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从不同页面得到歌单号和歌曲编号
		
		String songListIdStr = request.getParameter("songListId");
		if (songListIdStr != null && !(songListIdStr.trim().equals(""))) {
			ISongListService songlistService = ServiceFactory.getFactoryInstance().creatSongListService();
			try {
				Integer songListId = Integer.valueOf(songListIdStr);
				List<SongVo> songVos = songlistService.findSongVoBySongListId(songListId);
				if (songVos != null) {
					request.setAttribute("songVos", songVos);
					request.getRequestDispatcher("/WEB-INF/jsp/playerControl.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		String idStr = request.getParameter("songId");
		if (idStr != null && !(idStr.trim().equals(""))) {
			try {
				Integer songId = Integer.valueOf(idStr);
				ISongService songService = ServiceFactory.getFactoryInstance().createSongService();
				SongVo songVo = songService.findSongById(songId);
				List<SongVo> songVos=new ArrayList<SongVo>();
				if (songVo != null) {
					songVos.add(songVo);
					request.setAttribute("songVos", songVos);
					request.getRequestDispatcher("/WEB-INF/jsp/playerControl.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
