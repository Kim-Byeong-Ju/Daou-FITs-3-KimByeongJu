function searchBtn() {
    // 날짜를 가져와서..
    // AJAX 호출하면 되요!
    $.ajax({
        async: true,
        url: 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
        type: 'GET',
        timeout: 3000, // 천분의1초단위로 초를 적어요.
        data: {
            key: 'a0d71c21e885c9d16e29f731f4d779ce',
            targetDt: ($('[type=date]').val()).replace(/-/g,'')   // YYYYMMDD 형식으로 변경!
        },
        dataType: 'json',   // default값이 json이라서 안써도 되요!
        success : function(data) {
             $('tbody').empty();
            // 성공하면 당연히 서버는 결과값을 JSON 문자열로 전달해요!
            // 그러면 이 문자열을 받아서 문자열을 분석해서 결과처리를 해야 해요!
            // 이 JSON 문자열 처리가 쉽지 않아요,. -> 이걸 객체로 변경해서 우리한테
            // 함수의 인자로 전달해줘요!
            // 이 JSON을 분석해야 해요!
            let arr = data.boxOfficeResult.dailyBoxOfficeList;
            // 배열안의 각 요소에 대해서 함수를 호출(callback)해요!
            $.each(arr, function(idx,item) {
                // idx : 반복할때마다 숫자가 증가하는 index
                // item : 반복할때마다 추출되는 배열안에 있는 원소
                // console.log(item.movieNm);
                // 데이터를 정상적으로 가져올 수 있으면 이제 이걸 가지고 화면처리하면
                // 되요!
                // 태그를 만들어 보아요!
                // <tr>
                //     <td>1,001</td>
                //     <td><img src="~~~"></td>
                //     <td>data</td>
                //     <td>placeholder</td>
                //     <td>text</td>
                //     <td><button class="btn btn-danger">삭제</button></td>
                // </tr>
                let tr = $("<tr></tr>");   // <tr></tr>
                let ranktd = $("<td></td>").text(item.rank);  // <td>1</td>
                let postertd = $("<td></td>");
                let posterImg = $('<img />');
                postertd.append(posterImg);

                // 이미지를 가져오기 위한 AJAX를 호출해야 해요!
                $.ajax({
                    async: true,
                    url: 'https://dapi.kakao.com/v2/search/image',
                    type: 'GET',
                    data: {
                        query: item.movieNm + ' 포스터'
                    },
                    headers: {
                        Authorization: 'KakaoAK 1358282d53c290fdf77018c900369905'
                    },
                    success: function(data) {
                        let imgurl = data.documents[0].thumbnail_url;
                        // 클로저의 특성을 이용해서 posterImg의 링크를 유지하고 있어요
                        posterImg.attr('src', imgurl);
                    },
                    error: function() {
                        alert('이미지 검색 실패!')
                    }
                });

                let titletd = $("<td></td>").text(item.movieNm);
                let audtd = $("<td></td>").text(item.audiCnt);
                let opentd = $("<td></td>").text(item.openDt);
                let deltd = $("<td></td>");
                let delBtn = $("<button></button>").text('삭제').addClass('btn btn-danger')
                deltd.append(delBtn);
                // 삭제버튼에 클릭 이벤트에 대한 이벤트 핸들러를 등록해줘요!
                delBtn.click(function() {
                    // jQuery event 처리방식에서 이벤트 핸들러에 this가 등장하면
                    // 이 this는 event source 문서객체를 지칭해요!
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
            alert('먼가 이상해요!')
        }
    });

    // 그런데 지금 클릭한게..<a>예요!
    // <a>는 default event를 가지고 있어요!
    // 그래서 default event를 막아줘야 해요!
    event.preventDefault();
}