package com.learnandroid.loginapplication

import android.os.Bundle
import android.view.WindowManager

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.viewModel



import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
//import com.google.firebase.auth.FirebaseAuth

import com.learnandroid.loginapplication.presentaion.Home
import com.learnandroid.loginapplication.presentaion.LoginPages
import com.learnandroid.loginapplication.presentaion.Navigator
import com.learnandroid.loginapplication.presentaion.Registerjahez
import com.learnandroid.loginapplication.presentaion.login.LoginViewModule
import com.learnandroid.loginapplication.ui.theme.LoginApplicationTheme

class MainActivity : AppCompatActivity() {
    companion object {val TAG: String =MainActivity::class.java.simpleName}
    private val auth by lazy {
        Firebase.auth
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)


        setContent {

            val loginViewModule = viewModel(modelClass =LoginViewModule:: class.java)
            LoginApplicationTheme {
                Navigator(loginViewModule= loginViewModule)
            }
        }
    }

}

