<%@ page import="org.example.boardservlet.vo.BoardVO" %>
<%@ page import="org.example.boardservlet.service.BoardService" %>
<%@ page import="org.example.boardservlet.vo.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 상세보기</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f4f8;
            color: #333;
        }
        h1 {
            text-align: center;
            color: #2e3d49;
            font-size: 2.5rem;
            margin-bottom: 1rem;
        }
        .board-details {
            background-color: #fff;
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            margin: 20px auto;
            max-width: 850px;
            border-left: 5px solid #6c757d; /* Accent border */
        }
        .board-details p {
            font-size: 1.1rem;
            line-height: 1.8;
            margin: 0.5rem 0;
        }
        .board-details strong {
            font-weight: bold;
            color: #495057;
        }
        .action-buttons {
            text-align: center;
            margin-top: 2rem;
        }
        .action-buttons a,
        .action-buttons button {
            margin: 0.5rem;
            padding: 0.75rem 1.5rem;
            font-size: 1rem;
            background-color: #6c757d;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: all 0.3s ease;
        }
        .action-buttons a:hover,
        .action-buttons button:hover {
            background-color: #495057;
        }
        .back-link {
            display: block;
            text-align: center;
            padding: 5px;
            margin-top: 3rem;
            font-size: 1.2rem;
            color: #007bff;
            text-decoration: none;
            transition: color 0.3s ease;
        }
        .back-link:hover {
            color: #0056b3;
            text-decoration: underline;
        }
        .like-button {
            display: inline-flex;
            align-items: center;
            justify-content: center;
            padding: 0.5rem 1rem;
            font-size: 1rem;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .like-button:hover {
            background-color: #0056b3;
        }
        .liked {
            background-color: #dc3545; /* Red for liked state */
        }
        textarea {
            width: 100%;
            padding: 0.75rem;
            font-size: 1rem;
            border-radius: 5px;
            border: 1px solid #ced4da;
            margin-bottom: 1rem;
            resize: none;
            background-color: #f8f9fa;
            color: #495057;
        }
        button[type="submit"] {
            background-color: #28a745;
            color: white;
            padding: 0.75rem 1.5rem;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button[type="submit"]:hover {
            background-color: #218838;
        }
        .comment-section {
            background-color: #fff;
            padding: 1.5rem;
            margin-top: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
        }
        .comment {
            padding: 1rem;
            border-bottom: 1px solid #ececec;
        }
        .comment:last-child {
            border-bottom: none;
        }
        .comment p {
            margin: 0.5rem 0;
        }
        .comment p strong {
            font-weight: bold;
            color: #6c757d;
        }
        .comment-container {
            margin: 20px auto;  /* 위와 아래로 20px, 좌우는 자동으로 중앙 정렬 */
            max-width: 800px;    /* 최대 너비를 설정 */
            padding: 1rem;       /* 안쪽 여백 추가 */
            background-color: #fff; /* 배경색을 흰색으로 설정 */
            border-radius: 8px;  /* 둥근 모서리 */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);  /* 그림자 */
        }

    </style>
</head>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="js/board.js"></script>
<script src="js/comment.js"></script>
<script>

</script>
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
    // Get the userId from the session
    HttpSession sessionObj = request.getSession(false);
    UserVO user = (UserVO)sessionObj.getAttribute("user");
%>

<div id="boardDetails" class="board-details">

</div>
<div class="action-buttons">

<%
    if (user.getUserId() != null && user.getUserId().equals(board.getUserId())) {
%>
    <a href="edit.jsp?boardId=<%= board.getBoardId() %>">수정</a>
    <button type="button" onclick="deleteBoard(<%=board.getBoardId()%>)">삭제</button>
<%
    } else {
%>
    <button id="likeButton" onclick="toggleLike(<%=board.getBoardId()%>, '<%=user.getUserId()%>')"></button>
<%
    }
%>
</div>

<div class="comment-container">

<h3>댓글</h3>
<div id="commentSection">
</div>

    <form onsubmit="event.preventDefault(); insertComment('<%= board.getBoardId() %>', '<%= user.getUserId() %>', document.getElementById('content').value); document.getElementById('content').value='';">
        <textarea id="content" name="content" rows="2" required></textarea><br>
        <button type="submit">등록</button>
    </form>
</div>

<a href="board" class="back-link">목록으로 돌아가기</a>

<script>
// 페이지 로드 시 좋아요 여부 확인
window.onload = function() {
    const boardId = '<%= board.getBoardId() %>';  // 숫자형 변수는 따옴표 없이 삽입
    const userId = '<%= user.getUserId() %>';  // 문자열 변수는 따옴표로 감싸서 삽입

    // checkLike 함수 호출 후, 콜백을 사용하여 좋아요 여부 처리
    if (userId != '<%= board.getUserId() %>') {
    checkLike(boardId, userId)
        .then(data => {
            if (data && data.isLiked) {
                const likeButton = document.getElementById("likeButton");
                likeButton.classList.add("liked");
                likeButton.textContent = "좋아요 취소";  // 이미 좋아요 눌렀을 경우
            } else if (data && !data.isLiked) {
                const likeButton = document.getElementById("likeButton");
                likeButton.classList.remove("liked");
                likeButton.textContent = "좋아요";
            }
        })
        .catch(error => {
            console.error('좋아요 상태 확인 실패:', error);
        });
    }
    // 페이지 로드 시 댓글 목록 불러오기
    getCommentList(boardId, userId);
    getBoardById(boardId);
    updateBoardViews(boardId);
};

</script>
</body>
</html>