<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Url Parser</title>
  <link rel="stylesheet" href="/webjars/bootstrap/3.4.1/css/bootstrap.min.css" />
</head>
<body>
<div class="container theme-showcase" role="main">
  <div class="page-header">
    <h3>URL Parser</h3>
  </div>
  <div class="row">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">Input</h3>
      </div>
      <div class="panel-body">

        <form name="form">
          <div class="form-group row">
            <label for="url" class="col-sm-2 col-form-label">URL</label>
            <div class="col-sm-10">
              <input type="text" id="url" class="form-control" placeholder="URL">
              <small id="urlHelpBlock" class="form-text text-muted">
                http, https를 포함한 전체 URL을 입력해주세요!
              </small>
            </div>
          </div>
          <div class="form-group row">
            <label for="tagIncludeType" class="col-sm-2 col-form-label">Type</label>
            <div class="col-sm-10">
              <select id="tagIncludeType"  class="form-control">
                <option value="EXCLUDE">HTML태그제외</option>
                <option value="INCLUDE">Text전체</option>
              </select>
            </div>
          </div>
          <div class="form-group row">
            <label for="groupSize" class="col-sm-2 col-form-label">출력묶음단위</label>
            <div class="col-sm-10">
              <input type="text" id="groupSize" class="form-control" placeholder="자연수">
              <small id="groupSizeHelpBlock" class="form-text text-muted">
                1이상의 자연수로 입력하여 주세요!
              </small>
            </div>

          </div>
          <div align="right" style="width: 100%">
          <a class="btn btn-primary" href="#" role="button" id="btn_output">출력</a>
          <a class="btn btn-default" href="#" role="button" id="btn_reset">초기화</a>
          </div>
        </form>
    </div>
  </div>
</div>

<br/>

  <div class="row">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">Output</h3>
      </div>
      <div class="panel-body">

        <div class="form-group row">
          <label for="result" class="col-sm-2 col-form-label">몱</label>
          <div class="col-sm-10">
            <textarea id="result"  class="form-control" rows="5" cols="100" ></textarea>
          </div>
        </div>

        <div class="form-group row">
          <label for="remainder" class="col-sm-2 col-form-label">나머지</label>
          <div class="col-sm-10">
            <textarea id="remainder"  class="form-control"  rows="3" cols="100" ></textarea>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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