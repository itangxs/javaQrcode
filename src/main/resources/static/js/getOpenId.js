//init method one
$(document).ready(function(){
    //trace("初始化方法进入");
});
function trace(obj) {
    console.log(obj);
    $.ajax({
        url: "/getCode.do",
        type: "POST",
        withCredentials :"",
        success: function(result) {
            console.log(result);
            window.location.href = result.redirect;
        }
    });
}