<%@ page import="org.example.servletloginboard.vo.BoardVO" %>
<%@ page import="org.example.servletloginboard.service.BoardService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 상세보기</title>
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
        .board-details {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 20px auto;
            max-width: 800px;
        }
        .board-details p {
            font-size: 16px;
            line-height: 1.6;
        }
        .board-details strong {
            color: #333;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            font-size: 18px;
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
    String boardIdParam = request.getParameter("board_id");
    if (boardIdParam == null || boardIdParam.isEmpty()) {
        response.sendRedirect("board");
        return;
    }

    int boardId = Integer.parseInt(boardIdParam);
    BoardService boardService = new BoardService();
    BoardVO board = boardService.getBoardById(boardId);

    if (board == null) {
%>
<script>
    alert("존재하지 않는 게시글입니다.");
    window.location.href = "board";
</script>
<%
        return;
    }
%>

<div class="board-details">
    <h1>게시글 상세보기</h1>
    <p><strong>번호:</strong> <%= board.getBoardId() %></p>
    <p><strong>제목:</strong> <%= board.getTitle() %></p>
    <p><strong>내용:</strong></p>
    <p><%= board.getContent() %></p>
    <p><strong>작성자:</strong> <%= board.getUserId() %></p>
</div>

<a href="board" class="back-link">목록으로 돌아가기</a>
</body>
</html>
