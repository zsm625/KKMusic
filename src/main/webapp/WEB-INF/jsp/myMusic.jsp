<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
    <meta http-equiv="Content-Language" content="zh-cn" />
    <meta name="keywords" content="音乐,QQ音乐,在线听歌,音乐下载,音乐播放器,音乐网站,MV,巅峰榜,音乐排行榜,翻译歌曲,热门歌曲,经典老歌,无损音乐,无损曲库"/>
    <meta name="description" content="QQ音乐是腾讯公司推出的一款网络音乐服务产品，海量音乐在线试听、新歌热歌在线首发、歌词翻译、手机铃声下载、高品质无损音乐试听、海量无损曲库、正版音乐下载、空间背景音乐设置、MV观看等，是互联网音乐播放和下载的优选。" />
    <meta name="mobile-agent" content="format==[html5];url=https://y.qq.com/m/index.html">
    <meta name="applicable-device" content="pc">
    <title>我的音乐 - KK音乐-享受音乐的世界！</title>
    <link rel="canonical" href="//y.qq.com/portal/profile.html" />
<script type="text/javascript">
    var _speedMark = new Date();
</script>

    <link rel="stylesheet" href="../../css/myMusic/layout_0412.css" />
    <link rel="stylesheet" href="../../css/myMusic/profile_61ea2fe1.css" />
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
<c:if test="${userVO!=null}">
<script type="text/javascript">
$(document).ready(function(){
	alert("sssss");	
  $(".headimg").css("display","block");
  $(".logintxt").css("display","none");
  $(".js_user_data").css("display","block");
});
</script>
</c:if>
</head>
<body>

       <!-- 头部 S -->

