<%@ page import="org.example.servletloginboard.vo.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 작성</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 20px auto;
            max-width: 600px;
        }
        label {
            font-size: 16px;
            margin-bottom: 5px;
            display: block;
            color: #333;
        }
        input[type="text"], textarea {
            width: 100%;
            padding: 10px;
            margin: 10px 0 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            width: 100%;
        }
        button:hover {
            background-color: #45a049;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            font-size: 16px;
            color: #007BFF;
            text-decoration: none;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<%
    HttpSession sessionObj = request.getSession(false);
    UserVO user = (UserVO) sessionObj.getAttribute("user");
%>

<h1>게시글 작성</h1>
<form action="http://localhost:8080/servletlogin/board" method="post">
    <label for="title">제목:</label>
    <input type="text" id="title" name="title" required><br>

    <label for="content">내용:</label><br>
    <textarea id="content" name="content" rows="5" required></textarea><br>

    <input type="hidden" name="userId" value="<%= user.getId() %>">

    <button type="submit">등록</button>
</form>

<a href="board.jsp" class="back-link">목록으로 돌아가기</a>
</body>
</html>
