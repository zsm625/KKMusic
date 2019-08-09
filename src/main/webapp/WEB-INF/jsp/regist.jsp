<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" href="../../css/regist/regist.css" />
<script type="text/javascript" src="../../js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$(".sendsms").click(function() {
				   //if (checkPhoneInput()){
					  var _phone = $(".phonenumber").val();
					  var _sms = $(".sms").val;
					  var _data = "phonenumber=" + _phone +"&sms="+_sms;
					  //console.log(1);
					  $.ajax({
						  type : 'post',
						  data : _data,
						  url : '../../phoneCodeServlet',
						  success : function(msg) {
							 alert('短信已经发送到您的手机，注意接收');
						  }
					  });
				    //}  
				});

				$(".nickname")[0].onblur = function() {
					if ($(".nickname").val() == null
							|| $(".nickname").val() == "") {
						$(".nickname_error").css("display", "block");
						$(".nickname").css("border-color", "#ff5b5b")
					} else {
						$(".nickname_error").css("display", "none");
					}
				}
				$(".password")[0].onblur = function() {
					if ($(".password").val() == null
							|| $(".password").val() == "") {
						$(".password_error").css("display", "block");
						$(".password").css("border-color", "#ff5b5b")
					} else {
						$(".password_error").css("display", "none");
						var password = $(".password").val;
						var reg = /(?!.*\s)(?!^[\u4e00-\u9fa5]+$)(?!^[0-9]+$)(?!^[A-z]+$)(?!^[^A-z0-9]+$)^.{8,16}$/;
						alert(reg.test(password));
						if (!reg.test(password)) {
							$(".notice").css("display","block");
						}else{
							$(".notice").css("display","none");
						}
				      }
					}
				$(".phonenumber")[0].onfocus = function() {
					$(".for_sms").css("display", "block");
				}
				$(".phonenumber")[0].onblur = function() {
					if ($(".phonenumber").val() == null
							|| $(".phonenumber").val() == "") {
						$(".phonenumber_error").css("display", "block");
						$(".phonenumber").css("border-color", "#ff5b5b")
					} else {
						$(".phonenumber_error").css("display", "none");
						/* var phone = $(".phonenumber").val;
						var reg = /^1[3456789]\d{9}$/;
						if (!reg.test(phone)) {
							alert("手机号码格式不正确！");
							return false;
						}else{
							$(".notice").css("display","none");
							return true;
						} */
					}
				}
				$(".sms")[0].onblur = function() {
					if ($(".sms").val() == null || $(".sms").val() == "") {
						$(".sms_error").css("display", "block");
						$(".sms").css("border-color", "#ff5b5b")
					} else {
						$(".sms_error").css("display", "none");
						$(".for_sms").css("display", "none");
					}
				}
				function checkInput() {
					//判断用户名
					if ($(".nickname").val() == null
							|| $(".nickname").val() == "") {
						$(".nickname_error").css("display", "block");
						$(".nickname").focus();
						return false;
					} else {
						$(".nickname_error").css("display", "none");
					}
					//判断密码
					if ($(".password").val() == null
							|| $(".password").val() == "") {
						$(".password_error").css("display", "block")
						$(".password").focus();
						return false;
					}
				}
				function checkPhoneInput(){
					if ($(".phonenumber").val() == null
							|| $(".phonenumber").val() == "") {
						$(".password_error").css("display", "block")
						$(".phonenumber").focus();
						return false;
					}
				}
			});
</script>
<c:if test="${codeFlag==false}">
<script type="text/javascript">
		alert("验证码错误！");
	</script>
</c:if>
<c:if test="${registFlag==false}">
<script type="text/javascript">
		alert("该号码已经注册！请直接登陆");
	</script>
</c:if>
</head>
<body>
	<div class="side">
		<img src="../../images/regist/01-1.jpg" class="img01" /> <img
			src="../../images/regist/01-3.jpg" class="img02" /> <img
			src="../../images/regist/01-4.jpg" class="img03" />
	</div>
	<div class="main">
		<div class="form">
			<div class="welcome">欢迎注册KK音乐</div>
			<div class="header">享受音乐的世界。</div>
			<!-- 昵称../../registServlet -->
			<form name="login_message" class="login_message" action="../../registServlet" method="post">
				<div class="input-area">
					<input type="text" placeholder="&nbsp; &nbsp;昵称" name="nickname"
						id="nickname" class="nickname" />
					<div class="nickname_error">昵称不可以为空！</div>
				</div>
				<div class="input-area">
					<input type="password" placeholder="&nbsp; &nbsp;密码"
						name="password" id="password" class="password" />
					<div class="password_error">密码不可以为空！</div>
					<div class="notice" style="display:none">密码长度为8-16个字符，必须包括字母、数字、符号至少两种，不能包含空格</div>
				</div>
				<div class="input-area">
					<input type="text" placeholder="&nbsp; &nbsp;手机号码"
						name="phonenumber" id="phonenumber" class="phonenumber" />
					<div class="phonenumber_error"
						style="padding: 0 0 0 24px; color: #ff5b5b; font-size: 14px; height: 18px; position: absolute; display: none;">手机号码不可以为空！</div>
				</div>
				<div class="input-area for_sms" style="display: none">
					<input type="text" placeholder="&nbsp; &nbsp;短信验证码" name="sms" id="sms" class="sms" /> 
						<input type="button" value="发送短信验证码" id="sendsms" class="sendsms" />
					<div class="sms_error"
						style="padding: 0 0 0 24px; color: #ff5b5b; font-size: 14px; height: 18px; position: absolute; display: none;">验证码不可以为空！</div>
				</div>
				<div class="input-area">
					<input type="submit" value="立即注册" id="regist" class="regist" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>
