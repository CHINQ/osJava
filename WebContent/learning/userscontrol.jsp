<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link href="../css/studentct.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="u-1">
		<div class="u-l">
			<h3>用户管理</h3>
		</div>
		<div class="u-r">
			<h5>
				当前位置 <span class="black">> 用户管理</span>
			</h5>
		</div>
	</div>
	<div class="u-2"></div>
		<div>
			<hr width="1px"  />
		</div>
		<div class="lf">
			<div class="szbg">
				<a href="usersee" class="noxian">&nbsp;用户查看</a>
			</div>
			<div class="szkg"></div>
			<div class="szbg">
				<a href="learn.jsp?page=userscontrol&page1=tezhuce" class="noxian">&nbsp;讲师注册</a>
			</div>
		</div>
		<div class="fengge">
			<div class="dian"></div>
		</div>
		<div class="rt">
			<div>操作信息</div>
			<div>
				<hr />
			</div>
			<div>
				<c:if test="${!empty param.page1}">
					<jsp:include page="${param.page1}.jsp"></jsp:include>
				</c:if>
			</div>
		</div>
</body>
</html>