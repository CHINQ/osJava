<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="us"%>
<link href="../css/index.css" type="text/css" rel="stylesheet" />
<title>前台页面</title>
<body>
<div class="u-1">
<div class="u-l"><h3>课程总览</h3></div>
<div class="u-r"><h5>当前位置 <span class="black">> 课程总览</span></h5></div>
</div>
<div class="u-2"></div>
<div >

<div class="u-l-l">
<a href="CourseServlet"><img alt="" src="../images/c-l-1.gif"/></a>
</div>
 <p></p>
 <div class="u-l-l">
<!-- <a href=""><img alt="" src="../images/c-l-3.gif"/></a> -->
 </div>
 
 </div>
 <p></p>
<div>
  <table border="0" align="center" width="900">
  <tr>	<hr/>
			<td>&nbsp<hr/></td>
			<td>&nbsp<hr/></td>
			<form action="CourseServlet" method="post">
				<td colspan="9">教师名称: <input type="text" name="bnm" /> 
				课程名称：<input type="text" name="btxt" />	<hr/>
				</td>
				<td><input type="submit" name="sub" value="查询">	<hr/>
			</form>
			<form action="CourseServlet" method="post">
				<input type="submit" name="sub" value="返回">
			</form>
			<hr/>
			</td>
				
		</tr>
  <tr>
    <td>课程号<hr/></td>
    <td>课程名<hr/></td>
    <td>教师名<hr/></td>
    <td>上课时间<hr/></td>
    <td>上课地点<hr/></td>
    <td>选课<hr/></td>
 </tr>
  <us:forEach items="${infos}" var="course"> 
	  <tr >
	     <td >${course.cid}<hr/></td>
	     <td >${course.lector.lcourse}<hr/></td>
	     <td>${course.lector.users.uname}<hr/></td>
	     <td>${course.ctime}<hr/></td>
	     <td>${course.cplace}<hr/></td>
	     <td><a href="">选课</a><hr/></td>  
	   </tr>  
  </us:forEach> 
  
  <tr>

  <td></td>
    <td></td>
  
	      <td colspan="9">
	         <a href="CourseServlet?cp=1&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}">首页</a>
	         <a href="CourseServlet?cp=${subPage.prev }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}">上一页</a>
	         <a href="CourseServlet?cp=${subPage.nexts }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}">下一页</a>
	         <a href="CourseServlet?cp=${subPage.totalPage }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}">尾页</a>
	         当前${subPage.currentPage }页/共 ${subPage.totalPage }页
	      </td>
	   </tr>
  </table>
  </div> 
</body>
</html>