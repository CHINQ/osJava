<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/test.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="thd">
		<div class="thd_rt">
			<a>添加试题</a>
		</div>
		<div class="thd_lt"><a href="TestManageServlet?msg=${0 }" style="text-decoration: none;">试题管理</a></div>
	</div>
	<div class="tft">
		<form action="TestManageServlet?msg=3" name="f1" method="post">
			<table>
				<caption><h3>添加试题</h3></caption>
				<tr>
				   <td>试题题目</td>
				   <td><textarea rows="3" cols="20" name="title"></textarea></td>
				</tr>
				<tr>
					<td align="center">选项A</td>
					<td><textarea rows="3" cols="20" name="A"></textarea></td>
				</tr>
				<tr>
					<td align="center">选项B</td>
					<td><textarea rows="3" cols="20" name="B"></textarea></td>
				</tr>
				<tr>
					<td align="center">选项C</td>
					<td><textarea rows="3" cols="20" name="C"></textarea></td>
				</tr>
				<tr>
					<td align="center">选项D</td>
					<td><textarea rows="3" cols="20" name="D"></textarea></td>
				</tr>
				<tr>
					<td>正确答案</td>
					<!-- <td><input type="text" name="truekey" ></td> -->
					<td><select name="truekey">
					      <option selected="selected">A</option>
					      <option >B</option>
					      <option >C</option>
					      <option >D</option>
					</select></td>
				</tr>
		
				<tr>
					<td colspan="2" align="center"><input type="submit" name="sub"
						value="添加" /> <input type="reset" name="reset" value="重置" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>