var SnippetLogin = function() {
    var e = $("#m_login"),
        i = function(e, i, a) {
            var t = $('<div class="m-alert m-alert--outline alert alert-' + i + ' alert-dismissible" role="alert">\t\t\t<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>\t\t\t<span></span>\t\t</div>');
            e.find(".alert").remove(),
                t.prependTo(e),
                t.animateClass("fadeIn animated"),
                t.find("span").html(a)
        },
        a = function() {
            e.removeClass("m-login--forget-password"),
                e.removeClass("m-login--signin"),
                e.addClass("m-login--signup")
        },
        t = function() {
            e.removeClass("m-login--forget-password"),
                e.removeClass("m-login--signup"),
                e.addClass("m-login--signin"),
                e.find(".m-login__signin").animateClass("flipInX animated")
        },
        r = function() {
            e.removeClass("m-login--signin"),
                e.removeClass("m-login--signup"),
                e.addClass("m-login--forget-password"),
                e.find(".m-login__forget-password").animateClass("flipInX animated")
        },
        n = function() {
            $("#m_login_forget_password").click(function(e) {
                e.preventDefault(),
                    r()
            }),
                $("#m_login_forget_password_cancel").click(function(e) {
                    e.preventDefault(),
                        t()
                }),
                $("#m_login_signup").click(function(e) {
                    e.preventDefault(),
                        a()
                }),
                $("#m_login_signup_cancel").click(function(e) {
                    e.preventDefault(),
                        t()
                })
        },
        l = function() {
            $("#m_login_signin_submit").click(function(e) {
                e.preventDefault();
                var a = $(this),
                    t = $(this).closest("form");
                t.validate({
                    rules: {
                        email: {
                            required: !0,
                            email: !0
                        },
                        password: {
                            required: !0
                        }
                    }
                }),
                t.valid() && (a.addClass("m-loader m-loader--right m-loader--light").attr("disabled", !0), $.ajax({
                    data:{email:$("#email").val(),password:$("#password").val()},
                    type:"POST",
                   // contentType:'application/json',
                    url: "user/login",
                    //success: function(e, r, n, l) {
                    success: function(result) {
                        if(result.rspCode=="000000"){
                            setTimeout(function () { location.href =  "chat"; }, 1000);
                        }else {
                            setTimeout(function() {
                                    a.removeClass("m-loader m-loader--right m-loader--light").attr("disabled", !1),
                                        i(t, "danger", "Incorrect username or password. Please try again.")
                                },
                                2e3)
                        }

                    }
                }))
            })
        },
        s = function() {
            $("#m_login_signup_submit").click(function(a) {
                a.preventDefault();
                var r = $(this),
                    n = $(this).closest("form");
                n.validate({
                    rules: {
                        fullname: {
                            required: !0
                        },
                        email: {
                            required: !0,
                            email: !0
                        },
                        password: {
                            required: !0
                        },
                        rpassword: {
                            required: !0
                        },
                        agree: {
                            required: !0
                        }
                    }
                }),
                n.valid() && (r.addClass("m-loader m-loader--right m-loader--light").attr("disabled", !0), n.ajaxSubmit({
                    url: "",
                    success: function(a, l, s, o) {
                        setTimeout(function() {
                                r.removeClass("m-loader m-loader--right m-loader--light").attr("disabled", !1),
                                    n.clearForm(),
                                    n.validate().resetForm(),
                                    t();
                                var a = e.find(".m-login__signin form");
                                a.clearForm(),
                                    a.validate().resetForm(),
                                    i(a, "success", "Thank you. To complete your registration please check your email.")
                            },
                            2e3)
                    }
                }))
            })
        },
        o = function() {
            $("#m_login_forget_password_submit").click(function(a) {
                a.preventDefault();
                var r = $(this),
                    n = $(this).closest("form");
                n.validate({
                    rules: {
                        email: {
                            required: !0,
                            email: !0
                        }
                    }
                }),
                n.valid() && (r.addClass("m-loader m-loader--right m-loader--light").attr("disabled", !0), n.ajaxSubmit({
                    url: "",
                    success: function(a, l, s, o) {
                        setTimeout(function() {
                                r.removeClass("m-loader m-loader--right m-loader--light").attr("disabled", !1),
                                    n.clearForm(),
                                    n.validate().resetForm(),
                                    t();
                                var a = e.find(".m-login__signin form");
                                a.clearForm(),
                                    a.validate().resetForm(),
                                    i(a, "success", "Cool! Password recovery instruction has been sent to your email.")
                            },
                            2e3)
                    }
                }))
            })
        };
    return {
        init: function() {
            n(),
                l(),
                s(),
                o()
        }
    }
} ();
jQuery(document).ready(function() {
    SnippetLogin.init()
});