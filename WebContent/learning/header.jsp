<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ include file="/houtai/includes.jsp"%>
<link href="../css/header.css" type="text/css" rel="stylesheet" />

<div class="total_header">
		<img alt="" src="../images/header/ht-logo.jpg" class="ht_logo" />
		<!--  -->
		<c:if test="${users.upower==0}">
		<div class="big_text">
		   <div class="logo_text"><h2>后台管理</h2></div>
		</div>
		</c:if>
		<c:if test="${users.upower!=0}">
		<div class="big_text">
		   <div class="logo_text"><h2>osJava</h2></div>
		</div>
		</c:if>
		<div class="little_link">
		  欢迎&nbsp;
		 <a href="UsersServlet" class="name">[&nbsp;${users.uname}&nbsp;]</a>&nbsp;
		 <a href="OneUsersServlet" class="oth">修改个人资料</a>&nbsp;&nbsp;
		 <a href="#come?comsg=1" class="oth">签到</a>&nbsp;&nbsp;
		 <a href="../index.jsp" class="oth">退出</a>
		</div>
		
</div>
<mark id="come"></mark>
<c:if test="${param.comsg==1}">
 <script>alert("签到成功！");</script>
</c:if>