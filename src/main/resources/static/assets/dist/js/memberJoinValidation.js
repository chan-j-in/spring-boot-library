document.addEventListener('DOMContentLoaded', function() {
    registerBtnClickEvent();
});

// callAjax 함수 추가
function callAjax(url, method, dataType, async, data, callback) {
    $.ajax({
        url: url,
        type: method,
        dataType: dataType,
        async: async,
        data: data,
        success: function(response) {
            callback(response);
        },
        error: function(request, status, error) {
            console.log("Error: " + error);
            alert("서버 오류가 발생했습니다.");
        }
    });
}

// 버튼 클릭 이벤트 등록
function registerBtnClickEvent() {
    document.getElementById('btnEmailCheck').addEventListener('click', function() {
        fEmailCheck();
    });

    document.getElementById('btnNicknameCheck').addEventListener('click', function() {
        fNicknameCheck();
    });

    document.getElementById('btnSingUp').addEventListener('click', function() {
        fSingUp();
    });
}

// 이메일 중복 체크
function fEmailCheck() {
    let email = document.getElementById('email').value;

    if (email === '') {
        alert('이메일을 입력해 주세요.');
        return;
    }

    // AJAX 요청 (이메일 중복 확인)
    callAjax('/getEmail', 'POST', 'text', true, { email: email }, function(response) {

        let emailCheckElem = document.getElementById('id-check');
        emailCheckElem.style.display = 'block'; // 메시지가 새로운 줄에 표시되도록 설정

        // 서버 응답 처리
        if (response === '0') {
            document.getElementById('id-check').innerText = '사용 가능한 이메일입니다.';
        } else {
            document.getElementById('id-check').innerText = '이미 사용중인 이메일입니다.';
        }
    });
}

// 닉네임 중복 체크
function fNicknameCheck() {
    let nickname = document.getElementById('nickname').value;

    if (nickname === '') {
        alert('닉네임을 입력해 주세요.');
        return;
    }


    // AJAX 요청 (닉네임 중복 확인)
    callAjax('/getNickname', 'POST', 'json', true, { nickname: nickname }, function(response) {

        let nicknameCheckElem = document.getElementById('nickname-check');
        nicknameCheckElem.style.display = 'block'; // 메시지가 새로운 줄에 표시되도록 설정

        // 서버 응답 처리
        if (response.result === 0) {
            document.getElementById('nickname-check').innerText = '사용 가능한 닉네임입니다.';
        } else {
            document.getElementById('nickname-check').innerText = '이미 사용중인 닉네임입니다.';
        }
    });
}

// 회원 가입 제출
function fSingUp() {
    // 회원 가입 로직 추가
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;
    let passwordConfirm = document.getElementById('passwordConfirm').value;

    if (password !== passwordConfirm) {
        alert("비밀번호가 일치하지 않습니다.");
        return;
    }

    document.join_form.submit();
}