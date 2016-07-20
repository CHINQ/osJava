<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/houtai/includes.jsp"%>
<link href="../css/index.css" type="text/css" rel="stylesheet" />
<title>选课</title>
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
	<div>
		<div class="u-l-l">
			<a href="Course_Servlet"><img alt="" src="../images/c-l-1.gif"
				border="0px" /></a>
		</div>
		<div class="u-l-l"></div>
	</div>
	<div>
		<table align="center" width="900">
			<tr>
				<form action="Course_Servlet" method="post">
					<div align="center">
						<div>
							教师名称: <input type="text" name="bnm" /> 课程名称：<input type="text"
								name="btxt" />
						</div>
						<div>
							<input type="submit" name="sub" value="查询"> <input
								type="reset" value="重置">
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
				<td>选课</td>
			</tr>
			<c:forEach items="${infos}" var="course">
				<tr>
					<td>${course.cid}</td>
					<td>${course.lect.lcourse}</td>
					<td>${course.lect.user.uname}</td>
					<td>${fn:substring(course.ctime,0,11)}</td>
					<td>${course.cplace}</td>
					<td><a href="XuankeCourseServlet?cid=${course.cid}">选课</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="9" align="center"><a
					href="Course_Servlet?cp=1&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}">首页</a>
					<a
					href="Course_Servlet?cp=${subPage.prev }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}">上一页</a>
					<a
					href="Course_Servlet?cp=${subPage.nexts }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}">下一页</a>
					<a
					href="Course_Servlet?cp=${subPage.totalPage }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}">尾页</a>
					当前${subPage.currentPage }页/共${subPage.totalPage }页</td>
			</tr>
		</table>
	</div>
	<c:if test="${param.msgsel==0 }">
		<script>alert("选课成功")</script>
	</c:if>
</body>
</html>