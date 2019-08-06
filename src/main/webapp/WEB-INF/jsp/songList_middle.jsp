<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
  // function toOpenDetailWindow(_id){
	  // var url = "../snacksDetailServlet?id=" + _id + "&" + Math.random();
	  // window.open(url,'_blank');
  // }
</script>
<c:forEach items="${songlist }" var="song">
   <li class="playlist__item" data-disstid="7086008336" onmouseover="this.className=(this.className+&#39; playlist__item--hover&#39;)"
 onmouseout="this.className=this.className.replace(/ playlist__item--hover/, &#39;&#39;)">
	<div class="playlist__item_box">
		<div class="playlist__cover mod_cover" style="visibility: visible;"><a href="#" onclick="setStatCookie&amp;&amp;setStatCookie();"
			 class="js_playlist" title="${song.songlistName }" data-disstid="7086008336" data-stat="y_new.playlist.pic_click"><img
				 src="../${song.songlistPicUrl }" data-original="#" onerror="this.src=&#39;//y.gtimg.cn/mediastyle/global/img/cover_playlist.png?max_age=31536000&#39;;this.onerror=null;"
				 alt="恬静英文｜慵懒的午后 温柔似海风" class="playlist__pic" style="display: block; visibility: visible;"><i class="mod_cover__icon_play js_play"
				 data-stat="y_new.playlist.pic_play"></i></a></div>
		<h4 class="playlist__title"><span class="playlist__title_txt"><a href="#" onclick="setStatCookie&amp;&amp;setStatCookie();"
				 class="js_playlist" data-stat="y_new.playlist.dissname" data-disstid="7086008336" title="${song.songlistName }">${song.songlistName }
				</a></span></h4>
		<div class="playlist__author">

			<a href="#" onclick="setStatCookie&amp;&amp;setStatCookie();" class="js_user" data-uin="ow4lNK6Poeczov**" data-stat="y_new.playlist.creater"
			 title="song.songlistName">${song.userPO.userLoginId }</a>

		</div>
		<div class="playlist__other">
			播放量： ${song.songlistAccessCount}
		</div>
		<a href="javascript:;" class="btn_operate_menu js_playlist_more" data-type="3" data-id="7086008336" data-stat="y_new.playlist.pic_mod_more"><span
			 class="icon_txt">更多</span></a>
	</div>
</li>
</c:forEach>