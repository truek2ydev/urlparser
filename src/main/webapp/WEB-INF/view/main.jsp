<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="ko">--%>
<html>
<head>
  <title>Url Parser</title>
  <link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" />
</head>
<body>
<div class="container"><br/>
  <div class="alert alert-success">
    <a href="#" class="close" data-dismiss="alert"
       aria-label="close">×</a>
    <strong>Success!</strong> It is working as we expected.
  </div>
</div>

<div class="container"><br/>
<form name="form">
  <div class="input-group">
    <span class="input-group-addon" id="url-form">URL:</span>
    <input type="text" id="url" class="form-control" placeholder="URL" aria-describedby="url-form">
  </div>

  <br/>

  <div class="input-group">
    <span class="input-group-addon" id="type-form">Type :</span>
    <select id="tagIncludeType" >
      <option value="INCLUDE">HTML태그제외</option>
      <option value="EXCLUDE">Text전체</option>
    </select>
  </div>

  <br/>

  <div class="input-group">
    <span class="input-group-addon" id="groupSize-form" >출력묶음단위:</span>
    <input type="text" id="groupSize" class="form-control" placeholder="자연수" aria-describedby="groupSize-form">
  </div>
  <br/>
  <div>
  <br/>
  <a class="btn btn-primary " href="#" role="button" id="btn_output">출력</a>
  </div>
</form>
</div>
<br/>

<div class="container"><br/>

  <div class="input-group">
    <span class="input-group-addon" id="result-form"  >몱:</span>
    <textarea id="result"  rows="10" cols="100" ></textarea>
  </div>

  <br/>

<%--<div>--%>
<%--  <label for="groupSize">몱:</label>--%>
<%--&lt;%&ndash;  <input type="text" id="result" />&ndash;%&gt;--%>
<%--  <textarea id="result"  rows="10" cols="100" ></textarea>--%>
<%--</div>--%>

  <div class="input-group">
    <span class="input-group-addon" id="remainder-form" >나머지:</span>
    <textarea id="remainder"  rows="5" cols="100" ></textarea>
  </div>

</div>

<%--<div>--%>
<%--  <label for="remainder">나머지:</label>--%>
<%--&lt;%&ndash;  <input type="text" id="remainder" />&ndash;%&gt;--%>
<%--  <textarea id="remainder"  rows="10" cols="100" ></textarea>--%>
<%--</div>--%>


<script src="/webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/main.js"></script>
<script type="text/javascript">
    //<![CDATA[
    $(document).ready(function () {
      Main.initialize();
    });
    //]]>
</script>
</body>
</html>