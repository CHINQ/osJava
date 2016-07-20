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
   <div class="thd_rt"><a href="TestManageServlet?msg=${0 }" style="text-decoration: none;">试题管理</a></div>
   <div class="thd_lt"><a href="learn.jsp?page=addTest" style="text-decoration: none;">试题添加</a></div>
</div>
<div class="tft">
     <table width="90%">
          <tr class="tr1">
               <td width="10%" align="center"><span class="span1">编号</span></td>
               <td width="70%" align="center"><span class="span1">题目内容</span></td>
               <td width="10%" align="center" ><span class="span1">操作</span> </td>
          </tr>
         <c:forEach items="${tlist }" var="t">
                  <tr>
                      <td width="5%" align="center"><span class="span2">${t.tid }</span></td>
                      <td width="15%"><span class="span2">${t.title}</span></td>                  
                    <td width="10%" align="center"><a href="TestManageServlet?msg=${1 }&tid=${t.tid}" style="text-decoration: none;"><span class="span3">详细信息</span></a></td> 
                  </tr>
               </c:forEach> 
     </table>
     	   <p align="center">
	         <a href="TestManageServlet?cp=1&msg=0" style="text-decoration: none;"><span class="span4">首页</span></a>
	         <a href="TestManageServlet?cp=${subPage.prev }&msg=0" style="text-decoration: none;"><span class="span4">上一页</span></a>
	         <a href="TestManageServlet?cp=${subPage.nexts }&msg=0" style="text-decoration: none;"><span class="span4">下一页</span></a>
	         <a href="TestManageServlet?cp=${subPage.totalPage }&msg=0" style="text-decoration: none;"><span class="span4">尾页</span></a>
	        <span class="span4"> 当前${subPage.currentPage }页/共 ${subPage.totalPage }页</span>
</p>
</div>
</body>
</html>