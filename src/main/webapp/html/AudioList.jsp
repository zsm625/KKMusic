<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!--<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/layout_0412.css">
		<link rel="stylesheet" type="text/css" href="../css/mv.css">
		<link rel="stylesheet" type="text/css" href="../css/popup_login.css">
		<link rel="stylesheet" type="text/css" href="../css/qb-ie-remind.css">
	</head>

	<body>-->
		<!--<ul class="mv_list__list" id="mv_list">-->
		<c:forEach items="${list}" var="mvvo">
			<li class="mv_list__item" data-vid="f0031sbt4q6">
				<div class="mv_list__item_box" style="visibility: visible;">
					<a href="https://y.qq.com/n/yqq/mv/v/f0031sbt4q6.html#stat=y_new.mv_lib.mv_play" onclick="setStatCookie&amp;&amp;setStatCookie();" class="mv_list__cover mod_cover js_mv" data-stat="y_new.mv_lib.mv_play" data-vid="f0031sbt4q6" title="${mvvo.mvName}" hidefocus="true">
						<img class="mv_list__pic" src="" data-original="//y.gtimg.cn/music/photo_new/T015R640x360M0000011gyt536UZsn.jpg?max_age=2592000" onerror="this.src=&#39;//y.gtimg.cn/mediastyle/global/img/mv_300.png?max_age=31536000&#39;;this.onerror=null;" alt="${mvvo.mvName}" style="display: block; visibility: visible;">
						<i class="mod_cover__icon_play"></i>
					</a>
					<h3 class="mv_list__title"><a href="https://y.qq.com/n/yqq/mv/v/f0031sbt4q6.html#stat=y_new.mv_lib.mv_name" onclick="setStatCookie&amp;&amp;setStatCookie();" class="js_mv" data-stat="y_new.mv_lib.mv_name" data-vid="f0031sbt4q6" title="${mvvo.mvName}">${mvvo.mvName}</a></h3>

					<div class="mv_list__singer" title="${mvvo.mvSingerName}">

						<a href="https://y.qq.com/n/yqq/singer/003WDnkR0qexCp.html#stat=y_new.mv_lib.mv_singername" onclick="setStatCookie&amp;&amp;setStatCookie();" class="js_singer" data-stat="y_new.mv_lib.mv_singername" data-singermid="003WDnkR0qexCp" title="${mvvo.mvSingerName}"> ${mvvo.mvSingerName} </a>

					</div>
					<div class="mv_list__info"><span class="mv_list__listen"><i class="mv_list__listen_icon sprite"></i>${mvvo.mvPlayCount}</span>&nbsp;${mvvo.mvIssue}</div>

				</div>
			</li>
		</c:forEach>
		<!--<!--</ul>-->
	<!--</body>

</html>-->