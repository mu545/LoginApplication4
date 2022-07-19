package com.learnandroid.loginapplication.presentaion.login

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learnandroid.loginapplication.domain.AuthRepostory
import com.learnandroid.loginapplication.presentaion.login.data.LoginUistate
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModule( private val repostory:AuthRepostory=AuthRepostory()): ViewModel() {
   val currentUser = repostory.currentUser
    val hasUser:Boolean
    get() = repostory.hasUser()

    var loginUistate by mutableStateOf(LoginUistate())
    private set

    fun onUserNameChange(username:String){
        loginUistate= loginUistate.copy(username= username)

    }
    fun onPassChange(pass:String){
        loginUistate= loginUistate.copy(username= pass)

    }
    fun onUserNameChangeSignUp(username:String){
        loginUistate= loginUistate.copy(usernameSiginUp =  username)

    }
    fun onPassChangeSignUp(pass:String){
        loginUistate= loginUistate.copy(passSingUp = pass)

    }
    fun onConfirmPassChange(pass:String){
        loginUistate= loginUistate.copy(confirmpassSignUp = pass)

    }

    //For validation
    private fun validateLoginForm() = loginUistate.username.isNotBlank() && loginUistate.pass.isNotBlank()

    private fun validateSignUpForm() = loginUistate.usernameSiginUp.isNotBlank()&& loginUistate.passSingUp.isNotBlank()&&loginUistate.confirmpassSignUp.isNotBlank()

   fun createUser(context: Context) = viewModelScope.launch {

       try {
           if(!validateSignUpForm()){

               throw  IllegalArgumentException("Email and Password can not be empty ")

           }
           loginUistate = loginUistate.copy(isLoading = true)
           if(loginUistate.passSingUp != loginUistate.confirmpassSignUp){
               throw IllegalArgumentException("Passwords not match ")
           }
           loginUistate= loginUistate.copy(signUpError = null)
           repostory.createuser(loginUistate.usernameSiginUp, loginUistate.passSingUp){isSuccessful -> if(isSuccessful){Toast.makeText(context, "Success Login", Toast.LENGTH_SHORT).show()
           loginUistate = loginUistate.copy(isSuccessLogin = true)}
           else{Toast.makeText(context, "Error to Login", Toast.LENGTH_SHORT).show()    } }
       }catch (e:Exception){
           loginUistate = loginUistate.copy(signUpError = e.localizedMessage)
           e.printStackTrace()
       }finally {
           loginUistate= loginUistate.copy(isLoading = false)
       }


   }
    fun LoginUser(context: Context) = viewModelScope.launch {

        try {
            if(!validateLoginForm()){

                throw  IllegalArgumentException("Email and Password can not be empty ")

            }
            loginUistate = loginUistate.copy(isLoading = true)

            loginUistate= loginUistate.copy(loginError = null)
            repostory.login(loginUistate.username, loginUistate.pass){isSuccessful -> if(isSuccessful){Toast.makeText(context, "Success Login", Toast.LENGTH_SHORT).show()
                loginUistate = loginUistate.copy(isSuccessLogin = true)}
            else{Toast.makeText(context, "Error to Login", Toast.LENGTH_SHORT).show()    } }
        }catch (e:Exception){
            loginUistate = loginUistate.copy(loginError = e.localizedMessage)
            e.printStackTrace()
        }finally {
            loginUistate= loginUistate.copy(isLoading = false)
        }


    }



}