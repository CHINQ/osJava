<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>osJava</title>
<script src="js/index.js" type="text/javascript" charset="UTF-8"></script>
<link href="css/login.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="tops">
		<div class="logo"></div>
		<div class="logosize">osJava</div>
		<div class="bgct">
			<div class="bgtop">
				<a class="bgtopsize">OPEN AND CODE</a>
			</div>
			<div class="bgtopbl">
				最新消息：
					<Marquee  direction="left" width="600px" scrollamount="10">${MessageList[0].mtitle}</Marquee>
			</div>
			<div class="bgtopkg"></div>
			<div class="bgctbt">
				<div class="bgctlt">
					<div class="bgctlttop">
						<div class="img_div_1"></div>
						<div class="img_div_2"></div>
						<div class="text_div_3">
							<c:if test="${empty MessageList}">
								<jsp:forward page="Index_Servlet"></jsp:forward>
							</c:if>
							<c:forEach items="${MessageList}" var="mes">
								<a href="index.jsp?logmsg=0" class="a_link">${mes.mtitle}</a>
								<br />
							</c:forEach>
						</div>
					</div>
					<div class="bgctltct"></div>
					<div class="bgctltbt">
						<div>
							<h2 style="margin-top: 20px;" class="white">Java资料</h2>
								<c:forEach items="${bookList}" var="bkl">
								${bkl.bname}
								<img alt="" src="../${bkl.bimage}" width="50px"
											height="50px">
								</c:forEach>							
						</div>
					</div>
				</div>
				<div class="bgctltlt"></div>
				<div class="bgcltltlt">
					<div class="bgcltltlttop">
						<c:if test="${param.msg==10 }">
							<script>
								alert("登陆失败")
							</script>
						</c:if>
						<c:if test="${param.msg==11 }">
							<script>
								alert("注册失败")
							</script>
						</c:if>
						<div>
							<div id="Main">
								<a href="#banner" class="dl">登录</a>
							</div>
						</div>
						<div id="Main">
							<a href="#inner" class="zc">注册</a>
						</div>
					</div>
					<div class="bgcltltltct">最受欢迎的讲师</div>
					<div class="bgcltltltbt">
						<br>
						<c:if test="${empty lectorList}">
							<div class="index_teacher">
								讲<br /> 师<br /> 暂<br /> 空<br /> ！
							</div>
						</c:if>
						<c:if test="${!empty lectorList}">
							<c:forEach items="${lectorList}" var="lec">
								<div class="index_teacher">
									<div class="touxiang_div">
										<img alt="" src="../${lec.user.uimage}" width="120px"
											height="100px">
									</div>
									<div class="textintro_div">
										${lec.user.uname}<br />${lec.lcourse} <br />
										${lec.user.utext}
									</div>
								</div>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="bg"></div>
	<div class="login_D">
		<section id="banner">
			<div class="login_DL">
				<div class="login_DC">
					<form action="login" method="post" name="f1">
						<h2 class="h2">登录</h2>
						<h2 class="h2">Log on</h2>
						<table class="logintable">
							<tr>
								<td><input type="text" name="uid" class="TXT"
									placeholder="请输入用户名" onkeyup="value=value.replace(/[\W]/g,'') "
									onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" /></td>
							</tr>
							<tr>
								<td><input type="password" name="upass" class="TXT"
									placeholder="请输入密码" /></td>
							</tr>
							<tr>
								<td><input name="sub" type="submit" value="登录" id="sub"
									class="submit" onClick="return kongK()" /></td>
							</tr>
							<tr>
								<td><br /></td>
								<td></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</section>
		<section id="inner">
			<div class="login_DL">
				<div class="login_DC">
					<form action="zhuce" method="post" name="f2">
						<h2 class="h2">注册</h2>
						<h2 class="h2">Sign in</h2>
						<table class="logintable">
							<tr>
								<td><input name="uid" type="text" class="TXT"
									onkeyup="value=value.replace(/[\W]/g,'') " placeholder="请输入用书名"
									onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" /></td>
							</tr>
							<tr>
								<td><input name="upass" type="password" class="TXT"
									placeholder="请输入密码" /></td>
							</tr>
							<tr>
								<td><input name="upass1" type="password" class="TXT"
									placeholder="确认密码" /></td>
							</tr>
							<tr>
								<td><input name="uname" type="text" class="TXT"
									placeholder="输入姓名" /></td>
							</tr>
							<tr>
								<td><input name="uage" type="text" class="TXT"
									onkeyup="value=value.replace(/[^\d]/g,'') " placeholder="输入年龄"
									onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" /></td>
							</tr>
							<tr>
								<td><input name="usex" type="radio" value="男" checked="男" />男<input
									name="usex" type="radio" value="女" />女</td>
							</tr>
							<tr>
								<td><input type="submit" name="sub1" value="注册" id="sub1"
									class="submit" onClick="return saveIt()" /><input type="reset"
									name="re" class="submit" /></td>
							</tr>
							<tr>
								<td><br /></td>
								<td></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</section>
	</div>
	<div class="botom">@版权所有：CHINQ 联系方式：skyhelloworld@163.com</div>
	<c:if test="${param.logmsg==0}">
		<script>
			alert("请先登录！");
		</script>
	</c:if>
</body>
</html>