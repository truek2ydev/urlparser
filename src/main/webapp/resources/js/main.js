var Main = (function(){

    function _initialize(){
        _initEvent();
    }

    function _initEvent(){
        $('#btn_output').on('click', function(){
            _formValidate();
            _onClickBtn();
        });
    }

    function _formValidate(){

    }

    function _onClickBtn(){

        var uri = "/api/url/parser?" +
            "url=" + encodeURI($('#url').val()) + "&" +
            "tagIncludeType=" + $('#tagIncludeType').val() + "&" +
            "groupSize=" + $('#groupSize').val() ;

        $.ajax( {
            url: uri,
            type: "get",
            success : function(res){
                _showResult(res);
            },
            error: function(xhr, status, error) {
                alert(error);
            }
        });
    }

    function _showResult(res){
        $('#result').text(res.group);
        $('#remainder').text(res.remainder);
    }

    return {
        initialize: _initialize
    }
})(jQuery);
