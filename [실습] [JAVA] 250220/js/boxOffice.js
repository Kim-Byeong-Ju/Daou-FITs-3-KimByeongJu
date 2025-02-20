function myFunc() {
    // 버튼 클릭하면 실행

    // jQuery로 AJAX 호출 실행
    $.ajax({
        async: true, // 비동기 or 동기. 기본 값은 비동기 방식
        url:'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
        type: 'GET',
        data: {
            key: 'a0d71c21e885c9d16e29f731f4d779ce',
            targetDt: '20250218'
        },
        dataType: 'json',
        success: function (result) {
            // result라는 매개변수로 서버가 보내준
            // JSON 문자열을 객체로 변환시킨 객체가 매핑됨
            $('h1').text(result.boxOfficeResult.dailyBoxOfficeList[0].movieNm)
        },
        error: function () {
            alert("호출 실패")
        }
    })
}
