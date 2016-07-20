<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<link href="../css/houtai_message.css" type="text/css" rel="stylesheet" />

<title>消息发布界面</title>

<div class="top">
	<div class="top_floatLeft">消息管理</div>
	<div class="top_floatRight">
		当前位置&nbsp;>>&nbsp;&nbsp;<span class="text2">消息管理</span>
	</div>
</div>
<div class="big_div">
	<div class="big_inner_left">
		<div class="inner_left_div1">
			&nbsp;&nbsp;&nbsp;&nbsp;》<a href="HouMessageServlet" class="main_a">查看所有消息</a>
		</div>
		<div class="inner_left_div1">
			&nbsp;&nbsp;&nbsp;&nbsp;》<a href="#" class="main_a">发布新消息</a>
		</div>
	</div>
	<div class="big_inner_right">
		<div class="inner_right_div1">
			<img alt="" src="../images/words/words_1.jpg" />&nbsp;&nbsp;<span
				class="text3">消息列表</span>
		</div>
		<div class="inner_right_div2">
			<form action="HouMessageAddServlet" method="post" name="f1">
				<table align="center" style="border: 0px;">
					<tr>
						<td>标题：<br /> <br /> <textarea rows="1%" cols="50%"
								name="mtitle" class="words_content_textarea">请在此处输入消息标题</textarea>
							<br /> <br /> 消息内容：<br /> <br /> <textarea rows="7%"
								cols="50%" name="mcontent" class="words_content_textarea">请在此处输入消息内容！</textarea>
						</td>
					</tr>
					<tr>
						<td align="center"><input type="submit" name="sub" value="提交"
							class="anniu" /> <input type="reset" name="re" value="取消"
							class="anniu" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>