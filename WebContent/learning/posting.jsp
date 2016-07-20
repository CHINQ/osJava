<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论坛</title>
<link href="../css/posting.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="top">
		<div class="top_floatLeft">帖子列表</div>
		<div class="top_floatRight">
			当前位置&nbsp;>>&nbsp;&nbsp;<span class="text2">论坛</span>
		</div>
	</div>
	<div class="middle">
		<div class="middle_up">
			<a href="index.jsp?page=newposting"><div class="middle_up_in2">发表新帖</div></a>
			<a href="MyPostingServlet"><div class="middle_up_in3">我的帖子</div></a>
		</div>
		<div class="middle_down">
			<div class="middle_down_in2">
				<div class="middle_down_in2_left">
					<a href="#" class="a1">全部</a> <a href="#" class="a2">推荐</a> <a
						href="#" class="a2">精华</a> <a href="#" class="a2">置顶</a>
				</div>
				<div class="middle_down_in2_right">
					排序方式： <select>
						<option>回帖时间</option>
						<option>发帖时间</option>
						<option>浏览数量</option>
						<option>回复数量</option>
					</select>
				</div>
			</div>
			<div class="middle_down_in3">
				<table>

					<tr>
						<td class="lie1">标题</td>
						<td class="lie2">作者</td>
						<td class="lie2">回复/浏览</td>
						<td class="lie3">最后发表</td>
					</tr>
					<c:forEach items="${posting}" var="po">
						<tr class="hang2">
							<td class="lie4"><img
								src="../images/posting/posting1_09.jpg" />
								<a href="Posting_InnerServlet?pid=${po.pid}">${po.ptitle}</a>
							</td>
							<td>${po.user.uid}</td>
							<td>${po.prcount}/${po.pcount}</td>
							<td>${fn:substring(po.ptime,0,19) }</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="4" class="lie5"><a
							href="PostingServlet?cpage=1">首页</a> <a
							href="PostingServlet?cpage=${subPage.prev}">上一页</a>
							<a
							href="PostingServlet?cpage=${subPage.nexts}">下一页</a>
							<a
							href="PostingServlet?cpage=${subPage.totalPage}">尾页</a>
							当前${subPage.currentPage}页/共${subPage.totalPage}页
							&nbsp;&nbsp; 总计数：${subPage.totalElement}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>

</body>
</html>