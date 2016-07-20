<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资料</title>
</head>
<body>
	<div>
		<form action="studentdata" method="post" name="ff">
			<div align="center">
				<div>
					资料名称:<input type="text" name="bnm" /> 资料简介:<input type="text"
						name="btxt" />
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
				</tr>
				<c:forEach items="${infoss}" var="books">
					<tr>
						<td>${books.bid}</td>
						<td><a style="color: #000"
							href="bookssee?fileName=${ books.baddress}">${books.bname}</a></td>
						<td><img alt="" src="../${books.bimage}" width="50"
							height="50"></td>
						<td>${books.btext }</td>
						<td>${fn:substring(books.btime, 0, 11)}</td>
						<td>${books.uid }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6" align="center"><a style="color: #000"
						href="studentdata?cp=1&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}">首页</a>
						<a style="color: #000"
						href="studentdata?cp=${subPage.prev}&bnm=${empty bnm?'':bnm }&btxt=${empty btxt?'':btxt}">上一页</a>
						<a style="color: #000"
						href="studentdata?cp=${subPage.nexts}&bnm=${empty bnm?'':bnm }&btxt=${empty btxt?'':btxt}">下一页</a>
						<a style="color: #000"
						href="studentdata?cp=${subPage.totalPage}&bnm=${empty bnm?'':bnm }&btxt=${empty btxt?'':btxt}">尾页</a>
						当前${subPage.currentPage}页/共${subPage.totalPage}页</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>