<%@ page import="org.example.boardservlet.vo.UserVO" %>
<%@ page import="org.example.boardservlet.vo.BoardVO" %>
<%@ page import="java.util.List" %>
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
<form action="http://localhost:8080/boardservlet/keyword" method="post">
    <input name="keyword" type="text">
    <input type="submit" value="검색">
</form>
<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>댓글 수</th>
        <th>좋아요 수</th>
        <th>조회수</th>
    </tr>
    <% if (boardList != null && !boardList.isEmpty()) { %>
    <% for (BoardVO board : boardList) { %>
    <tr>
        <td><%= board.getBoardId() %></td>
        <td><a href="boarddetail.jsp?board_id=<%= board.getBoardId() %>"><%= board.getTitle() %></a></td>
        <td><%= board.getWriter() %></td>
        <td><%= board.getCreatedAt() %></td>
        <td><%= board.getCommentCount() %></td>
        <td><%= board.getLikeCount() %></td>
        <td><%= board.getViews() %></td>
    </tr>
    <% } %>
    <% } else { %>
    <tr>
        <td colspan="7" class="no-boards">게시글이 없습니다.</td>
    </tr>
    <% } %>
</table>
<form action="create.jsp" method="get">
    <button type="submit">게시글 작성</button>
</form>
</body>
</html>
