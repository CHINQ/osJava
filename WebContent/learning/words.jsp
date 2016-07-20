<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<!-- <link href="css/houtai_message.css" type="text/css" rel="stylesheet" /> -->
<link href="../css/houtai_words.css" type="text/css" rel="stylesheet" />

<title>消息管理</title>
<div class="top">
	<div class="top_floatLeft">留言管理</div>
	<div class="top_floatRight">
		当前位置&nbsp;>>&nbsp;&nbsp;<span class="text2">留言管理</span>
	</div>
</div>
<div class="big_div">
	<div class="big_inner_left">
		<div class="inner_left_div1">
			&nbsp;&nbsp;&nbsp;&nbsp;》<a href="HouWordsServlet" class="main_a">查看所有留言</a>
		</div>
	</div>

	<div class="big_inner_right">
		<div class="inner_right_div1">
			<img alt="" src="../images/words/words_1.jpg" />&nbsp;&nbsp;<span
				class="text3">留言列表</span>
		</div>
		<c:if test="${!empty wordsList}">
			<div class="inner_right_div2">
				<c:forEach items="${wordsList}" var="wor">
					<div class="div_13">
						<div class="div_13_img">
							<img alt="" src="../${wor.user.uimage}">
						</div>
						<div class="div_13_xinxi">
							&nbsp;&nbsp;${wor.user.uid}&nbsp;&nbsp;&nbsp;&nbsp;${fn:substring(wor.wtime,0,11)}<br />
							&nbsp;&nbsp;&nbsp;&nbsp;${wor.wcontent}
						</div>
					</div>
				</c:forEach>
				<div style="float: right; margin-right: 60px; margin-top: 20px;">
					<a href="HouWordsServlet?cp=1">首页</a> <a
						href="HouWordsServlet?cp=${subPage.prev}">上一页</a> <a
						href="HouWordsServlet?cp=${subPage.nexts}">下一页</a> <a
						href="HouWordsServlet?cp=${subPage.totalPage}">尾页</a>
					页数&nbsp;${subPage.currentPage} / ${subPage.totalPage} &nbsp;
					总计数：${subPage.totalElement}
				</div>
			</div>
		</c:if>
		<c:if test="${empty wordsList}">
			<div class="div_13" style="text-align: center; line-height: 67px;">你还没有过留言！</div>
		</c:if>
	</div>
</div>
