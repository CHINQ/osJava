<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="index" value="0" />   
<c:forEach var="x" begin="1" end="9" step="1"> 
<c:set var="index" value="${index+1}" />   
index:${index}   
x:${x }   
<br>   
 
</c:forEach>  
<br>   
  

</body>
</html>