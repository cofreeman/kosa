<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="model.domain.TimeVO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
         text{
             color: #FF0066;
         }
    </style>
</head>
<body>
<%
    TimeVO timeVO = (TimeVO) request.getAttribute("time");
%>
<text><%= timeVO.getHour()%>시<%= timeVO.getMinute()%>분에 당첨 실패!! 아쉽아쉽</text>
<br>
<br>
<img src="images/banana.jpg" width="30px" height="30px">
<br>
아쉬우니 바나나를 드리겠습니다.
<br>
<a href='<%= request.getHeader("referer") %>' style='text-decoration:none'>로또 응모 링크</a>
</body>
</html>