<script>
if(window.ActiveXObject || window.msIsStaticHTML){
	var ie = 6;

	if(!!window.XMLHttpRequest) {ie = 7}; 
	if(navigator.userAgent.indexOf("MSIE 7.0")!=-1) {ie = 7}; 
	if(navigator.userAgent.indexOf("Trident/4.0")!=-1){ie = 8}; 
	if(navigator.userAgent.indexOf("Trident/5.0") != -1){ie = 9};
	if(navigator.userAgent.indexOf("Trident/6.0") != -1){ie = 10};
	if(navigator.userAgent.indexOf("Trident/7.0") != -1 || "undefined" == typeof attachEvent){ie = 11};
	if (ie < 8) {
		document.write("<div class=\"popup_top\"  id=\"zoom_warn\">使用更高版本的 <a href=\"http://www.google.cn/intl/zh-CN/chrome/browser/desktop/\" target=\"_blank\">Chrome</a> 或 <a href=\"https://support.microsoft.com/zh-cn/help/17621/internet-explorer-downloads\" target=\"_blank\">Internet Explorer</a>，体验更精彩</div>");
	}
}</script>
<div class="mod_header">
    <div class="section_inner">
        <h1 class="qqmusic_title"><a href="//y.qq.com"><img srcset="//y.gtimg.cn/mediastyle/yqq/img/logo@2x.png?nowebp=1 2x" src="../../images/logo.png" alt="KK音乐" class="qqmusic_logo"/></a></h1>
        <!-- 导航 S -->
        <!-- 
            当前态 & hover 用 top_nav__link--current
            参考Im.qq.com的交互 
        -->
        <ul class="mod_top_nav" role="nav">
            <li class="top_nav__item">
                <a href="//y.qq.com" class="top_nav__link" title="音乐馆">音乐馆</a>
            </li>
            <li class="top_nav__item">
                <a href="/portal/profile.html" class="top_nav__link" title="我的音乐">我的音乐</a>
            </li>

        </ul>
	    <ul class="mod_top_subnav" style="display:none;">
		<li class="top_subnav__item">
		    <a href="//y.qq.com" class="top_subnav__link">首页</a>
		</li>
		<li class="top_subnav__item">
		    <a href="/portal/singer_list.html" class="top_subnav__link">歌手</a>
		</li>
		<li class="top_subnav__item">
		    <a href="/n/yqq/toplist/4.html" class="top_subnav__link">排行榜</a>
		</li>
		<li class="top_subnav__item">
		    <a href="/portal/playlist.html" class="top_subnav__link">分类歌单</a>
		</li>
		<li class="top_subnav__item">
		    <a href="/portal/mv_lib.html#t6=2" class="top_subnav__link">MV</a>
		</li>
	    </ul>
        <!-- 导航 E -->
                <div class="mod_top_search" role="search">
                    <div class="mod_search_input">
                        <input class="search_input__input" type="text" aria-label="请输入搜索内容" placeholder="" accesskey="s"/>
                        <button class="search_input__btn"><i class="icon_search sprite"></i><span class="icon_txt">搜索</span></button>
                    </div>
                </div>
        <div class="header__opt">

                <!-- 未登录 -->
                <span class="mod_top_login">
		    <a class="top_login__link js_logined headimg" href="#" onclick="setStatCookie&&setStatCookie();" style="display:none;">
                        <!-- 用户头像 -->
                        <img src="../../${user.userHeadsculpictureUrl}" class="top_login__cover" alt="" />
                    </a>
                    <a class="top_login__link js_login logintxt" data-stat="y_new.top.login" href="javascript:;">
                        登录
                    </a>

                    <a class="login__link header__link js_login" data-stat="y_new.top.login" href="javascript:;">登录</a>
                   <!--  <a class="mod_btn_green top_login__btn_vip js_openvip" data-aid="music.pc.20316.newyqqtop" data-stat="music.20316.btnclick.pc" href="javascript:;">开通绿钻豪华版</a>
		    <a class="mod_btn top_login__btn_vip js_openmusic" data-aid="music.pc.20317.newyqqtop" data-stat="music.20317.btnclick.pc" href="javascript:;">开通付费包</a> -->
                </span>

		<!-- 用户信息 -->
		    <div class="popup_user" style="">
		    
		    </div>
            </div>
        </div>
    </div>
    <!-- 头部 E -->

	<div id="captcha" style="display:none;"></div>
	<div class="mod_loading" id="before_page"><i class="icon_txt">加载中</i></div>
    <div class="js_mod_profile_unlogin" style="display:none;">
    </div>
    <!-- 用户信息 -->
    <div class="mod_profile js_user_data" style="display:none;">
	<div class="section_inner">
		<div class="profile__cover_link">
			<img src="//thirdqq.qlogo.cn/g?b=sdk&amp;k=3Ys57Gt5AMawDwrdG9Sp9w&amp;s=140&amp;t=1514215151" onerror="this.src='//y.gtimg.cn/mediastyle/global/img/person_300.png?max_age=31536000';this.onerror=null;" alt="寻御" class="profile__cover" id="profileHead">
		</div>
            <h1 class="profile__tit">
                <span class="profile__name">${user.userLoginId }</span><a href="https://y.qq.com/portal/vipportal/index.html" rel="noopener nofollow" target="_blank"><img src="//y.gtimg.cn/music/icon/v1/mac/svip_g@2x.png?max_age=2592000" class="lv_icon"></a>
            </h1>
            <ul class="mod_user_statistic">
                <li class="user_statistic__item">
                    <a href="javascript:;" class="js_tab" data-tab="focus_singer" data-stat="y_new.profile.header.focus_click"><strong class="user_statistic__number js_num_follow">3</strong><span class="user_statistic__tit">关注</span></a>
                </li>
                <li class="user_statistic__item user_statistic__item--last">
                    <a href="javascript:;" class="js_tab" data-tab="fans" data-stat="y_new.profile.header.fans_click"><strong class="user_statistic__number js_num_fans">0</strong><span class="user_statistic__tit">粉丝</span></a>
                </li>
            </ul>
		    <button class="btn_lock sprite js_btn_lock" title="主页已公开" data-status="0"><span class="icon_txt">主页已公开</span></button>
        </div>
        </div>

    <div class="main" style="display:none;">
        <div class="mod_tab profile_nav" role="nav" id="nav">
            <a class="mod_tab__item mod_tab__current" href="javascript:;" id="like_tab" data-tab="like" data-stat="y_new.profile.tab.like">我喜欢</a>
            <a class="mod_tab__item" href="javascript:;" id="buy_tab" data-tab="buy" data-stat="y_new.profile.tab.digital_album">我的已购</a>
            <a class="mod_tab__item" href="javascript:;" id="create_tab" data-tab="create" data-stat="y_new.profile.tab.create_playlist">我创建的歌单</a>
            <a class="mod_tab__item" href="javascript:;" id="focus_tab" data-tab="focus" data-stat="y_new.profile.tab.focus">关注</a>
            <a class="mod_tab__item" href="javascript:;" id="fans_tab" data-tab="fans" data-stat="y_new.profile.tab.fans">粉丝</a>
            <a class="mod_tab__item" href="javascript:;" id="uploadmv_tab" data-tab="uploadmv" data-stat="y_new.profile.tab.uploadmv">我上传的视频</a>
			<a class="mod_tab__item" href="javascript:;" id="radio_tab" data-tab="radio" data-stat="y_new.profile.tab.radio" style="display:none;">主播电台</a>
        </div>

		<div class="js_box" id="like_box">
			<div class="mod_tab" role="nav">
				<a class="mod_tab__item mod_tab__current" href="javascript:;" data-tab="like_song" data-stat="y_new.profile.like.tab.song">歌曲</a>
				<a class="mod_tab__item" href="javascript:;" data-tab="like_playlist" data-stat="y_new.profile.like.tab.playlist">歌单</a>
				<a class="mod_tab__item" href="javascript:;" data-tab="like_album" data-stat="y_new.profile.like.tab.album">专辑</a>
				<a class="mod_tab__item" href="javascript:;" data-tab="like_mv" data-stat="y_new.profile.like.tab.mv">视频</a>
			</div>
			<div class="profile_cont">
				<div class="js_sub" id="like_song_box"></div>
				<div class="js_sub" style="display:none;" id="like_playlist_box"></div>
				<div class="js_sub" style="display:none;" id="like_album_box"></div>
				<div class="js_sub" style="display:none;" id="like_mv_box"></div>
			</div>
		</div>
		<!-- 歌单 -->
		<div class="js_box profile_cont" id="buy_box" style="display:none;">
			<div class="mod_tab" role="nav">
				<a class="mod_tab__item" href="javascript:;" data-tab="buy_album" data-stat="y_new.profile.album.tab.album">数字专辑</a>
				<a class="mod_tab__item" href="javascript:;" data-tab="buy_song" data-stat="y_new.profile.album.tab.song">单曲</a>
				<a class="mod_tab__item" href="javascript:;" data-tab="buy_peri" data-stat="y_new.profile.album.tab.peri">实体周边</a>
			</div>
			<div class="profile_cont">
				<div class="js_sub" id="buy_album_box"></div>
				<div class="js_sub" style="display:none;" id="buy_song_box"></div>
				<div class="js_sub" style="display:none;" id="buy_peri_box"></div>
			</div>
		</div>
		<!-- 歌单 -->
		<div class="js_box profile_cont" id="create_box" style="display:none;"></div>
		<!-- 关注 -->
		<div class="js_box" id="focus_box" style="display:none;">
			<div class="mod_tab" role="nav">
				<a class="mod_tab__item mod_tab__current" href="javascript:;" data-tab="focus_singer" data-stat="y_new.profile.focus.tab.singer">歌手</a>
				<a class="mod_tab__item" href="javascript:;" data-tab="focus_user" data-stat="y_new.profile.focus.tab.user">用户</a>
			</div>
			<div class="profile_cont">
				<a href="javascript:;" class="mod_btn btn_focus_fan js_focus_friends"><i class="mod_btn__icon_new"></i>关注更多好友</a>
				<div class="js_sub" id="focus_singer_box"></div>
				<div class="js_sub" style="display:none;" id="focus_user_box"></div>
			</div>
		</div>
		<div class="js_box profile_cont" id="fans_box" style="display:none;">
		</div>
		<!-- 上传的MV -->
		<div class="js_box profile_cont" id="uploadmv_box" style="display:none;">
		</div>
		<!-- 音乐头条 -->
		<div class="js_box profile_cont" id="magazine_box" style="display:none;">
		</div>
		<!-- 我的主播电台 -->
		<div class="js_box profile_cont" id="radio_box" style="display:none;">
		</div>
    </div>
    <div id="locked" style="display:none;"></div>
	<div id="cgi_none_box" class="" style="display:none;">
		<div class="none_txt">
			<i class="none_txt__symbol"></i>
	
			<p>系统错误，请<a href="javascript:;" onclick="window.location.reload();">刷新</a>重试！</p>
	
		</div>
		<div class="bg_detail"><i class="bg_detail__pic"></i></div>
	</div>

    <div class="footer" role="footer">
    <div class="section_inner">
        <div class="footer_info">

            <div class="footer_download">
                <h3 class="footer_tit">下载QQ音乐客户端</h3>
                <ul class="footer_download_list">
                    <li class="footer_download_list__item"><a href="//y.qq.com/download/" class="js_footer_down" data-type="pc" data-stat="y_new.footer.download.pc"><i class="icon_qm_pc"><span class="icon_txt">QQ音乐</span></i>PC版</a></li>
                    <li class="footer_download_list__item"><a href="//y.qq.com/download/" class="js_footer_down" data-type="mac" data-stat="y_new.footer.download.mac"><i class="icon_qm_mac"><span class="icon_txt">QQ音乐</span></i>Mac版</a></li>
                    <li class="footer_download_list__item"><a href="//y.qq.com/download/" class="js_footer_down" data-type="andriod" data-stat="y_new.footer.download.andriod"><i class="icon_qm_android"><span class="icon_txt">QQ音乐</span></i>Android版</a></li>
                    <li class="footer_download_list__item"><a href="//y.qq.com/download/" class="js_footer_down" data-type="iphone" data-stat="y_new.footer.download.iphone"><i class="icon_qm_iphone"><span class="icon_txt">QQ音乐</span></i>iPhone版</a></li>
                </ul>
            </div>

            <div class="footer_product">
                <h3 class="footer_tit">特色产品</h3>
                <ul class="footer_product_list">
                    <li class="footer_product_list__item footer_product_list__item--pic"><a href="http://kg.qq.com/?pgv_ref=qqmusic.y.topmenu" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_music.k"><i class="icon_qm_kg"></i>全民K歌</a></li>
                    <li class="footer_product_list__item footer_product_list__item--pic"><a href="http://y.qq.com/vip/voice_intro/index.html" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_music.supersound"><i class="icon_qm_ss"></i>Super Sound</a></li>
                    <li class="footer_product_list__item footer_product_list__item--pic"><a href="http://y.qq.com/y/static/down/qplay.html?pgv_ref=qqmusic.y.topmenu" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_music.qplay"><i class="icon_qm_qp"></i>QPlay</a></li>
                    <li class="footer_product_list__item"><a href="http://y.qq.com/y/static/down/car_introduce.html" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_music.car_play">车载互联</a></li>
                    <li class="footer_product_list__item"><a href="http://y.qq.com/yanchu/?pgv_ref=qqmusic.y.topmenu" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_music.yanchu">QQ演出</a></li>
                </ul>
            </div>
                <div class="footer_group">
                    <h3 class="footer_tit">TME集团官网</h3>
                    <ul class="footer_group_list">
                        <li class="footer_platform_list__item"><a href="https://www.tencentmusic.com/" target="_blank" class="js_other_link" data-stat="y_new.footer.other_music.thetme">腾讯音乐</a></li>
                    </ul>
                </div>

            <div class="footer_link">
                <h3 class="footer_tit">合作链接</h3>
                <!-- 显示全部 footer_link_list--show -->
                <ul class="footer_link_list">
                    <li class="footer_link_list__item"><a href="//y.qq.com/portal/company_detail.html?id=297" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_link">CJ ENM</a></li>
                    <li class="footer_link_list__item"><a href="http://v.qq.com/" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_link">腾讯视频</a></li>
                    <li class="footer_link_list__item"><a href="http://z.qzone.com/" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_link">手机QQ空间</a></li>
                    <li class="footer_link_list__item"><a href="http://im.qq.com/" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_link">最新版QQ</a></li>
                    <li class="footer_link_list__item"><a href="http://e.qq.com/index.shtml" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_link">腾讯社交广告</a></li>
                    <li class="footer_link_list__item"><a href="http://guanjia.qq.com/" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_link">电脑管家</a></li>
                    <li class="footer_link_list__item"><a href="http://browser.qq.com/" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_link">QQ浏览器</a></li>
                    <li class="footer_link_list__item"><a href="http://www.weiyun.com/" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_link">腾讯微云</a></li>
                    <li class="footer_link_list__item"><a href="https://cloud.tencent.com/?fromSource=gwzcw.756433.756433.756433" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_link">腾讯云</a></li>
                    <li class="footer_link_list__item"><a href="http://fm.qq.com/" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_link">企鹅FM</a></li>
                    <li class="footer_link_list__item"><a href="http://www.znds.com/" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_link">智能电视网</a></li>
                    <li class="footer_link_list__item"><a href="http://www.dangbei.com/" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_link">当贝市场</a></li>
                    <!--li class="footer_link_list__item js_last" style="display:none;"><a href="http://fm.qq.com/" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_link">企鹅FM</a></li>
                    <li class="footer_link_list__item"><a href="javascript:;" class="js_footer_more">更多</a></li>
                    <li class="footer_link_list__item footer_link_list__item--more"><a href="https://cloud.tencent.com/?fromSource=gwzcw.756433.756433.756433" rel="noopener" target="_blank" class="js_other_link" data-stat="y_new.footer.other_link">腾讯云</a></li-->
                </ul>
            </div>
            <div class="footer_platform">
                    <h3 class="footer_tit">开放平台</h3>
                    <ul class="footer_platform_list">
                        <li class="footer_platform_list__item"><a href="http://y.tencentmusic.com/" target="_blank" class="js_other_link" data-stat="y_new.footer.other_music.tme">腾讯音乐人</a></li>
                        <li class="footer_platform_list__item"><a href="//y.qq.com/vip/daren_recruit/apply.html" target="_blank" class="js_other_link" data-stat="y_new.footer.other_music.daren_recruit">音乐号认证</a></li>
                        <!--li class="footer_platform_list__item"><a href="//y.qq.com/portal/mv/mv_upload.html" target="_blank" class="js_other_link" data-stat="y_new.footer.other_music.ugc">上传视频</a></li-->
                        <!--li class="footer_platform_list__item"><a href="http://y.qq.com/cp/homepage.html#/home" target="_blank" class="js_other_link" data-stat="y_new.footer.other_music.cp">机构入驻</a></li-->
                        
                    </ul>
                </div>
        </div>
        <div class="footer_copyright">
		
		<p >
			<a href="http://www.tencent.com/" rel="noopener nofollow" target="_blank" title="关于腾讯">关于腾讯</a> | 
			<a href="http://www.tencent.com/index_e.shtml" rel="noopener nofollow" target="_blank" title="About Tencent">About Tencent</a> | 
			<a href="http://www.qq.com/contract.shtml" rel="noopener nofollow" target="_blank" title="服务条款">服务条款</a> | 
			<a href="http://y.qq.com/y/static/tips/service_tips.html" rel="noopener nofollow" target="_blank" title="用户服务协议">用户服务协议</a> | 
			<a href="https://y.qq.com/m/client/intro/privacy.html" rel="noopener nofollow" target="_blank" title="隐私政策">隐私政策</a> | 
			<a href="https://y.qq.com/vip/right_declare/index.html" rel="noopener nofollow" target="_blank" title="权利声明">权利声明</a> | 
			<a href="http://www.tencentmind.com/" rel="noopener nofollow"" target="_blank" title="广告服务">广告服务</a> | 
			<a href="http://hr.tencent.com/" rel="noopener nofollow" target="_blank" title="腾讯招聘">腾讯招聘</a> | 
			<a href="http://service.qq.com/" rel="noopener nofollow" target="_blank" title="客服中心">客服中心</a> | 
			<a href="http://www.qq.com/map/" rel="noopener nofollow" target="_blank" title="网站导航">网站导航</a>
		</p>

            <p>Copyright &copy; 1998 - <script type="text/javascript">document.write(new Date().getFullYear());</script> Tencent. <a target="_blank" href="http://www.tencent.com/en-us/le/copyrightstatement.shtml" rel="noopener nofollow" title="All Rights Reserved.">All Rights Reserved.</a></p>
	<p>腾讯公司 <a  target="_blank" href="http://www.tencent.com/zh-cn/le/copyrightstatement.shtml" rel="noopener nofollow" title="版权所有">版权所有</a> <a  target="_blank" href="http://www.tencent.com/law/mo_law.shtml?/law/copyright.htm" rel="noopener nofollow" title="腾讯网络文化经营许可证">腾讯网络文化经营许可证</a></p>
        </div>
    </div>
