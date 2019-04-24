<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>WebJars Demo</title>
  <%--<link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" />--%>
</head>
<body>
<body>
<h1>JSP</h1>
<div class="container"><br/>
  <div class="alert alert-success">
    <a href="#" class="close" data-dismiss="alert"
       aria-label="close">×</a>
    <strong>Success!</strong> It is working as we expected.
  </div>
</div>

<!-- javascript -->
<script src="/webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="/resources/js/index.js"></script>
<script type="text/javascript">
    //<![CDATA[

    $(document).ready(function () {
        alert("aaa");

        hello();
        //select click ent
        // btnSelect();
    });
    //]]>
</script>
</body>
</html>