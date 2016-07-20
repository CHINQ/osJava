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
			<a>更新考试信息</a>
		</div>
		<div class="thd_lt"><a href="ExamManageServlet?msg=0" style="text-decoration: none;">考试管理</a></div> 
	</div>
	<div class="tft">
		<form action="ExamManageServlet?msg=4" name="f1" method="post">
			<table>
				<caption><h3>更新考试信息</h3></caption>
				<c:forEach items="${emlist }" var="em">
				<tr>
				   <td><span class="span1">试卷编号：</span></td>
				   <td><input type="hidden" name="emid" value="${em.emid }">${em.emid }</td>
				</tr>
                <tr>
				   <td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td><span class="span1">选择课程：</span></td>
					<td><select name="lid">
							<c:forEach items="${llist }" var="l">
								<c:choose>
									<c:when test="${em.lect.lid==l.lid }">
										<option value="${l.lid }" selected="selected">${l.lcourse}</option>
									</c:when>
									<c:otherwise>
										<option value="${l.lid }">${l.lcourse}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>
                <tr>
				   <td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td><span class="span1">考试日期：</span></td>
					<td><input type="text" name="emtime" value="${fn:substring(em.emtime,0,11) }"></td>
				</tr>
                <tr>
				   <td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td><span class="span1">考试时长：</span></td>
					<td><input type="text" name="emduration" value="${em.emduration }"></td>
				</tr>
                <tr>
				   <td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" name="sub"
						value="更新" /> <input type="reset" name="reset" value="重置" /></td>
				</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
<c:if test="${param.str==0 }">
<script>alert("时间输入错误")</script>
</c:if>
<c:if test="${param.str==1 }">
<script>alert("考试时间不能为空")</script>
</c:if>
<c:if test="${param.str==2 }">
<script>alert("考试日期不能为空")</script>
</c:if>
<c:if test="${param.str==3 }">
<script>alert("日期格式错误")</script>
</c:if>
</html>