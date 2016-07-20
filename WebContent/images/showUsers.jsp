<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <title>前台页面</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="us"%>
<link href="../css/index.css" type="text/css" rel="stylesheet" />
<div class="u-1">
<div class="u-l"><h3>个人中心</h3></div>
<div class="u-r"><h5>当前位置 <span class="black">> 个人中心</span></h5></div>
</div>
<div class="u-2"></div>
<div >

<div class="u-l-l">
<a href="UsersServlet"><img alt="" src="../images/u-l-1.gif"/></a>
</div>
 <p></p>
 <div class="u-l-l">
<a href="OneUsersServlet"><img alt="" src="../images/u-1-4.gif"/></a>
 </div>
 </div>
 <p></p>
<div>
 <div class="u-left"></div>
  <div class="u-midd grey">
    <div><h2>账号:${uid}</h2></div>
    <div><h2>昵称:${users.uname }</h2></div>
    <div><h2>年龄:${users.uage}</h2></div>
    <div><h2>性别:${users.usex }</h2></div>
    <div><h2>简介:${users.utext}</h2></div>

 </div>
<%--  <us:forEach items="${infos}" var="us">  --%>
	  
<%--   </us:forEach> --%> 
<div class="u-right grey">
<div>
<div><img alt="" src="../${users.uimage }" width="50" height="50"></div>
<h3>头像</h3>
</div>
</div>
</div> 
