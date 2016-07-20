<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<link href="../css/posting.css" type="text/css" rel="stylesheet" />
<link href="../css/leavewords.css" type="text/css" rel="stylesheet" />

<div class="top">
	<div class="top_floatLeft">留言板</div>
	<div class="top_floatRight">
		当前位置&nbsp;>>&nbsp;&nbsp;<span class="text2">留言板</span>
	</div>
</div>

<div class="left_right_divs">
	<div class="left_div">
		<div class="div_11">
			<img alt="" src="../images/words/words_1.jpg" /><span
				class="text_word_span">留言板</span>
		</div>
		<br />
		<div class="div_12">
			<form action="LeaveWordsServlet" method="post" name="f1">
				请选择留言对象： <select name="uid">

					<c:forEach items="${lectorList}" var="lec">
						<option value="${lec.user.uid}">${lec.user.uname}&nbsp;&nbsp;${lec.lcourse}</option>
					</c:forEach>
				</select> &nbsp;&nbsp; 在下方方框内留下您想说的话！ <br /> <br /> 留言内容：<br /> <br />

				<textarea rows="5" cols="100%" name="wcontent"
					class="words_content_textarea">请在此处输入你的留言，我们会第一时间查看！</textarea>
				<br /> <br /> <input type="reset" name="re" value="取消"
					class="anniu" /> <input type="submit" name="sub" value="提交"
					class="anniu" />
			</form>
		</div>
		<div class="div_11">
			<img alt="" src="../images/words/words_1.jpg" /><span
				class="text_word_span">留言列表</span>
		</div>
		<br />
		<div class="include_div_13">
			<c:if test="${!empty wordsList}">
				<c:forEach items="${wordsList}" var="wor">
					<div class="div_13">
						<div class="div_13_img">
							<img alt="" src="../${wor.user.uimage}">
						</div>
						<div class="div_13_xinxi">
							&nbsp;&nbsp;${wor.user.uid}&nbsp;&nbsp;to:${wor.toUser.uid}&nbsp;&nbsp;&nbsp;&nbsp;${fn:substring(wor.wtime,0,19)}<br />
							&nbsp;&nbsp;&nbsp;&nbsp;${wor.wcontent}
						</div>
					</div>
				</c:forEach>
				<div align="center">
	         <a href="LeaveWordsServlet?cp=1&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}&msg=0">首页</a>
	         <a href="LeaveWordsServlet?cp=${subPage.prev }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}&msg=0">上一页</a>
	         <a href="LeaveWordsServlet?cp=${subPage.nexts }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}&msg=0">下一页</a>
	         <a href="LeaveWordsServlet?cp=${subPage.totalPage }&bnm=${empty bnm?'':bnm }&btxt=${ empty btxt?'':btxt}&msg=0">尾页</a>
	         当前${subPage.currentPage }页/共 ${subPage.totalPage }页
	      </div>
			</c:if>
			<c:if test="${empty wordsList}">
				<div class="div_13_2">你还没有过留言！</div>
			</c:if>
		</div>
	</div>
	<div class="right_div">
	</div>
</div>



