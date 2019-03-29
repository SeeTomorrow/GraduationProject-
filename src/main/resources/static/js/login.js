//改变登陆注册页面样式

function registerButtonOnclick() {
    //状态码1为登陆2为注册
    var registerButton=$("#registerButton");
    var username=$("#username");
    var password=$("#password");
    var rememberMe=$("#rememberMe");
    var forgetRegister=$("#forgetRegister");
    var security=$("#security");
    var confirm=$("#confirm");
    var sendSecurity=$("#sendSecurity");
    var loginMessage=$("#message");
    var userRegisterAction=$("#userRegisterAction");
    var userLoginAction=$("#userLoginAction");
    var status = registerButton.attr("status");
    if(status==1){
        $(".h1").text("登陆");
        username.find("span").text("用户名或邮箱");
        username.find("input").removeClass("style");
        forgetRegister.find("button").text("注册");

        // userLoginAction.css("margin-top",23);

        //显示rememberMe
        rememberMe.css("display","inline");
        //显示忘记密码
        forgetRegister.find("a").css("display","inline");
        //显示登陆按钮
        userLoginAction.css("display","inline");

        //隐藏确认密码
        confirm.css("display","none");
        //隐藏验证码
        security.css("display","none");
        //隐藏发送验证码按钮
        sendSecurity.css("display","none");
        //隐藏注册按钮
        userRegisterAction.css("display","none");

        registerButton.attr("status",2);
    }else {
        $(".h1").text("注册");
        forgetRegister.find("button").text("登陆");
        username.find("span").text("邮箱");
        // userLoginAction.css("margin-top",33);

        //隐藏rememberMe
        rememberMe.css("display","none");
        //隐藏忘记密码
        forgetRegister.find("a").css("display","none");
        //隐藏提示信息
        loginMessage.css("display","none");
        //隐藏登陆按钮
        userLoginAction.css("display","none");

        //显示确认密码
        confirm.css("display","block");
        // confirm.removeClass("display");
        //显示验证码
        security.css("display","block");
        //显示发送验证码按钮
        sendSecurity.css("display","block");
        //显示注册按钮
        userRegisterAction.css("display","block");

        registerButton.attr("status",1);
        // alert(status)
    }
}



//通过ajax验证登陆
    function userLogin() {
        var passwordInput=$("#passwordInput");
        var loginMessage=$("#message");
        var userForm=$("#userForm");
        var userLoginAction=$("#userLoginAction")

        //serializeArray()方法序列化表单元素
        var loginUser=userForm.serialize();
        $("#rememberMe").attr("checked")

        /*$.each(loginUser, function(i, field){
            alert(field.name+"::"+field.value)
        });*/

        $.ajax({
            type:"post",
            url:"/user/login",
            dataType:"json",
            async:false,
            data:loginUser,
            success:function (data) {

                //登陆失败
                if(!data.success){
                    passwordInput.val("");
                    loginMessage.text(data.message);
                    loginMessage.css("display","block");
                    userLoginAction.css("background-color","#da0000");
                }else {
                    //成功，跳转到主页
                    location.href="home.html";
                }

            }
        })
    }