</div>
</div>
<script type="text/javascript">require.resourceMap({"res":{"js/v4/OFPLite_selector.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/OFPLite_selector_6a0fbb0.js?max_age=31536000","m":"6a0fbb0"},"js/v4/album.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/album_1c0ce72.js?max_age=31536000","m":"1c0ce72"},"js/v4/album_lib.js":{"deps":["js/common/music.js","js/common/indexDB.js"],"url":"//y.gtimg.cn/music/portal/js/v4/album_lib_0fcc162.js?max_age=31536000","m":"0fcc162"},"js/v4/album_mall.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/album_mall_2fbd4ac.js?max_age=31536000","m":"2fbd4ac"},"js/v4/audio/audio_edit.js":{"deps":["js/common/music.js","js/common/music/lib/position.js","js/v4/audio/audio_util.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/audio/audio_edit_e7e172f.js?max_age=31536000","m":"e7e172f"},"js/v4/audio/audio_util.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/audio/audio_util_3624c96.js?max_age=31536000","m":"3624c96"},"js/v4/audio/radio_detail.js":{"deps":["js/common/music.js","js/v4/audio/audio_util.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/audio/radio_detail_03e1f48.js?max_age=31536000","m":"03e1f48"},"js/v4/audio/radio_edit.js":{"deps":["js/common/music.js","js/v4/audio/audio_util.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/audio/radio_edit_1d3aadd.js?max_age=31536000","m":"1d3aadd"},"js/v4/audio/radio_list.js":{"deps":["js/common/music.js","js/v4/audio/audio_util.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/audio/radio_list_528411c.js?max_age=31536000","m":"528411c"},"js/v4/company.js":{"deps":["js/common/music.js","js/common/music/lib/base.js"],"url":"//y.gtimg.cn/music/portal/js/v4/company_b6a2d74.js?max_age=31536000","m":"b6a2d74"},"js/v4/headline/comment_contribute.js":{"deps":["js/common/music.js","js/v4/headline/util.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/headline/comment_contribute_0b8e40c.js?max_age=31536000","m":"0b8e40c"},"js/v4/headline/detail.js":{"deps":["js/common/music.js","js/v4/headline/util.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/headline/detail_c387888.js?max_age=31536000","m":"c387888"},"js/v4/headline/editor.js":{"deps":["js/common/music.js","js/common/music/lib/position.js","js/v4/public/util.js","js/common/indexDB.js"],"url":"//y.gtimg.cn/music/portal/js/v4/headline/editor_997b0ae.js?max_age=31536000","m":"997b0ae"},"js/v4/headline/font2img.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/headline/font2img_6d1304e.js?max_age=31536000","m":"6d1304e"},"js/v4/headline/manage.js":{"deps":["js/common/music.js","js/v4/headline/util.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/headline/manage_b8bedfe.js?max_age=31536000","m":"b8bedfe"},"js/v4/headline/notes.js":{"deps":["js/common/music.js","js/v4/headline/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/headline/notes_a0c5c3d.js?max_age=31536000","m":"a0c5c3d"},"js/v4/headline/openzan.js":{"deps":["js/common/music.js","js/common/PCASClass.js","js/v4/headline/util.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/headline/openzan_1756711.js?max_age=31536000","m":"1756711"},"js/v4/headline/util.js":{"deps":["js/common/music.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/headline/util_6201e20.js?max_age=31536000","m":"6201e20"},"js/v4/index.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/index_1872779.js?max_age=31536000","m":"1872779"},"js/v4/index_v2.js":{"deps":["js/common/music.js","js/common/indexDB.js"],"url":"//y.gtimg.cn/music/portal/js/v4/index_v2_3a6678a.js?max_age=31536000","m":"3a6678a"},"js/v4/lyric_upload.js":{"deps":["js/common/music.js","js/common/module/coder.js"],"url":"//y.gtimg.cn/music/portal/js/v4/lyric_upload_c0a66b1.js?max_age=31536000","m":"c0a66b1"},"js/v4/mini_video.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/mini_video_89a06be.js?max_age=31536000","m":"89a06be"},"js/v4/msg_center.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/msg_center_9c01406.js?max_age=31536000","m":"9c01406"},"js/v4/mv.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/mv_0579939.js?max_age=31536000","m":"0579939"},"js/v4/mvToplist.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/mvToplist_15929e6.js?max_age=31536000","m":"15929e6"},"js/v4/mv_lib.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/mv_lib_d9cc965.js?max_age=31536000","m":"d9cc965"},"js/v4/mv_upload.js":{"deps":["js/common/music.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/mv_upload_efab868.js?max_age=31536000","m":"efab868"},"js/v4/mymusic.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/mymusic_0faa095.js?max_age=31536000","m":"0faa095"},"js/v4/mymusic_edit.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/mymusic_edit_873d7e5.js?max_age=31536000","m":"873d7e5"},"js/v4/mymusic_friend.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/mymusic_friend_b22f062.js?max_age=31536000","m":"b22f062"},"js/v4/new_ugc/editor/editor.js":{"deps":["js/common/music.js","js/common/music/lib/position.js","js/v4/new_ugc/util.js","js/common/indexDB.js"],"url":"//y.gtimg.cn/music/portal/js/v4/new_ugc/editor/editor_04e37d3.js?max_age=31536000","m":"04e37d3"},"js/v4/new_ugc/editor/font2img.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/new_ugc/editor/font2img_c8c3e21.js?max_age=31536000","m":"c8c3e21"},"js/v4/new_ugc/editor/manage.js":{"deps":["js/common/music.js","js/v4/new_ugc/editor/util.js","js/v4/new_ugc/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/new_ugc/editor/manage_14bb768.js?max_age=31536000","m":"14bb768"},"js/v4/new_ugc/editor/util.js":{"deps":["js/common/music.js","js/common/module/coder.js","js/v4/new_ugc/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/new_ugc/editor/util_c71451d.js?max_age=31536000","m":"c71451d"},"js/v4/new_ugc/jQueryAjax.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/new_ugc/jQueryAjax_a4c6233.js?max_age=31536000","m":"a4c6233"},"js/v4/new_ugc/kandan.js":{"deps":["js/common/music.js","js/v4/new_ugc/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/new_ugc/kandan_710ea8a.js?max_age=31536000","m":"710ea8a"},"js/v4/new_ugc/mini_video_upload.js":{"deps":["js/common/music.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/new_ugc/mini_video_upload_9188f15.js?max_age=31536000","m":"9188f15"},"js/v4/new_ugc/mv.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/new_ugc/mv_d0051aa.js?max_age=31536000","m":"d0051aa"},"js/v4/new_ugc/rgbfilter.js":{"url":"//y.gtimg.cn/music/portal/js/v4/new_ugc/rgbfilter_b2858e3.js?max_age=31536000","m":"b2858e3"},"js/v4/new_ugc/user.js":{"deps":["js/common/music.js","js/common/music/cookie.js","js/common/music/jquery.js","js/common/statastic.js"],"url":"//y.gtimg.cn/music/portal/js/v4/new_ugc/user_e374493.js?max_age=31536000","m":"e374493"},"js/v4/new_ugc/util.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/new_ugc/util_96bc340.js?max_age=31536000","m":"96bc340"},"js/v4/piao_wu.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/piao_wu_92a5a66.js?max_age=31536000","m":"92a5a66"},"js/v4/player.js":{"deps":["js/common/music.js","js/common/music/scroller.js","js/common/module/webplayer.js","js/common/module/lrcHandler.js","js/common/module/qrcHandler.js","js/common/music/storage.js"],"url":"//y.gtimg.cn/music/portal/js/v4/player_65cfcc6.js?max_age=31536000","m":"65cfcc6"},"js/v4/player/radio.js":{"deps":["js/common/music.js","js/common/music/scroller.js","js/common/module/webplayer.js","js/common/module/lrcHandler.js","js/common/music/storage.js"],"url":"//y.gtimg.cn/music/portal/js/v4/player/radio_adba5e1.js?max_age=31536000","m":"adba5e1"},"js/v4/playlist.js":{"deps":["js/common/music.js","js/common/indexDB.js"],"url":"//y.gtimg.cn/music/portal/js/v4/playlist_c258b4f.js?max_age=31536000","m":"c258b4f"},"js/v4/playlist_detail.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/playlist_detail_01ff3d3.js?max_age=31536000","m":"01ff3d3"},"js/v4/profile.js":{"deps":["js/common/music.js","js/common/music/storage.js"],"url":"//y.gtimg.cn/music/portal/js/v4/profile_9e24e96.js?max_age=31536000","m":"9e24e96"},"js/v4/public/index.js":{"deps":["js/common/music.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/public/index_fbec3e3.js?max_age=31536000","m":"fbec3e3"},"js/v4/public/mini_video_upload.js":{"deps":["js/common/music.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/public/mini_video_upload_32c7141.js?max_age=31536000","m":"32c7141"},"js/v4/public/noright.js":{"deps":["js/common/music.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/public/noright_4662895.js?max_age=31536000","m":"4662895"},"js/v4/public/renzheng_other.js":{"deps":["js/common/music.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/public/renzheng_other_aecbdfc.js?max_age=31536000","m":"aecbdfc"},"js/v4/public/renzheng_singer.js":{"deps":["js/common/music.js","js/v4/public/util.js"],"url":"//y.gtimg.cn/music/portal/js/v4/public/renzheng_singer_1550884.js?max_age=31536000","m":"1550884"},"js/v4/public/util.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/public/util_ae4198e.js?max_age=31536000","m":"ae4198e"},"js/v4/radio.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/radio_be00ad4.js?max_age=31536000","m":"be00ad4"},"js/v4/search.js":{"deps":["js/common/music.js","js/common/music/storage.js"],"url":"//y.gtimg.cn/music/portal/js/v4/search_b4a3afc.js?max_age=31536000","m":"b4a3afc"},"js/v4/singer.js":{"deps":["js/common/music.js","js/common/music/lib/base.js"],"url":"//y.gtimg.cn/music/portal/js/v4/singer_909793f.js?max_age=31536000","m":"909793f"},"js/v4/singerlist.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/singerlist_1df62d9.js?max_age=31536000","m":"1df62d9"},"js/v4/song_detail.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/song_detail_229582f.js?max_age=31536000","m":"229582f"},"js/v4/toplist.js":{"deps":["js/common/music.js"],"url":"//y.gtimg.cn/music/portal/js/v4/toplist_ee3cb52.js?max_age=31536000","m":"ee3cb52"}},"pkg":{}});</script>


</body>
</html>
