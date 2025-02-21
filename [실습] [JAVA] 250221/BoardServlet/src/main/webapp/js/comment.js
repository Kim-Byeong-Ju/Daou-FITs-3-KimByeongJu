
function insertComment(boardId, userId, content) {
    $.ajax({
        url: default_url + `board/comment`,
        type: 'POST',
        data: { boardId, userId, content },
        success: function() {
            getCommentList(boardId, userId); // 댓글 추가 후 최신 리스트 불러오기
            getBoardById(boardId)
        },
        error: function(error) {
            console.error('Error:', error);
        }
    });
}

function deleteComment(commentId, boardId) {
    $.ajax({
        url: default_url + `board/comment?commentId=${commentId}`,
        type: 'DELETE',
        success: function() {
            getCommentList(boardId); // 댓글 삭제 후 최신 리스트 불러오기
            getBoardById(boardId)
        },
        error: function(error) {
            console.error('Error:', error);
        }
    });
}

function getCommentList(boardId, userId) {
    $.ajax({
        url: default_url + `board/comment?boardId=${boardId}`,
        type: 'GET',
        success: function(response) {
            renderComments(response.commentList, userId); // 화면 갱신
        },
        error: function(error) {
            console.error('Error:', error);
        }
    });
}
function renderComments(commentList, userId) {
    const commentSection = document.getElementById("commentSection");
    commentSection.innerHTML = ''; // 기존 댓글 삭제

    if (commentList.length === 0) {
        commentSection.innerHTML = '<p>댓글이 없습니다.</p>';
        return;
    }

    commentList.forEach(comment => {
        const commentDiv = document.createElement("div");
        commentDiv.style.display = "flex";
        commentDiv.style.justifyContent = "space-around";  // 내용과 버튼 사이에 공간을 배분
        commentDiv.style.alignItems = "center";  // 세로로 가운데 정렬

        commentDiv.innerHTML = `
        <p style="flex-grow: 1; margin: 3px;"><strong>${comment.userId}</strong>: ${comment.content}</p>
        ${comment.userId === userId ? `<button onclick="deleteComment(${comment.commentId}, ${comment.boardId})">삭제</button>` : ''}
         <hr>`;
        commentSection.appendChild(commentDiv);
    });

}