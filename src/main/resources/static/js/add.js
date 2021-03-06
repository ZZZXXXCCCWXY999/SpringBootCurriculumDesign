/*!
 * blogedit.html 页面脚本.
 *
 * @since: 1.0.0 2017-03-26
 * @author
 */
"use strict";
// # sourceURL=blogedit.js

// DOM 加载完再执行
$(function() {



    // 发布博客
    $("#submitBlog").click(function() {
        //获取CSRF Token
        var csrfToken=$("meta[name='_csrf']").attr("content");
        var csrfHeader=$("meta[name='_csrf_header']").attr("content");
        $.ajax({
            url : '/u/' + $(this).attr("userName") + '/blogs/edit',
            type : 'POST',
            contentType : "application/json; charset=utf-8",
            data : JSON.stringify({
                "id" : Number($('#blogId').val()),
                "title" : $('#title').val(),
                "summary" : $('#summary').val(),
                "content" : $('#md').val(),
                "catalog" : {
                    "id" : $('#catalogSelect').val()
                },
                "tags" : $('.form-control-tag').val()
            }),
            beforeSend:function(request){
                request.setRequestHeader(csrfHeader,csrfToken);//添加CSRF Token
            },
            success : function(data) {
                if (data.success) {
                    // 成功后，重定向
                    window.location = data.body;
                } else {
                    toastr.error("标题,摘要,内容不能为空,且至少是2个字符");
                }

            },
            error : function() {
                toastr.error("error!");
            }
        })
    })

});