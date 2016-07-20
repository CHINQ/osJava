<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资料上传</title>
</head>
<body>
<div>
	<form action="adddata" method="post" enctype="multipart/form-data"
		name="f1">
		<table align="center">
			<tr>
				<td>名称</td>
				<td><input type="text" name="bname" /></td>
			</tr>
			<tr>
				<td>简介</td>
				<td><input type="text" name="btext" /></td>
			</tr>
			<tr>
				<td>图片</td>
				<td><input type="file" name="bimage" /></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="file" name="baddress" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="sub"
					value="添加" /> <input type="reset" name="re" /></td>
			</tr>
		</table>
	</form>
</div>
<c:if test="${param.msg==1 }">
	<script>
		alert("添加成功")
	</script>
</c:if>
<c:if test="${param.msg==0 }">
	<script>
		alert("添加失败")
	</script>
</c:if>
</body>
</html>