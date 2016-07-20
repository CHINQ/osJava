<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/index.css" type="text/css" rel="stylesheet" />
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="us"%>

<body>
<div class="u-1">
<div class="u-l"><h3>课程总览</h3></div>
<div class="u-r"><h5>当前位置 <span class="black">> 课程总览</span></h5></div>
</div>
<div class="u-2"></div>
<div>
 <div >

<div class="u-l-l">
<a href="houtaiCourseServlet"><img alt="" src="../images/c-l-1.gif" border="0px"/></a>
</div>
 <p></p>
 <div class="u-l-l">

 </div>
 </div>
 
<div>
 <div>
 <form action="updateCourse2" method="post"  name="f1">
		<table border="0" align="center">
			<caption><h2 class="grey">课程信息修改</h2></caption>
			<tr>
				<td><h4 class="grey">课&nbsp&nbsp程&nbsp&nbsp号:</h4></td>
				<td>${oneCourse.cid }<input type="hidden" name="cid"  value="${oneCourse.cid}"/></td>
			</tr>
			<tr>
				<td><h4 class="grey">上课时间:</h4></td>
				<td><input type="text" name="ctime" value="${fn:substring(oneCourse.ctime,0,11)}"/></td>
			</tr>
			<tr>
				<td><h4 class="grey">上课地点:</h4></td>
				<td><input type="text" name="cplace" value="${oneCourse.cplace}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="sub"
					value="修改" /> <input type="reset" name="re" />
					</td>
			</tr>
		</table>
	</form>
 </div>
 </div>