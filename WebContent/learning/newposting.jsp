<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<link href="../css/posting.css" type="text/css" rel="stylesheet" />
<link href="../css/newposting.css" type="text/css" rel="stylesheet" />
<script src="../js/validate.js" type="text/javascript" charset="UTF-8"></script>
<style type="text/css">
#code {
	font-family: Arial;
	font-style: italic;
	font-weight: bold;
	border: 0;
	letter-spacing: 2px;
	color: blue;
	background-image:url(../images/posting/yanzheng_back.jpg);
}
</style>
<c:if test="${empty number1}">
	<jsp:forward page="NewPostingServlet"></jsp:forward>
</c:if>
<div class="top">
	<div class="top_floatLeft">发表新帖</div>
	<div class="top_floatRight">
		当前位置&nbsp;>>&nbsp;&nbsp;<span class="text2">发表新帖</span>
	</div>
</div>

<div class="middle">
	<div class="middle_up">
		<a href="index.jsp?page=newposting"><div class="middle_up_in2">发表新帖</div></a>
		<a href="PostingServlet"><div class="middle_up_in3">返回列表</div></a>
	</div>
	<br /> <br />
	<hr class="xian2" />
	<div class="reply_content_div">
		<form action="NewPostingServlet?pid=${pid}" method="post" name="f1"
			enctype="multipart/form-data" onsubmit="return isTrue()">
			标题：<input type="text" name="ptitle" class="form_div_input" /> <br />
			<br /> 内容：<br /> <br />
			<div class="body_text_div">
				<div class="content_div">
					<div class="content_div_in2">
						<input type="file" name="files" class="form_div_files" />
					</div>
					<textarea rows="10" cols="100%" name="pcontent" class="text_area"></textarea>
				</div>

			</div>
			<br /> <span class="text_span"> 验证码：</span> <input type="text"
				id="input" /> &nbsp;&nbsp; <input type="button" id="code"
				onclick="createCode()" />
			&nbsp;&nbsp; <input type="submit" name="sub" value="提交"
				class="sub_input" />
		</form>
	</div>
</div>

<c:if test="${param.newpmsg==0}">
	<script>
   alert("新帖发表失败！");
 </script>
</c:if>