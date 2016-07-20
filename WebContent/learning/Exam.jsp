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
   <div class="thd_rt"><a href="LectorServlet?msg=0" style="text-decoration: none;">发布考试</a></div>
</div>
<div class="tft">

     <table>
     <caption><h3>考试信息</h3></caption>
          <tr class="tr1">
               <td width="300" align="center"><span class="span1">考试名称</span></td>
               <td width="150" align="center"><span class="span1">考试日期</span></td>
               <td width="100" align="center"><span class="span1">时长（分钟）</span></td>
               <td width="100" align="center" colspan="2"><span class="span1">操作 </span></td>
          </tr>
          <c:if test="${!empty emlist}">
               <c:forEach items="${emlist }" var="em">
               <c:if test="${em.emstate==1 && em.emoverdue==1}">
                  <tr>
                      <td align="center"><span class="span2">${em.lect.lcourse }</span></td>
                      <td align="center"><span class="span2">${fn:substring(em.emtime,0,11) }</span></td>
                      <td align="center"><span class="span2">${em.emduration }</span></td>
                      <td width="80" align="center"><a href="ExamManageServlet?msg=2&emid=${em.emid }" style="text-decoration: none;"><span class="span3">取消考试</span></a></td>
                      <td width="80" align="center"><a href="ExamManageServlet?msg=3&emid=${em.emid }" style="text-decoration: none;"><span class="span3">更新</span></a></td>
                  </tr>
                  </c:if>
                  <c:if test="${em.emstate==0 || em.emoverdue==0 }">
                  <tr>
                      <td align="center"><span class="span2">${em.lect.lcourse }</span></td>
                      <td align="center"><span class="span2">${fn:substring(em.emtime,0,11) }</span></td>
                      <td align="center"><span class="span2">${em.emduration }</span></td>
                      <td colspan="2" align="center"><span class="span2">考试已取消</span></td>
                  </tr>
                  </c:if>
               </c:forEach>
          </c:if>
	   </table>
	   <p align="center">
	         <a href="ExamManageServlet?cp=1&msg=0" style="text-decoration: none;"><span class="span4">首页</span></a>
	         <a href="ExamManageServlet?cp=${subPage.prev }&msg=0" style="text-decoration: none;"><span class="span4">上一页</span></a>
	         <a href="ExamManageServlet?cp=${subPage.nexts }&msg=0" style="text-decoration: none;"><span class="span4">下一页</span></a>
	         <a href="ExamManageServlet?cp=${subPage.totalPage }&msg=0" style="text-decoration: none;"><span class="span4">尾页</span></a>
	         <span class="span4">当前${subPage.currentPage }页/共 ${subPage.totalPage }页</span>
</p>
</div>
<c:if test="${param.str==0 }">
<script>alert("发布成功")</script>
</c:if>
<c:if test="${param.str==1 }">
<script>alert("取消成功")</script>
</c:if>
<c:if test="${param.str==2 }">
<script>alert("更新成功")</script>
</c:if>
</body>
</html>