<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/index.css" type="text/css" rel="stylesheet" />
</head>
<c:if test="${empty mlist }">
	<jsp:forward page="MenuServlet"></jsp:forward>
</c:if>
<body>
	<div class="hd">
		<div class="hd_hd"></div>
		<div class="hd_ft">
			<div class="hd_ft_lt"></div>

			<div class="hd_ft_md">
				<c:forEach items="${mlist}" var="m">
					<a href="${m.mpath }"><div class="hd_ft_md_div"><span>${m.mname }</span></div></a>
				</c:forEach>
			</div>

			<div class="hd_ft_rt"></div>
		</div>
	</div>

	<div class="md">

		<div class="md_md">
			<div class="md_md_hd"></div>
			<div class="md_md_ft">
				<c:if test="${!empty param.page }">
					<jsp:include page="${param.page }.jsp"></jsp:include>
				</c:if>
			</div>
		</div>

	</div>

	<div class="ft"></div>
</body>
</html>