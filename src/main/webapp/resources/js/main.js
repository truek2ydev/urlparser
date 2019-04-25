var Main = (function(){
    var MESSAGE = {
        REQUIRED_URL: "URL을 입력하여 주십시요!",
        REQUIRED_GROUPSIZE: "출력묶음단위를 입력하여 주십시요!",
        INVALID_URL:"URL을 바르게 입력하여 주십시요!",
        INVALID_GROUPSIZE: "출력묶음단위를 자연수로 입력하여 주십시요!"
    }

    function _initialize(){
        _initEvent();
    }

    function _initEvent(){
        $('#btn_output').on('click', function(){
            if(_formValidate()){
                _onClickBtn();
            };
        });

        $('#btn_reset').on('click', function(){
            _formInit();
        });
    }

    function _formInit(){
        $('#url').val('');
        $('#tagIncludeType option:eq(0)').prop("selected", true);
        $('#groupSize').val('');
        $('#result').text('');
        $('#remainder').text('');
    }

    function _formValidate(){

        var eUrl = $('#url');
        var eGroupSize = $('#groupSize');

        // check empty
        if( $.trim(eUrl.val()) == ''){
            alert(MESSAGE.REQUIRED_URL);
            eUrl.focus();
            return false;
        }

        if( $.trim(eGroupSize.val()) == ''){
            alert(MESSAGE.REQUIRED_GROUPSIZE);
            eGroupSize.focus();
            return false;
        }

        // check url - server check
        // var urlExp = /^((https?):\/\/).*$/;
        // if (!urlExp.test(eUrl.val())) {
        //     alert(MESSAGE.INVALID_URL);
        //     eUrl.focus();
        //     return false;
        // }

        // check number
        var numExp = /^[0-9]+$/;
        if (!numExp.test(eGroupSize.val()) && eGroupSize.val() > 0 ) {
            alert(MESSAGE.INVALID_GROUPSIZE);
            eGroupSize.focus();
            return false;
        }

        return true;
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
                alert(xhr.responseText);
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
