<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看资料</title>
</head>
<body>
	<div>
<form action="classsee" method="post" name="ff">
	<table  align="center" style="color: #000">
		<tr>
			<td>选课编号</td>
			<td>课程编号</td>
			<td>课程名称</td>
			<td>课程地点</td>
			<td>上课时间</td>
			<td>课程状态</td>
			<td>选课人</td>
		</tr>
		<c:forEach items="${infoss}" var="course">
			<tr>
				<td>${course.sid }</td>
				<td>${course.cid }</td>
				<td>${course.lector.lcourse }</td>
				<td>${course.course.cplace }</td>
				<td>${fn:substring(course.course.ctime, 0, 11)}</td>
				<td>${course.course.cstate }</td>
				<td>${course.uid }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7"  align="center" ><a style="color: #000"
				href="classsee?cp=1&bnm=${empty snm?'':snm }&stxt=${ empty stxt?'':stxt}">首页</a>
				<a style="color: #000"
				href="classsee?cp=${subPage.prev}&snm=${empty snm?'':snm }&stxt=${empty stxt?'':stxt}">上一页</a>
				<a style="color: #000"
				href="classsee?cp=${subPage.nexts}&snm=${empty snm?'':snm }&stxt=${empty stxt?'':stxt}">下一页</a>
				<a style="color: #000"
				href="classsee?cp=${subPage.totalPage}&snm=${empty snm?'':snm }&stxt=${empty stxt?'':stxt}">尾页</a>
				当前${subPage.currentPage}页/共 ${subPage.totalPage}页</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>