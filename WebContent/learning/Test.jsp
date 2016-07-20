<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/test.css" type="text/css" rel="stylesheet">
</head>
<body>

<div class="thd">
   <div class="thd_rt"><a href="#" style="text-decoration: none;">在线考试</a></div>
   <div class="thd_lt"><a href="TestServlet?msg=${3 }" style="text-decoration: none;">历史考试</a></div>
</div>
<div class="tft">
     <table>
          <tr class="tr1">
               <td width="300" align="center"><span class="span1">考试名称</span></td>
               <td width="150" align="center"><span class="span1">考试日期</span></td>
               <td width="100" align="center"><span class="span1">时长（分钟）</span></td>
               <td width="100" align="center" ><span class="span1">操作</span> </td>
          </tr>
          <c:forEach items="${emlist }" var="em">
                  <tr>
                      <td align="center"><span class="span2">${em.lect.lcourse }</span></td>
                      <td align="center"><span class="span2">${fn:substring(em.emtime,0,11) }</span></td>
                      <td align="center"><span class="span2">${em.emduration }</span></td>
                      <td align="center"><a href="TestServlet?msg=1&emid=${em.emid }" style="text-decoration: none;"><span class="span3">进入考试</span></a></td>
                  </tr>
               </c:forEach>
                 <tr>
     </table>
     	   <p align="center">
	         <a href="TestServlet?cp=1&msg=0" style="text-decoration: none;"><span class="span4">首页</span></a>
	         <a href="TestServlet?cp=${subPage.prev }&msg=0" style="text-decoration: none;"><span class="span4">上一页</span></a>
	         <a href="TestServlet?cp=${subPage.nexts }&msg=0" style="text-decoration: none;"><span class="span4">下一页</span></a>
	         <a href="TestServlet?cp=${subPage.totalPage }&msg=0" style="text-decoration: none;"><span class="span4">尾页</span></a>
	         <span class="span4">当前${subPage.currentPage }页/共 ${subPage.totalPage }页</span>
</p>
</div>
</body>
</html>