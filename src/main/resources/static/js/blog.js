$("#commentpost-btn").click(function () {
   $.ajax({
       url: "/blog/addComment",
       dataType: "JSON",
       type: "POST",
       data:{
         comment: {
             parentCommentId: $("[name='parentComment.id']").val(),
             blogId: $("[name='blog.id']").val(),
             nickName: $("[name='nickName']").val(),
             email: $("[name='email']").val(),
             content: $("[name='content']").val()
         }
       },
       success: function (data) {

       }
   })
});