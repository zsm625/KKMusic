<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
function toOpenDetailWindow(id){
	   var url = "../../singerDetailServlet?id=" + id + "&" + Math.random();
	   window.open(url);
}
</script>
<div class="mod_singer_list">
	<ul class="singer_list__list js_avtar_list">
		<c:forEach items="${singerList}" var="singer" begin="0" end="4">
			<li class="singer_list__item">
				<div class="singer_list__item_box">
					<a onclick="toOpenDetailWindow(${singer.singer_id})"<%-- href="../../singerDetailServlet?id= + ${singer.singer_id}" --%> class="singer_list__cover js_singer" hidefocus="true"
						data-stat="y_new.singerlist.singerpic"
						data-singermid="001fNHEf1SFEFN" data-singerid="13948"
						title="${singer.singer_name}"> <img class="singer_list__pic"
						onerror="${singer.singer_photoUrl}"
						src="../../${singer.singer_photoUrl}" alt="${singer.singer_name}">
					</a>
					<h3 class="singer_list__title">
						<a href="../../singerDetailServlet?id= + ${singer.singer_id}" data-singermid="001fNHEf1SFEFN" data-id="13948"
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
