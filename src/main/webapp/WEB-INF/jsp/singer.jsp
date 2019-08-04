<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mod_singer_list">
	<ul class="singer_list__list js_avtar_list">
		<c:forEach items="${singerList}" var="singer" begin="0" end="4">
			<li class="singer_list__item">
				<div class="singer_list__item_box">
					<a href="#" class="singer_list__cover js_singer" hidefocus="true"
						data-stat="y_new.singerlist.singerpic"
						data-singermid="001fNHEf1SFEFN" data-singerid="13948"
						title="${singer.singer_name}"> <img class="singer_list__pic"
						onerror="${singer.singer_photoUrl}"
						src="../../${singer.singer_photoUrl}" alt="${singer.singer_name}">
					</a>
					<h3 class="singer_list__title">
						<a href="#" data-singermid="001fNHEf1SFEFN" data-id="13948"
							class="js_singer" data-stat="y_new.singerlist.singername"
							title="${singer.singer_name}">${singer.singer_name}</a>
					</h3>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>
<ul class="singer_list_txt">
	<c:forEach items="${singerList}" var="singer" begin="5">
		<li class="singer_list_txt__item"><a href="#"
			onclick="setStatCookie&amp;&amp;setStatCookie();"
			class="singer_list_txt__link js_singer"
			data-stat="y_new.singerlist.singername"
			data-singermid="000LsFo136kIv4" data-singerid="39657"
			title="${singer.singer_name}">${singer.singer_name}</a></li>
	</c:forEach>
</ul>
<div class="mod_page_nav js_pager">
	<strong class="current">1</strong><a href="javascript:;"
		class="js_pageindex" data-index="2" hidefocus="">2</a><a
		href="javascript:;" class="js_pageindex" data-index="3" hidefocus="">3</a><a
		href="javascript:;" class="js_pageindex" data-index="4" hidefocus="">4</a><strong
		class="more">...</strong><a href="javascript:;" class="js_pageindex"
		data-index="299" hidefocus="">299</a><a href="javascript:;"
		class="next js_pageindex" data-index="2" title="下一页" hidefocus=""><span>&gt;</span></a>
</div>
