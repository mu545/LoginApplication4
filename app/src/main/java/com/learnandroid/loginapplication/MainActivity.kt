package com.learnandroid.loginapplication

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.google.firebase.auth.FirebaseAuth
import com.learnandroid.loginapplication.composables.LoginPage
import com.learnandroid.loginapplication.composables.RegisterPage
import com.learnandroid.loginapplication.presentaion.Home
import com.learnandroid.loginapplication.presentaion.LoginPages
import com.learnandroid.loginapplication.presentaion.Registerjahez
import com.learnandroid.loginapplication.ui.theme.LoginApplicationTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
//         lateinit var auth: FirebaseAuth

        setContent {
            LoginApplicationTheme {

                LoginApplication()
            }
        }
    }

    @Composable
    fun LoginApplication(){
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "login_page", builder = {
            composable("login_page", content = { LoginPages(navController = navController) })
            composable("register_page", content = { Registerjahez(navController = navController) })
            composable("home_page", content = { Home(navController = navController) })
        })
    }
}

