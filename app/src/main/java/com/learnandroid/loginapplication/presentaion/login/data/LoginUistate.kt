package com.learnandroid.loginapplication.presentaion.login.data

data class LoginUistate(
    val username:String ="",val pass:String ="",val usernameSiginUp:String ="",val passSingUp:String ="",val confirmpassSignUp: String ="" , val  isSuccessLogin:Boolean= false, val signUpError:String? =null , val loginError:String?= null, val  isLoading:Boolean?=null)


