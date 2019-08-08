<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:forEach items="${songVos }" var="song" varStatus="i">
<li mid="104236476" ix="0" data-page="player"
	data-stat="y_new.player.songlist.dbclick">
	<div class="songlist__item">
		<div class="songlist__edit sprite">
			<input type="checkbox" class="songlist__checkbox">
		</div>
		<div class="songlist__number">${i.index+1 }</div>
		<div class="songlist__songname">
			<span class="songlist__songname_txt" title="${song.songName }">${song.songName }</span>
			<div class="mod_list_menu">
				<a href="javascript:;"
					class="list_menu__item list_menu__play js_play"
					data-stat="y_new.player.songlist.playone" data-page="player"
					title="播放"><i class="list_menu__icon_play"></i><span
					class="icon_txt">播放</span></a> <a href="javascript:;"
					class="list_menu__item list_menu__add js_fav"
					data-stat="y_new.player.songlist.addone" title="添加到歌单"
					aria-haspopup="true"> <i class="list_menu__icon_add"></i> <span
					class="icon_txt">添加到歌单</span>
				</a> <a href="javascript:;"
					class="list_menu__item list_menu__down js_down" title="VIP下载"
					aria-haspopup="true" data-target="menu_down" style="display: none;">
					<i class="list_menu__icon_down_vip"></i> <span class="icon_txt">VIP下载</span>
				</a> <a href="javascript:;"
					class="list_menu__item list_menu__share js_share"
					data-stat="y_new.player.songlist.shareone" title="分享"
					aria-haspopup="true"> <i class="list_menu__icon_share"></i> <span
					class="icon_txt">分享</span>
				</a>
			</div>
		</div>

		<div class="songlist__artist" title="${song.singerName }">


			<a href="https://y.qq.com/n/yqq/singer/003LCFXH0eodXv.html"
				data-singermid="003LCFXH0eodXv" data-singerid="137" title="${song.singerName }"
				data-stat="y_new.player.songlist.singername" class="singer_name"
				data-page="player">${song.singerName }</a>

		</div>
		<div class="songlist__time">${song.songTime }</div>
		<div class="songlist__other"></div>
		<a href="javascript:;" class="songlist__delete js_delete"
			data-page="player" data-stat="y_new.player.songlist.delete"
			title="删除"><span class="icon_txt">删除</span></a> <i
			class="player_songlist__line"></i>
	</div>
</li>
</c:forEach>
