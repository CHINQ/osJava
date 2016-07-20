<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<link href="css/houtai_message_details.css" type="text/css"
	rel="stylesheet" />

<div class="top">
	<div class="top_floatLeft">消息详情</div>
	<div class="top_floatRight">
		当前位置&nbsp;>>&nbsp;&nbsp;<span class="text2">消息详情</span>
	</div>
</div>
<div class="big_div">
	<div class="content_div">
		<h2 align="center">${message.mtitle}</h2>
		<div class="main_text_div"><!-- <hr/> --><br/>&nbsp;&nbsp;&nbsp;&nbsp;${message.mcontent}
		<br/>
		<br/>
		<!-- <hr/> -->
		</div>
	</div>
	<div class="back"><a href="HouMessageServlet" class="back_a1">返回上页</a></div><!-- HouMessageServlet -->
</div>