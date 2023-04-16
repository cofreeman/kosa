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
            color: blue;
        }
    </style>
</head>
<body>
<%
    TimeVO timeVO = (TimeVO) request.getAttribute("time");
%>
<text><%= timeVO.getHour()%>시<%= timeVO.getMinute()%>분에 당첨!! 추카추카</text>
<br>
<br>
<img src="images/halabong.jpg" width="30px" height="30px">
<br>
성공하셨으니 한라봉를 드리겠습니다.
<br>
</body>
</html>