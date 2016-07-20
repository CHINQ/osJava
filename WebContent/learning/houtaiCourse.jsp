<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>后台页面</title>
<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看课程</title>
</head>
<link href="../css/index.css" type="text/css" rel="stylesheet" />
<body>
	<div class="u-1">
		<div class="u-l">
			<h3>课程总览</h3>
		</div>
		<div class="u-r">
			<h5>
				当前位置 <span class="black">> 课程总览</span>
			</h5>
		</div>
	</div>
	<div class="u-2"></div>
	<!-- 分割线线以下 -->
	<!-- 左边菜单 -->
	<div>
		<div class="u-l-l">
			<a href="houtaiCourseServlet"><img alt=""
				src="../images/c-l-1.gif" border="0px" /></a>
		</div>
		<div class="u-l-l">
			<a href="addCourseShow"><img alt="" src="../images/c-l-2.gif"
				border="0px" /></a>
		</div>
	</div>
	<p></p>
	<!-- 右边 -->
	<div>
		<table align="center">
			<tr>
				<form action="houtaiCourseServlet" method="post">
					<div align="center">
						<div>
							教师名称: <input type="text" name="bnm" /> 课程名称：<input type="text"
								name="btxt" />
						</div>
						<div>
							<input type="submit" name="sub" value="查询" /> <input type="reset"
								value="重置" />
						</div>
					</div>
				</form>
			</tr>
			<tr>
				<td>课程号</td>
				<td>课程名</td>
				<td>教师名</td>
				<td>上课时间</td>
				<td>上课地点</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${infos}" var="course">
				<tr>
					<td>${course.cid}</td>
					<td>${course.lect.lcourse}</td>
					<td>${course.lect.user.uname}</td>
					<td>${fn:substring(course.ctime,0,11)}</td>
					<td>${course.cplace}</td>
					<td><a href="updateCourse1?cid=${course.cid}">修改 </a>/ <a
						href="deleteCourse?cid=${course.cid }">删除 </a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="9">
					<div>
						<a
							href="houtaiCourseServlet?cp=1&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}">首页</a>
						<a
							href="houtaiCourseServlet?cp=${subPage.prev }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}">上一页</a>
						<a
							href="houtaiCourseServlet?cp=${subPage.nexts }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}">下一页</a>
						<a
							href="houtaiCourseServlet?cp=${subPage.totalPage }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}">尾页</a>
						当前${subPage.currentPage }页/共${subPage.totalPage }页
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>