package com.learnandroid.loginapplication.presentaion

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.isPopupLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.learnandroid.loginapplication.presentaion.login.LoginViewModule

enum class LoginRoutes{

    Sinup,
    Sinin

}
    enum class Home{

    Home,
    Details

}
@Composable
fun Navigator(navController: NavHostController = rememberNavController() , loginViewModule: LoginViewModule) {
NavHost(navController =navController , startDestination = "register_page", builder = { composable("login_page", content = { LoginPages(loginViewModule = loginViewModule,navController) })
    composable("register_page", content = { Registerjahez(loginViewModule = loginViewModule,navController) })})
}

//    NavHost(navController = navController, startDestination = "login_page", builder = {
//        composable("login_page", content = { LoginPages(loginViewModule = loginViewModule) }))
//    }
//


//        composable("home_page", content = { Home(loginViewModule = navController) })

//    NavHost(navController = navController, startDestination = LoginRoutes.Sinin.name){
//        composable(route = LoginRoutes.Sinin.name, ){
//            LoginPages(onNavHome = {navController.navigate(Home.Home.name)}) {
//
//
//
//
//            }
//            navController.navigate(LoginRoutes.Sinup.name){}
//
//
//        }
//        composable(route = LoginRoutes.Sinup.name, ){
//            Registerjahez(onNavHome = {navController.navigate(Home.Home.name)})
//
//        }
//        navController.navigate(LoginRoutes.Sinin.name){}
//
//        composable(route = Home.Home.name, ){
//            HomeScrenns()
//
//        }
//
//
//    }

