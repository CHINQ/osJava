<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<link href="../css/houtai_message.css" type="text/css" rel="stylesheet" />

<title>消息管理</title>

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
			&nbsp;&nbsp;&nbsp;&nbsp;》<a href="index.jsp?page=message_add" class="main_a">发布新消息</a>
		</div>
	</div>
	<c:if test="${!empty MessageList}">

		<div class="big_inner_right">
			<div class="inner_right_div1">
				<img alt="" src="../images/words/words_1.jpg" />&nbsp;&nbsp;<span
					class="text3">消息列表</span>
			</div>
			<div class="inner_right_div2">
				<table class="right_table">
					<tr class="right_tr1">
						<td class="right_td1">发布人</td>
						<td class="right_td1">标题</td>
						<td class="right_td1">时间</td>
						<td class="right_td1">进入</td>
						<td class="right_td2">编辑</td>
					</tr>
					<c:forEach items="${MessageList}" var="mes">
						<tr>
							<td class="right_td1">${mes.user.uname}</td>
							<td class="right_td1">${mes.mtitle}</td>
							<td class="right_td1">${fn:substring(mes.mtime,0,11)}</td>
							<td class="right_td1"><a href="HouMessageSeeServlet?mid=${mes.mid}"><div class="come_in">进入</div></a></td>
							<td class="right_td2"><a
								href="HouMessageChangeServlet?mid=${mes.mid}">修改</a>/
								<a href="HouMessageDeleteServlet?mid=${mes.mid}">删除</a></td>
						</tr>
					</c:forEach>
				</table>
				<br/>
					<div align="center">
	         <a href="HouMessageServlet?cp=1&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}&msg=0">首页</a>
	         <a href="HouMessageServlet?cp=${subPage.prev }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}&msg=0">上一页</a>
	         <a href="HouMessageServlet?cp=${subPage.nexts }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}&msg=0">下一页</a>
	         <a href="HouMessageServlet?cp=${subPage.totalPage }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}&msg=0">尾页</a>
	         当前${subPage.currentPage }页/共 ${subPage.totalPage }页
	      </div>
			</div>
		</div>
	</c:if>
	<c:if test="${!empty oneMessage}">
		<div class="big_inner_right">
			<div class="inner_right_div1">
				<img alt="" src="../images/words/words_1.jpg" />&nbsp;&nbsp;<span
					class="text3">消息修改</span>
			</div>
			<div class="inner_right_div2">
				<form action="HouMessageChangeServlet?mid=${oneMessage.mid}" method="post" name="f1" >
					<table align="center" class="table_1">
						<tr>
							<td>发布者：${oneMessage.user.uname}<input type="hidden"
								name="uid" value="${oneMessage.user.uid}" /></td>
						</tr>
						<tr>
							<td>标题：<input type="text" name="mtitle"
								value="${oneMessage.mtitle}" /></td>
						</tr>
						<tr>
							<td>内容：<textarea rows="10%" cols="50%" name="mcontent">${oneMessage.mcontent}</textarea>
							</td>
						</tr>
						<tr>
						 <td colspan="2" align="center"><input type="submit" name="sub" value="修改" class="anniu" />
					&nbsp;&nbsp;
					<input type="reset" name="res" value="取消" class="anniu" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</c:if>
</div>