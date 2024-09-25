<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en" data-bs-theme="auto">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>회원가입</title>
    <link href="assets/dist/css/sign-in.css" rel="stylesheet">
    <jsp:include page="../includes/common_includes.jsp"></jsp:include>
    <script type="text/javascript" src="assets/dist/commonAjax.js"></script>
    <script type="text/javascript" src="assets/dist/js/memberJoinValidation.js"></script>
    <style>
        /* 스타일 설정 ... */
    </style>
</head>
<body class="text-center">
<main class="form-signin w-100 m-auto">
    <form name="join_form" action="/join" method="post">
        <img class="mb-4" src="assets/brand/bootstrap-logo.svg" alt="" width="72" height="57" onclick="location.href='/'">
        <h1 class="h3 mb-3 fw-normal">Please join in</h1>

        <!-- 이메일 필드 -->
        <div class="form-floating">
            <input type="email" class="form-control" name="email" id="email" placeholder="name@example.com" required>
            <label for="email">Email address</label>
            <button class="btn btn-light rounded-pill px-3" type="button" name="btn" id="btnEmailCheck">Duplicate check</button>
            <span id="id-check"></span>
        </div>

        <!-- 비밀번호 필드 -->
        <div class="form-floating">
            <input type="password" class="form-control" name="password" id="password" placeholder="Password" autoComplete="off" required>
            <label for="password">Password</label>
        </div>

        <!-- 비밀번호 확인 필드 -->
        <div class="form-floating">
            <input type="password" class="form-control" name="passwordConfirm" id="passwordConfirm" placeholder="passwordConfirm" autoComplete="off" required>
            <label for="passwordConfirm">Confirm Password</label>
        </div>

        <!-- 이름 필드 -->
        <div class="form-floating">
            <input type="text" class="form-control" name="name" id="name" placeholder="Name" required>
            <label for="name">Name</label>
        </div>

        <!-- 닉네임 필드 -->
        <div class="form-floating">
            <input type="text" class="form-control" name="nickname" id="nickname" placeholder="Nickname" required>
            <label for="nickname">Nickname</label>
            <button class="btn btn-light rounded-pill px-3" type="button" name="btn" id="btnNicknameCheck">Duplicate check</button>
            <span id="nickname-check"></span>
        </div>

        <!-- 성별 선택 -->
        <div class="form-floating">
            <div class="form-check">
                <input id="men" name="mfCode" value="M" type="radio" class="form-check-input" checked>
                <label class="form-check-label" for="men">Men</label>
            </div>
            <div class="form-check">
                <input id="female" name="mfCode" value="F" type="radio" class="form-check-input">
                <label class="form-check-label" for="female">Female</label>
            </div>
        </div>

        <!-- 전화번호 필드 -->
        <div class="form-floating">
            <input type="text" class="form-control" name="cellNo" id="cellNo" placeholder="Cell No." required>
            <label for="cellNo">Cell No.</label>
        </div>

        <!-- 오류 메시지 출력 -->
        <c:if test="${not empty errorMessage}">
            <div style="color: red;">
                <p>${errorMessage}</p>
            </div>
        </c:if>

        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="w-50 btn btn-lg btn-dark" type="button" onclick="history.back();">이전페이지로가기</button>
        <button class="w-50 btn btn-lg btn-primary" type="submit" name="btn" id="btnSingUp">Sign up</button>
    </form>
</main>
</body>
</html>