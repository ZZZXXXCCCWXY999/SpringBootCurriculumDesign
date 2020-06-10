/*!
 * Bolg main JS.
*
* @since: 1.0.0 2017/3/9
* @author Way Lau <https://waylau.com>
*/
"use strict";
//# sourceURL=main.js

// DOM 加载完再执行
$(function() {

    var _pageSize; // 存储用于搜索

    // 删除用户
    $("#delete").on("click", function () {
        alert("我是一个警告框！");
        //获取CSRF Token
        var csrfToken=$("meta[name='_csrf']").attr("content");
        var csrfHeader=$("meta[name='_csrf_header']").attr("content");

        $.ajax({
            url: "/users/" + $(this).attr("id") ,
            type: 'DELETE',
            beforeSend:function(request){
                request.setRequestHeader(csrfHeader,csrfToken);//添加CSRF Token
            },
            success: function(data){
                if (data.success) {
                    toast.success("删除成功，请手动刷新页面")
                } else {
                    toastr.error(data.message);
                }
            },
            error : function() {
                toastr.error("error!");
            }
        });
    });
});