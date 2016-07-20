<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户查看</title>
</head>
<body>
	<form action="usersee" method="post" name="ff">
		<div align="center">
			<div>
				姓名:<input type="text" name="bnm" />
				账号:<input type="text" name="btxt" />
			</div>
			<div>
				<input type="submit" name="sub" value="查询" />
				<input type="reset"	value="重置" />
			</div>
		</div>
		<table align="center">
			<tr>
				<td>账号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>性别</td>
				<td>图像</td>
				<td>简介</td>
				<td>权限</td>
				<td>状态</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${infoss}" var="user">
				<tr>
					<td>${user.uid}</td>
					<td>${user.uname}</td>
					<td>${user.uage}</td>
					<td>${user.usex}</td>
					<td><img alt="" src="../${user.uimage}" width="50" height="50"></td>
					<td>${user.utext}</td>
					<td>${user.upower}</td>
					<td>${user.ustate}</td>
					<td><a href="delusers?uid=${user.uid }" style="color: #000">删除</a>
						<a href="updausers?uid=${user.uid }" style="color: #000">密码初始</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="9" align="center"><a style="color: #000"
					href="usersee?cp=1&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}">首页</a>
					<a style="color: #000"
					href="usersee?cp=${subPage.prev}&bnm=${empty bnm?'':bnm }&btxt=${empty btxt?'':btxt}">上一页</a>
					<a style="color: #000"
					href="usersee?cp=${subPage.nexts}&bnm=${empty bnm?'':bnm }&btxt=${empty btxt?'':btxt}">下一页</a>
					<a style="color: #000"
					href="usersee?cp=${subPage.totalPage}&bnm=${empty bnm?'':bnm }&btxt=${empty btxt?'':btxt}">尾页</a>
					当前${subPage.currentPage}页/共${subPage.totalPage}页</td>
			</tr>
		</table>
	</form>
</body>
</html>