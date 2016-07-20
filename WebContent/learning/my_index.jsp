<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
	<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<link href="../css/my_index.css" type="text/css" rel="stylesheet" />
<body>
<div class="top">
	<div class="top_floatLeft">
		<img alt="" src="../images/my_index/message_1.jpg" class="gonggao_img" /><span class="gonggao_text">公告:</span>
	</div>
	<div class="dong_div">
		<marquee behavior="scroll" direction="up" scrollamount="2"
			scrolldelay="100" onmouseover="this.stop()" onmouseout="this.start()"
			class="gundong">
			<c:forEach items="${MessageList}" var="mes">
				<a href="My_IndexMessageServlet?mid=${mes.mid}" class="">${mes.mtitle}</a>
				<br />
				<br />
			</c:forEach>
		</marquee>
	</div>
</div>
<div class="big_div">
	<div class="inner_left_div2">
		<table class="right_table">
			<tr class="right_tr1">
				<td class="right_td1">标题</td>
				<td class="right_td1">时间</td>
				<td class="right_td2">进入</td>
			</tr>
			<c:forEach items="${MessageList}" var="mes">
				<tr>
					<td class="right_td1">${mes.mtitle}</td>
					<td class="right_td1">${fn:substring(mes.mtime,0,11)}</td>
					<td class="right_td2"><a
						href="My_IndexMessageServlet?mid=${mes.mid}"><div
								class="come_in">进入</div></a></td>
				</tr>
			</c:forEach>
		</table>
		<br/>
<div align="center">
	         <a href="My_IndexServlet?cp=1&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}&msg=0">首页</a>
	         <a href="My_IndexServlet?cp=${subPage.prev }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}&msg=0">上一页</a>
	         <a href="My_IndexServlet?cp=${subPage.nexts }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}&msg=0">下一页</a>
	         <a href="My_IndexServlet?cp=${subPage.totalPage }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}&msg=0">尾页</a>
	         当前${subPage.currentPage }页/共${subPage.totalPage }页
	      </div>
	</div>
	<div class="inner_right_div2">
		<div class="text_help">软件帮助</div>
		<div class="net_help">
			<a href="http://www.opera.com/zh-cn/computer" target="blink"  class="img_stl">
			<img alt="" src="../images/my_index/back_21.jpg" class="img_stl" /></a> 
			<a href="http://www.firefox.com.cn/download/" target="blink">
			<img alt="" src="../images/my_index/back_22.jpg" class="img_stl" /></a>
			<a href="http://get.adobe.com/cn/flashplayer/" target="blink">
			<img alt="" src="../images/my_index/back_23.jpg" class="img_stl" /></a> 
			<a href="https://www.google.com/intl/zh-CN/chrome/browser/" target="blink">
			<img alt="" src="../images/my_index/back_24.jpg" class="img_stl" /></a>
	   </div>
	   <div style="margin-left: 6px;"><span class="span_help">帮助邮件：</span><a href="#">skyhelloworld@163.com</a></div>
	</div>
</div>
</body>
</html>
