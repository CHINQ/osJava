<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script src="../js/index.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
	<form action="tezhuce" method="post" name="f2">
		<table align="center">
			<caption>教师注册</caption>
			<tr>
				<td>用户账号:</td>
				<td><input name="uid" type="text" class="txt"
					onkeyup="value=value.replace(/[\W]/g,'') " placeholder="例如:abc1"
					onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" /></td>
			</tr>
			<tr>
				<td>输入密码:</td>
				<td><input name="upass" type="password" class="txt"
					placeholder="例如:abc1" /></td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td><input name="upass1" type="password" class="txt"
					placeholder="例如:abc1" /></td>
			</tr>
			<tr>
				<td>真实姓名:</td>
				<td><input name="uname" type="text" class="txt"
					placeholder="例如:李abc1" /></td>
			</tr>
			<tr>
				<td>输入年龄:</td>
				<td><input name="uage" type="text" class="txt"
					onkeyup="value=value.replace(/[^\d]/g,'') " placeholder="12"
					onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" /></td>
			</tr>
			<tr>
				<td>选择性别:</td>
				<td><input name="usex" type="radio" value="男" checked="男" />男<input
					name="usex" type="radio" value="女" />女</td>
			</tr>
		</table>
		<div align="center">
			<input type="submit" name="sub1" value="注册" id="sub1"
				onClick="return saveIt()" /> <input type="reset" name="re" />
		</div>
	</form>
</body>
</html>