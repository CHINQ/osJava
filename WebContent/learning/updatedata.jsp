<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资料修改</title>
</head>
<body>
<div>
	<form action="updatedata1" method="post" enctype="multipart/form-data"
		name="f1">
		<table  align="center">
			<tr>
				<td>编号</td>
				<td><input type="text" name="bid"
					value="${oneBook.bid }"  readonly="readonly" style="background-color:#727377"/></td>
			</tr>
			<tr>
				<td>名称</td>
				<td><input type="text" name="bname" value="${oneBook.bname }" /></td>
			</tr>
			<tr>
				<td>简介</td>
				<td><input type="text" name="btext" value="${oneBook.btext }"/></td>
			</tr>
			<tr>
				<td>图片</td>
				<td><input type="file" name="bimage" /></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" name="baddress"
					value="${oneBook.baddress }" /></td>
			</tr>
			<tr>
				<td>时间</td>
				<td><input type="text" name="btime"
					value="${fn:substring(oneBook.btime,0,11)}"readonly="readonly" style="background-color:#727377"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="sub"
					value="修改" /> <input type="reset" name="re" /> <c:if
						test="${param.msg==1 }">
						   添加成功
					</c:if> <c:if test="${param.msg==0 }">
						   添加失败
					</c:if></td>

			</tr>
		</table>
	</form>
</div>
</body>
</html>