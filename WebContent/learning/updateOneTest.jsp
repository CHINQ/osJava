<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/noborder.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="thd">
		<div class="thd_rt">
			<a>试题信息</a>
		</div>
		  <div class="thd_lt"><a href="TestManageServlet?msg=${0 }" style="text-decoration: none;">试题管理</a></div>
	</div>
	<div class="tft">
		<form action="TestManageServlet?msg=2" name="f1" method="post">
			<table>
				<caption>
					<h3>试题信息</h3>
				</caption>
				<c:forEach items="${tlist }" var="t">
					<tr>
						<td><span class="span1">试题编号：</span></td>
						<td><input type="hidden" name="tid" value="${t.tid }">${t.tid }</td>
					</tr>
					<tr>
						<td><span class="span1">试题题目：</span></td>
						<td><textarea rows="3" cols="20" name="title">${t.title }</textarea></td>
					</tr>
					<c:forEach items="${olist}" var="o">
						<tr>
							<td align="right"><span class="span1">选&nbsp;项&nbsp;${o.oid }：</span></td>
							<td><textarea rows="3" cols="20" name="${o.oid }">${o.ocontent }</textarea></td>
						</tr>
					</c:forEach>
					<tr>
						<td><span class="span1">正确答案：</span></td>
						<td><select name="truekey">
								<c:forEach items="${olist }" var="o">
									<c:choose>
										<c:when test="${t.truekey==o.oid }">
											<option value="${o.oid}" selected="selected">${o.oid}</option>
										</c:when>
										<c:otherwise>
											<option value="${o.oid}">${o.oid}</option>
										</c:otherwise>
									</c:choose>

								</c:forEach>
						</select></td>
					</tr>
                <tr>
				   <td colspan="2">&nbsp;</td>
				</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							name="sub" value="更新" /> <input type="reset" name="reset"
							value="重置" /></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>