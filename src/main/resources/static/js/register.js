
function securityButtonOnClick(t) {
    var button=$("#sendSecurity");
    var email = $("#emailInput").val();


    //验证码发送倒计时
    button.attr("disabled","true");
    var tt=window.setInterval(function () {
        if(t <= 0){
            button.html(" 发送验证码 ");
            button.removeAttr("disabled");
            window.clearInterval(tt);
        }else {
            button.html(t+'秒后重新发送');
        }
        t--;
    },1000)


    $.ajax({
        type: "get",
        url: "/email/getSecurity",
        dataType:"json",
        data: "email="+email,

        success: function (data) {
            //获取验证码失败
            if(!data.success){
                $("#message").text(data.message);
                $("#message").css("display","block");
                $("#userRegisterAction").css("background-color","#da0000");
            }
        }
    })
}



function userRegister() {
    var userForm=$("#userForm");
    //serializeArray()方法序列化表单元素
    var registerUser=userForm.serialize();

    $.ajax({
        type:"post",
        url:"/user/register",
        dataType:"json",
        async:false,
        data:registerUser,
        success:function (data) {
            //注册失败
            if(!data.success){
                $("#message").text(data.message);
                $("#message").css("display","block");
                $("#userRegisterAction").css("background-color","#da0000");
            }
            //注册成功
            location.href="/login.html";
        }
    })
}