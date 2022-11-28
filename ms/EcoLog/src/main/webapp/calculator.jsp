<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>계산기</h1>
    <form name="form" method="POST" action="<c:url value='/calculator/register' />">
    
    <input type="hidden" name="date" value="${calculator.id}"/>
    
      <div id="year"></div>
      <div id="month"></div>
      <div id="day"></div>
      
      <input type="text" id="activity">
      
      </form>
    <script>
      var str = window.opener.document.getElementById( "current-year-month" ).innerHTML;
      var day = window.opener.document.getElementById( "main-date" ).innerHTML;
      
      var words = str.split("&nbsp;");

      document.getElementById( "year" ).innerHTML = words[4];
      document.getElementById( "year" ).innerHTML += words[0];
      document.getElementById( "year" ).innerHTML += day;
      </script>
</body>
</html>