<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>KK音乐登陆</title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

body {
	text-align: center;
}

#loginWindows {
	position: relative;
	top: 100px;
	width: 550px;
	height: 400px;
	border: 1px solid #000000;
	margin: 0 auto;
}

#title {
	width: 550px;
	height: 80px;
	border-bottom: 1px solid #737373;
	/* background-color:#9ACD32; */
	line-height: 80px;
	margin-bottom: 30px;
}

p {
	font-size: 25px;
	color: black;
}

#account, #password {
	width: 300px;
	height: 35px;
	margin: 20px 50px 0px 0px;
}

#login {
	width: 300px;
	height: 45px;
	color: white;
	background-color: #9ACD32;
	margin: 20px 50px 0px 0px;
	border: none;
}

a {
	position: relative;
	left: 200px;
	top: 50px;
	color: #000000;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>
<c:if test="${loginflag==false}">
	<script type="text/javascript">
		alert("用户名或密码错误！");
	</script>
</c:if>

</head>
<body>
	<div id="loginWindows">
		<div id="title">
			<p>登陆KK音乐</p>
		</div>
		<form action="http://localhost:81/loginServlet" method="post">
			<div>
				<input type="text" id="account" name="account"
					placeholder="请输入手机号或昵称" />
			</div>
			<div>
				<input type="password" id="password" name="password"
					placeholder="密码" />
			</div>
			<input type="submit" value="登陆" id="login" />
		</form>
		<div class="regist">
			<a href="http://localhost:81/registUIServlet">注册新账号</a>
		</div>
	</div>
</body>
</html>