<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<c:if test="${empty tlist || empty olist }">
	<jsp:forward page="TestServlet?msg=1"></jsp:forward>
</c:if>
<body>
	<form action="" name="f1" method="post">
		<table width="700" align="center">
			<c:forEach items="${tplist }" var="tp">
			<tr>
			    <td align="center" colspan="4"><h3>${tp.em.lect.lcourse }</h3></td>
			</tr>
			<tr>
			    <td width="50"></td>
			    <td width="200" align="center">满分：${tp.tpfull }</td>
			    <td width="150" align="center">${tp.tpscore }分</td>
			    <td width="400">时间：${tp.em.emduration }分钟</td>
			</tr>
			</c:forEach>
			<c:set var="i" value="-1" />
			<c:forEach items="${tlist }" var="t">
				<c:set var="i" value="${i+1 }" />
				<tr>
					<td colspan="4">${i+1},${t.title }</td>
				</tr>
				<c:forEach items="${olist }" var="o">
					<c:if test="${t.tid==o.test.tid }">
						<c:choose>
							<c:when test="${o.oid==tppitch[i] }">
								<tr>
									<td width="50" align="center" ><input type="radio"
										name="${i }" value="${o.oid }" checked="checked" >${o.oid }</td>
									<td colspan="3">${o.ocontent }</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td width="50" align="center" ><input type="radio"
										name="${i }" value="${o.oid }">${o.oid }</td>
									<td colspan="3">${o.ocontent }</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
				<tr>
					<td></td>
					<td colspan="3">正确答案：${t.truekey }</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3">答案解析：</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>