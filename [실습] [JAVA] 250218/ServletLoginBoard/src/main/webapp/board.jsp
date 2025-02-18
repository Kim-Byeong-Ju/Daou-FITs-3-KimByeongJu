<%@ page import="org.example.servletloginboard.vo.UserVO" %>
<%@ page import="org.example.servletloginboard.vo.BoardVO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 25. 2. 18.
  Time: 오후 3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1, h2 {
            text-align: center;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ccc;
        }
        th {
            background-color: #f2f2f2;
        }
        .no-boards {
            text-align: center;
            color: #999;
        }
        form {
            text-align: center;
            margin-top: 20px;
        }
        button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<%
    HttpSession sessionObj = request.getSession(false);
    UserVO user = (UserVO)sessionObj.getAttribute("user");
    List<BoardVO> boardList = (List<BoardVO>) request.getAttribute("boardList");
%>
<body>
<h1><%= user.getName() %>님 환영합니다!</h1>
<h2>게시판 목록</h2>
<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>내용</th>
    </tr>
    <% if (boardList != null && !boardList.isEmpty()) { %>
    <% for (BoardVO board : boardList) { %>
    <tr>
        <td><%= board.getBoardId() %></td>
        <td><a href="boarddetail.jsp?board_id=<%= board.getBoardId() %>"><%= board.getTitle() %></a></td>
        <td><%= board.getContent() %></td>
    </tr>
    <% } %>
    <% } else { %>
    <tr>
        <td colspan="3" class="no-boards">게시글이 없습니다.</td>
    </tr>
    <% } %>
</table>
<form action="write.jsp" method="get">
    <button type="submit">게시글 작성</button>
</form>
</body>
</html>
