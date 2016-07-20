<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>

<link href="../css/posting.css" type="text/css" rel="stylesheet" />
<link href="../css/posting_inner.css" type="text/css" rel="stylesheet" />
<script src="../js/validate.js" type="text/javascript" charset="UTF-8"></script>
<style type="text/css">
#code {
	font-family: Arial;
	font-style: italic;
	font-weight: bold;
	border: 0;
	letter-spacing: 2px;
	color: blue;
	background-image: url(../images/posting/yanzheng_back.jpg);
}
</style>
<div class="top">
	<div class="top_floatLeft">帖子列表</div>
	<div class="top_floatRight">
		当前位置&nbsp;>>&nbsp;&nbsp;<span class="text2">论坛</span>
	</div>
</div>

<div class="middle">
	<div class="middle_up">
		<a href="index.jsp?page=newposting&pid=${post.pid}"><div
				class="middle_up_in2">发表新帖</div></a> <a href="PostingServlet"><div
				class="middle_up_in3">返回列表</div></a> <a href="#reply_maoji"><div
				class="middle_up_in3">回复本帖</div></a>
	</div>
	<div class="middle_down">
		<div class="middle_down_in2">
			<div class="middle_down_in2_inner_left">
				<span>帖子：</span>${post.ptitle}
			</div>
			<div class="middle_down_in2_inner_right">树形结构</div>
		</div>
		<div class="middle_down_in3">
			<table class="middle_down_in3_table">
				<tr>
					<td class="middle_down_in3_table_td1">浏览：<span>(${post.pcount})</span>&nbsp;回复：<span>(${subPage.totalElement})</span></td>
					<td class="middle_down_in3_table_td2"><div
							class="td2_top_floatLeft">帖子标题</div></td>
				</tr>

				<tr>
					<td class="table_td3">
						<div class="td3_div">
							<span>楼主&nbsp;(${post.user.uid})</span>
						</div>
						<hr />
						<div>
							<div class="img_div">
								<img alt="" src="../${post.user.uimage}" class="images"
									align="middle">
							</div>
							<br />
							简介：${post.user.utext}
						</div>
					</td>
					<td>
						<div class="table_td4">
							<div class="td4_div"> -->
								发表于&nbsp;(${fn:substring(post.ptime,0,19)})
							</div>
							<hr />
							<div>${post.pcontent}</div>
						</div>
					</td>
				</tr>
				<c:forEach items="${replyList}" var="reply" varStatus="i">

					<tr>
						<td class="table_td3">
							<div class="td3_div">
								<span>${i.count}楼&nbsp;(${reply.user.uid})</span>
							</div>
							<hr />
							<div>
								<div class="img_div">
									<img alt="" src="../${reply.user.uimage}" class="images"
										align="middle">
								</div>
								<br />
								<c:if test="${empty friendList}">
									<a
										href="FriendAddServlet?uid=${reply.user.uid}&pid=${post.pid}">
										<div class="guanzhu_div">+关注</div>
									</a>
								</c:if>
								<c:if test="${!empty friendList}">
									<c:set var="isDoing" value="0" />
									<c:forEach items="${friendList}" var="fri" varStatus="i">
										<c:if test="${fri.user.uid==reply.user.uid}">
											<div class="yiguanzhu_div">
												√已关注|<a
													href="FriendDeleteServlet?uid=${reply.user.uid}&pid=${post.pid}">取消</a>
											</div>
											<c:set var="isDoing" value="1" />
										</c:if>
									</c:forEach>
									<c:if test="${isDoing!='1'}">
										<a
											href="FriendAddServlet?uid=${reply.user.uid}&pid=${post.pid}"><div
												class="guanzhu_div">+关注</div></a>
									</c:if>
								</c:if>

							</div>
						</td>
						<td>
							<div class="table_td4">
								<div class="td4_div">
									发表于&nbsp;(${fn:substring(reply.rtime,0,19)})
								</div>
								<hr />
								<div>${reply.rcontent}</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
			<br />
			<div class="lie5" class="page_link_div">
				<a href="Posting_InnerServlet?cpage=1&pid=${post.pid}"
					class="page_link">首页</a> <a
					href="Posting_InnerServlet?cpage=${subPage.prev}&pid=${post.pid}"
					class="page_link">上一页</a> <a
					href="Posting_InnerServlet?cpage=${subPage.nexts}&pid=${post.pid}"
					class="page_link">下一页</a> <a
					href="Posting_InnerServlet?cpage=${subPage.totalPage}&pid=${post.pid}"
					class="page_link">尾页</a> 当前${subPage.currentPage} 页/ 共
				${subPage.totalPage}页 &nbsp;&nbsp; 总计数：${subPage.totalElement}
			</div>
			<br /> <br />
			<mark id="reply_maoji"></mark>
			<div class="reply_div">
				<div class="reply_div_one">对主贴的回复</div>
				<div class="reply_div_two">回复</div>
				<hr style="clear: both;" />
				<br />
				<form action="Posting_InnerServlet?pid=${post.pid}" method="post"
					name="f1" onsubmit="return isTrue()">
					<input type="text" name="rcontent" class="form_div_input" />
					<br /> <span class="text_span"> 验证码：</span> <input type="text"
						id="input" /> &nbsp;&nbsp; <input type="button" id="code"
						onclick="createCode()" />
					&nbsp;&nbsp; <input type="submit" name="sub" value="提交"
						class="input_3_sub" />
				</form>
			</div>
			<br />
		</div>
	</div>
</div>

