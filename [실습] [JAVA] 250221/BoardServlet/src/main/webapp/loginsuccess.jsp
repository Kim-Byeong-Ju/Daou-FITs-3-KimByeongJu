<%@ page import="org.example.boardservlet.vo.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>메인 페이지</title>
<style>
    body {
        font-family: Arial, sans-serif;
        text-align: center;
        margin-top: 100px;
    }
    .button {
        background-color: #4CAF50; /* Green */
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 10px;
        cursor: pointer;
        border-radius: 5px;
    }
    .button:hover {
        background-color: #45a049;
    }
</style>
</head>
<%
    HttpSession sessionObj = request.getSession(false);
    UserVO user = (UserVO)sessionObj.getAttribute("user");
%>
<body>
<h1><%= user.getName() %>
    님 환영합니다!</h1>
<p>게시판에 방문하시겠습니까? 아니면 로그아웃하시겠습니까?</p>

<form action="http://localhost:8080/boardservlet/board" method="get">
    <input type="submit" class="button" value="게시판 보러 가기">
</form>
<a href="logout.jsp" class="button" style="background-color: #f44336;">로그아웃</a>
</body>
</html>