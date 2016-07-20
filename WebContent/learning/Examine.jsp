<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <SCRIPT LANGUAGE="JavaScript">  
 var maxtime = 30*1 //半个小时，按秒计算，自己调整!  
 function CountDown(){  
 if(maxtime>=0){  
 minutes = Math.floor(maxtime/60);  
 seconds = Math.floor(maxtime%60);  
 msg = "距离结束还有"+minutes+"分"+seconds+"秒";  
 document.all["timer"].innerHTML=msg;  
 if(maxtime == 5*60) alert('注意，还有5分钟!');  
 --maxtime;  
 }  
 else{  
 clearInterval(timer);  
 alert("时间到，结束!");  
 f1.submit();
 }  
 }  
 timer = setInterval("CountDown()",1000);   
 </SCRIPT> 
</head>
<c:if test="${empty tlist || empty olist }">
<jsp:forward page="TestServlet?msg=1"></jsp:forward>
</c:if>
<body>
<form action="TestServlet?msg=2&emid=${param.emid }" name="f1" method="post" id="f1">
   <table width="700" align="center">
     <c:forEach items="${emlist }" var="em">
			<tr>
			    <td align="center" colspan="4"><h3>${em.lect.lcourse }</h3></td>
			</tr>
			<tr>
			    <td width="50"></td>
			    <td width="200" align="right">满分：${em.emfull }</td>
			    <td width="200" align="center">时间：${em.emduration }分钟</td>
			    <td width="250" id="timer" style="color:red"></td>
			</tr>
			</c:forEach>
			<tr>
			    <td colspan="4">一，单项选择题（每题20分）</td>
			</tr>
   <c:set var="i" value="0"/>
       <c:forEach items="${tlist }" var="t">
       <c:set var="i" value="${i+1 }"/>
        <tr>
            <td colspan="4">${i},${t.title }</td>
        </tr>
        <c:forEach items="${olist }" var="o">
          <c:if test="${t.tid==o.test.tid }">
               <tr>
                   <td width="50" align="center"><input type="radio" name="${i }" value="${o.oid }"> ${o.oid }</td>
                   <td colspan="3">${o.ocontent }</td>
               </tr>
          </c:if>
        </c:forEach>
        </c:forEach>
        <tr>
           <td colspan="4" align="center"><input type="submit" name="sub" value="提交" /></td>
        </tr>
   </table>
</form>
</body>
</html>