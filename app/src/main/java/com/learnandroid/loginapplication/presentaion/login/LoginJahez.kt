package com.learnandroid.loginapplication.presentaion

import android.content.Context
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.google.firebase.auth.FirebaseAuth
import com.learnandroid.loginapplication.R
import com.learnandroid.loginapplication.presentaion.login.LoginViewModule
import java.lang.Math.log
import java.util.regex.Pattern
import kotlin.coroutines.coroutineContext



@Composable
fun  LoginPages( loginViewModule: LoginViewModule? = null,navController: NavController ){
    val loginUistate= loginViewModule?.loginUistate
    val isError = loginUistate?.loginError !=null
    val context = ContextAmbient.current



    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val isEmailValid by derivedStateOf {
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    }
    val isPassValid by derivedStateOf {
   password.length > 7

    }
    Box(){
        val passwordVisibility = remember { mutableStateOf(false) }
        Column {
            Row(horizontalArrangement = Arrangement.Center) {
                Image(painter = painterResource(id = R.drawable.jahezz), modifier = Modifier.fillMaxWidth())
            }
            Row() {
                OutlinedTextField(
                    value = loginUistate?.username ?:"",
                    isErrorValue = isError,
                    onValueChange = { loginViewModule?.onUserNameChange(it)},
                    label = { Text(text = "Email Address") },
                    placeholder = { Text(text = "Email Address") },
                    singleLine = true,

                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(start = 50.dp),
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                OutlinedTextField(
                    value = loginUistate?.passSingUp ?:"",
                    onValueChange = { loginViewModule?.onPassChangeSignUp(it)  },
                    isErrorValue = isError,
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "Password") },
                    visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(start = 50.dp),
                )
            }
            Spacer(modifier = Modifier.height(80.dp))
            Row() {
                Button( modifier = Modifier
                    .width(350.dp)
                    .height(50.dp)
                    .padding(start = 40.dp)
                    .background(color = Color.Red),   onClick = { loginViewModule?.LoginUser((context ))},  colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {
                    Text(text = "Login", style = TextStyle(color = Color.White))
                }
            }



            Spacer(modifier = Modifier.padding(10.dp))
            Row(modifier = Modifier.padding(start = 135.dp)) {
                Text(
                    text = "Create account",
                    modifier = Modifier.clickable(onClick = {
                        navController.navigate("register_page"){
                            popUpTo = navController.graph.startDestination
                            launchSingleTop = true
                        }
//                        onNavLogin.invoke()


                    })
                )
            }
            if(loginUistate?.isLoading ==true){
                CircularProgressIndicator()

            }


            LaunchedEffect(subject = loginViewModule?.hasUser){
                if(loginViewModule?.hasUser == true){
//                    onNavHome.invoke()
                }

            }



        }



    }





}