<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资料操作</title>
</head>
<body>
	<div>
		<form action="studentdatadel" method="post" name="ff">
			<div align="center">
				<div>
					资料名称:<input type="text" name="bnm" width="80px" /> 简介:<input
						type="text" name="btxt" width="80px" />
				</div>
				<div>
					<input type="submit" name="sub" value="查询" />
					 <input type="reset"	value="重置" />
				</div>
			</div>
			<table align="center" style="color: #000">
				<tr>
					<td>资料编号</td>
					<td>资料名称</td>
					<td>图片</td>
					<td>简介</td>
					<td>上传时间</td>
					<td>上传人</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${infoss}" var="books">
					<tr>
						<td>${books.bid}</td>
						<td><a style="color: #000"
							href="bookssee?fileName=${ books.baddress}">${books.bname}</a></td>
						<td><img alt="" src="../${books.bimage}" width="50"
							height="50"></td>
						<td>${books.btext }</td>
						<td>${fn:substring(books.btime,0,11)}</td>
						<td>${books.uid }</td>
						<td><a style="color: #000"
							href="learn.jsp?page=datamanager&page1=updatedatayy?bid=${books.bid}">修改</a>/
							<a style="color: #000" href="deldata?bid=${books.bid }">删除</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="8" align="center"><a style="color: #000"
						href="studentdatadel?cp=1&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}">首页</a>
						<a style="color: #000"
						href="studentdatadel?cp=${subPage.prev}&bnm=${empty bnm?'':bnm }&btxt=${empty btxt?'':btxt}">上一页</a>
						<a style="color: #000"
						href="studentdatadel?cp=${subPage.nexts}&bnm=${empty bnm?'':bnm }&btxt=${empty btxt?'':btxt}">下一页</a>
						<a style="color: #000"
						href="studentdatadel?cp=${subPage.totalPage}&bnm=${empty bnm?'':bnm }&btxt=${empty btxt?'':btxt}">尾页</a>
						当前${subPage.currentPage}页/共${subPage.totalPage}页</td>
				</tr>
			</table>
		</form>
		<c:if test="${param.delmsg==1 }">
			<script>
				alert("删除成功")
			</script>
		</c:if>
		<c:if test="${param.delmsg==0 }">
			<script>
				alert("删除失败")
			</script>
		</c:if>
	</div>
</body>
</html>