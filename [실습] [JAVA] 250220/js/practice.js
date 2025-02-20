function searchMovie() {
    $.ajax({
        async: true,
        url: 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
        type: 'GET',
        data: {
            key: 'a0d71c21e885c9d16e29f731f4d779ce',
            targetDt: ($('[type=date]').val()).replace(/-/g,'')   // YYYYMMDD 형식으로 변경!
        },
        success: function (data) {
            $('tbody').empty();
            let arr = data.boxOfficeResult.dailyBoxOfficeList;
            $.each(arr, function (idx,item) {
                let tr = $("<tr></tr>");   // <tr></tr>
                let ranktd = $("<td></td>").text(item.rank);  // <td>1</td>
                let postertd = $("<td></td>");
                let posterImg = $('<img />');
                postertd.append(posterImg);

                $.ajax({
                    async: true,
                    url: 'https://dapi.kakao.com/v2/search/image',
                    type: 'GET',
                    data: {
                        query: item.movieNm + ' 포스터'
                    },
                    headers: {
                        Authorization: 'KakaoAK 0cc3b93e3db72ef3e3580570910d6f72'
                    },
                    success: function(data) {
                        let imgurl = data.documents[0].thumbnail_url;
                        // 클로저의 특성을 이용해서 posterImg의 링크를 유지하고 있어요
                        posterImg.attr('src', imgurl);
                    },
                    error: function() {
                        alert('이미지 검색 실패!')
                    }});
                let titletd = $("<td></td>").text(item.movieNm);
                let audtd = $("<td></td>").text(item.audiCnt);
                let opentd = $("<td></td>").text(item.openDt);
                let deltd = $("<td></td>");
                let delBtn = $("<button></button>").text('삭제').addClass('btn btn-danger')
                deltd.append(delBtn);
                delBtn.click(function() {
                    $(this).parent().parent().remove();
                })
                tr.append(ranktd);
                tr.append(postertd);
                tr.append(titletd);
                tr.append(audtd);
                tr.append(opentd);
                tr.append(deltd);
                $('tbody').append(tr);
            })
        },
        error: function() {
            alert("영화 정보를 불러올 수 없습니다")
        }
    })
}


// function searchMovie() {
//     $.ajax({
//         async: true,
//         url: 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
//         type: "GET",
//         data: {
//             key: 'a0d71c21e885c9d16e29f731f4d779ce',
//             targetDt: ($('[type=date]').val()).replace(/-/g,''),
//         },
//         dataType: "json",
//         success : function(data) {
//             $('tbody').empty();
//             let movies = data.boxOfficeResult.dailyBoxOfficeList;
//             $.each(movies, function(index, item) {
//                 let tr = $('<tr></tr>');
//                 let rankTd = $('<td></td>').text(item.rank);
//                 let imgTd = $('<td></td>');
//                 let imgTag = $('<img />');
//                 imgTd.append(imgTag)
//                 $.ajax({
//                     async: true,
//                     url: 'https://dapi.kakao.com/v2/search/image',
//                     method: "GET",
//                     data: {
//                         query: item.movieNm + ' 포스터'
//                     },
//                     headers: {
//                         Authorization: 'KakaoAK 0cc3b93e3db72ef3e3580570910d6f72'
//                     },
//                     success : function(data) {
//                         console.log(data);
//                         let imgUrl = data.documents[0].thumbnail_url
//                         imgTag.attr('src', imgUrl)
//
//                     },
//                     error : function(data) {
//                         alert('이미지를 가져오지 못했습니다')
//                     }
//                 })
//                 let titleTd = $('<td></td>').text(item.movieNm);
//                 let audiTd = $('<td></td>').text(item.audiAcc);
//                 let openTd = $('<td></td>').text(item.openDt);
//                 let delTd = $('<td></td>');
//                 let delBtn = $("<button></button>").text('삭제').addClass('btn btn-danger');
//                 delTd.append(delBtn);
//                 delBtn.click(function(){
//                     $(this).parent().parent().remove();
//                 })
//                 tr.append(rankTd);
//                 tr.append(imgTd);
//                 tr.append(titleTd);
//                 tr.append(audiTd);
//                 tr.append(openTd);
//                 tr.append(delTd);
//                 $('tbody').append(tr);
//             })
//         }
//     })
// }