<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<link href="../css/posting.css" type="text/css" rel="stylesheet" />
<link href="../css/myposting.css" type="text/css" rel="stylesheet" />

<div class="top">
	<div class="top_floatLeft"><a href="MyPostingServlet">我的帖子</a>&nbsp;&nbsp;<a href="PostingServlet">返回论坛</a></div>
	<div class="top_floatRight">
		当前位置&nbsp;>>&nbsp;&nbsp;<span class="text2">论坛-->我的帖子</span>
	</div>
</div>
<div class="include_content_div">
	<table class="my_table">
		<tr>
			<td class="my_td_1">标题</td>
			<td class="my_td_2">操作</td>
		</tr>
	</table>
	<c:forEach items="${mypost}" var="myp">
		<div class="div_22">${myp.ptitle}</div>
		<div class="div_23">
			<a href="Posting_InnerServlet?pid=${myp.pid}">查看</a>/<a href="MyPostingDelServlet?pid=${myp.pid}">删除</a>
		</div>
	</c:forEach>
	<div style="float: right; margin-right: 60px; margin-top: 20px;">
		<a href="MyPostingServlet?cpage=1">首页</a> <a
			href="MyPostingServlet?cpage=${subPage.prev}">上一页</a> <a
			href="MyPostingServlet?cpage=${subPage.nexts}">下一页</a> <a
			href="MyPostingServlet?cpage=${subPage.totalPage}">尾页</a>
		页数&nbsp;${subPage.currentPage} / ${subPage.totalPage} &nbsp;
		总计数：${subPage.totalElement}
	</div>
</div>
<c:if test="${param.delpmsg==1}">
	<script>
		alert("帖子已成功删除！");
	</script>
</c:if>
<c:if test="${param.delpmsg==0}">
	<script>
		alert("帖子删除失败！");
	</script>
</c:if>