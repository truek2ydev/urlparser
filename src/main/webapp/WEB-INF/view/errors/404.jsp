<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>Url Parser</title>
    <%--<link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" />--%>
    <link rel="stylesheet" href="/webjars/bootstrap/3.4.1/css/bootstrap.min.css" />
</head>
<body>
<div class="container theme-showcase" role="main">
    <div class="page-header">
        <h1>Error Page</h1>
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Message</h3>
            </div>
            <div class="panel-body" align="center">
                <h4>요청하신 페이지가 존재하지 않습니다!</h4>
                <%--<a href="/">메인페이지</a>--%>
                <br/>
                <a class="btn btn-primary " href="/" role="button" id="btn_main">메인페이지</a>
            </div>
        </div>
    </div>
</div>

<script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>