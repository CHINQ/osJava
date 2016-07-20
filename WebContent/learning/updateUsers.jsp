<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/houtai/includes.jsp"%>
<link href="../css/index.css" type="text/css" rel="stylesheet" />
<title>修改用户资料</title>
<div class="u-1">
	<div class="u-l">
		<h3>个人中心</h3>
	</div>
	<div class="u-r">
		<h5>
			当前位置 <span class="black">> 个人中心</span>
		</h5>
	</div>
</div>
<div class="u-2"></div>
<div class="u-l-l">
	<a href="UsersServlet"><img alt="" src="../images/u-l-1.gif"
		border="0px" /></a>
</div>
<p></p>
<div class="u-l-l">
	<a href="OneUsersServlet"><img alt="" src="../images/u-l-2.gif"
		border="0px" /></a>
</div>
<div class="grey">
	<div class="u-left"></div>
	<div class="u-midd">
		<div>
			<h2>个人资料修改</h2>
		</div>

		<div>
			<h3>密码修改</h3>
		</div>
		<form action="updateUpass" name="form1" method="post">
			<div>
				用户账号：${users.uid}<input type="hidden" name="uid"
					value="${users.uid}" />
			</div>
			<p></p>
			<div>
				旧密码：<input type="password" name="oldupass">
			</div>
			<p></p>
			<div>
				新密码：<input type="password" name="newupass">
			</div>
			<p></p>
			<div>
				重复密码：<input type="password" name="newupass1">
			</div>
			<p></p>
			<div>
				<input type="submit" name="1" id="1" value="提交"> <input
					type="reset" name="0" id="0" value="取消">
			</div>
		</form>
		<p></p>
		<div>
			<h2>相关资料修改</h2>
		</div>
		<form action="updateUsers2" name="form6" method="post"
			enctype="multipart/form-data">

			<div>
				用户账户：${users.uid}<input type="hidden" name="uid"
					value="${users.uid}" />
			</div>
			<p></p>
			<div>
				姓名： <input type="text" name="uname" value="${users.uname }" />
			</div>
			<p></p>
			<div>
				头像：
				<td><input type="file" name="uimage" /></td>
			</div>
			<p></p>
			<div>
				年龄： <input type="text" name="uage" value="${users.uage }" />
			</div>
			<p></p>
			<div>
				性别： <input type="radio" name="usex" value="男" checked="checked" />男
				<input type="radio" name="usex" value="女" />女
			</div>
			<p></p>
			<div>
				简介：
				<textarea name="utext" cols="45" rows="5">${users.utext }</textarea>
			</div>
			<div>
				<input type="submit" name="1" value="修改"> <input
					type="reset" name="0" value="取消">
			</div>
		</form>
	</div>
	<div class="u-right"></div>
</div>
<c:if test="${param.msg==0 }">
	<script>
		alert("旧密码输入错误")
	</script>
</c:if>
<c:if test="${param.msg==1 }">
	<script>
		alert("修改成功")
	</script>
</c:if>
<c:if test="${param.msg==2 }">
	<script>alert("新密码不能为空")</script>
</c:if>
<c:if test="${param.msg==3 }">
	<script>alert("两次密码输入不一致")</script>
</c:if>