<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加课程</title>
</head>
<link href="../css/index.css" type="text/css" rel="stylesheet" />
<body>
<div class="u-1">
<div class="u-l"><h3>课程总览</h3></div>
<div class="u-r"><h5>当前位置 <span class="black">> 课程总览</span></h5></div>
</div>
<div class="u-2"></div>
<div >
<div class="u-l-l">
<a href="houtaiCourseServlet"><img alt="" src="../images/c-l-1.gif" border="0px"/></a>
</div>
 <div class="u-l-l">
<a href="index.jsp?page=addCourse"><img alt="" src="../images/c-l-2.gif" border="0px"/></a>
 </div>
 </div>
 <p></p>
 <div>
 <form action="addCourse" method="post" name="f1" />
		<table border="0" align="center">
			<caption><h2 class="grey">课程信息添加</h2></caption>
			<tr>
				<td><h4 class="grey">课&nbsp&nbsp程&nbsp&nbsp名:</h4></td>

				<td><select name="lid">
						<c:forEach items="${lcou}" var="lc">
							<option value="${lc.lid}">${lc.lcourse }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><h4 class="grey">上课时间:</h4></td>
				<td><input type="text" name="ctime" /></td>
			</tr>
			<tr>
				<td><h4 class="grey">上课地点:</h4></td>
				<td><input type="text" name="cplace"  /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="sub"
					value="添加" /> <input type="reset" name="re" />
					</td>
			</tr>
		</table>
	</form>
 </div>
</body>
</html>