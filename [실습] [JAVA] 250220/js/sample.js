function myFunc() {
    $("h1").on("click", function() {
        // this의 원래 의미는 현재 사용되는 객체에 대한 reference
        // jQuery
        // 처리 코드 내에서 this의 의미는 다르다
        // 이벤트 소스에 대한 문서객체를 지칭할 때 this를 사용
        // 이 this를 jquery 객체로 변환해서 우리가 배운 method 이용
        alert($(this).text());
    })
}