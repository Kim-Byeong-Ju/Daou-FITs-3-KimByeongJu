const default_url = 'http://localhost:8080/boardservlet/'

function getBoardById(boardId) {
    $.ajax({
        url: default_url + `boarddetail?boardId=` + boardId,
        type: 'GET',
        success: function(response) {
            console.log(response)
            renderBoard(response, boardId);
        },
        error: function(error) {
            console.error('Error:', error);
        }
    });
}

function renderBoard(response, boardId) {
    const boardDetails= document.getElementById('boardDetails');
    boardDetails.innerHTML = '';
    boardDetails.innerHTML = `
            <h1>${response.title}</h1>
            <p><strong>작성자 </strong> ${response.writer}</p>
            <p><strong>작성일자 </strong> ${response.createdAt}</p>
            <p><strong>좋아요 </strong> ${response.likeCount}</p>
            <p><strong>조회수 </strong> ${response.views}</p>
            
            <p>${response.content}</p>
        `;
}

function deleteBoard(boardId) {
    if (confirm("정말 삭제하시겠습니까?")) {
        $.ajax({
            url: default_url + 'board',
            method: 'DELETE',
            data: { boardId: boardId },
            success: function(response) {
                window.location.href = "board";  // 성공하면 이동
            },
            error: function(xhr, status, error) {
                console.error("삭제 실패:", error);
            }
        });
    }
}

function updateBoard(boardId) {
    const title = document.getElementById("title").value;
    const content = document.getElementById("content").value;

    $.ajax({
        url: default_url + 'board',
        method: 'PUT',
        data: {
            boardId: boardId,
            title: title,
            content: content
        },
        success: function(response) {
            alert("게시글이 수정되었습니다.");
            window.location.href = `boarddetail.jsp?board_id=${boardId}`;  // 수정 후 목록 페이지로 이동
        },
        error: function(xhr, status, error) {
            alert("게시글 수정에 실패했습니다.");
            console.error("Error:", error);
        }
    });
}

// 좋아요 상태 확인
function checkLike(boardId, userId) {
    return $.ajax({
        url: default_url + `board/like`,
        method: 'GET',
        data: { boardId: boardId, userId: userId },
        dataType: 'json',
        success: function(data) {
            return data;  // 받은 데이터를 반환
        },
        error: function(xhr, status, error) {
            console.error('Error:', error);
            return null;  // 에러 발생 시 null 반환
        }
    });
}

// 좋아요 추가 또는 삭제
function toggleLike(boardId, userId) {
    $.ajax({
        url: default_url + `board/like`,
        method: 'POST',
        data: { boardId: boardId, userId: userId },
        dataType: 'json',
        success: function(data) {
            const likeButton = document.getElementById("likeButton");
            if (data.isLiked) {
                likeButton.classList.add("liked");
                likeButton.textContent = '좋아요 취소';
            } else {
                likeButton.classList.remove("liked");
                likeButton.textContent = '좋아요';
            }
            getBoardById(boardId);
        },
        error: function(xhr, status, error) {
            console.error('Error:', error);
        }
    });
}

function updateBoardViews(boardId) {
    $.ajax({
        url: default_url + `board/views?boardId=` + boardId,
        type: 'PUT',
        success: function() {
            console.log('조회수 증가')
        },
        error: function(error) {
            console.error('Error:', error);
        }
    });
}