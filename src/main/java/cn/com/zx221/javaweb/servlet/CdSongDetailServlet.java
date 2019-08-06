package cn.com.zx221.javaweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.zx221.javaweb.service.ICdService;
import cn.com.zx221.javaweb.service.ISongService;
import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.vo.CdVo;
import cn.com.zx221.javaweb.vo.SongVo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class CdSongDetailServlet
 */
public class CdSongDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 通过从cdSongDetial.jsp页面传来的专辑id从数据库中找到相应的歌曲信息
		 */
		String cdStr = request.getParameter("cd");
		Integer cd = Integer.valueOf(cdStr);
		ICdService cdService = ServiceFactory.getFactoryInstance().createCdService();
		ISongService songService = ServiceFactory.getFactoryInstance().createSongService();
		CdVo cdVo = cdService.findCdById(cd);
		List<SongVo> songList = songService.findSongInfByCdId(cdVo.getCd_id());
		String cd_synopsis = cdVo.getCd_synopsis();
		String[] split = cd_synopsis.split(",");
		System.out.println(cd_synopsis);
		request.setAttribute("cd_synopsis", split);
		request.setAttribute("cdVo", cdVo);
		request.setAttribute("songList", songList);
		request.getRequestDispatcher("/WEB-INF/jsp/cdSongDetail.jsp").forward(request, response);
		
		/*
		 * JSONObject json = JSONObject.fromObject(cd_synopsis); JSONArray array =
		 * JSONArray.fromObject(split); System.out.println(json);
		 * System.out.println(array);
		 */
		
	}

}
