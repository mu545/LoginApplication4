package com.learnandroid.loginapplication.presentaion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.learnandroid.loginapplication.R


@Composable
fun Registerjahez(navController: NavController){
    Box(modifier = Modifier.background(color = Color.White)){
        Column() {
            Row(horizontalArrangement = Arrangement.Center) {
                Image(painter = painterResource(id = R.drawable.jahezz), modifier = Modifier.fillMaxWidth())
            }
            Row() {
                OutlinedTextField(
                    value = "",
                    onValueChange = {  },
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
                    value = "",
                    onValueChange = {  },
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "Password") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(start = 50.dp),
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                OutlinedTextField(
                    value = "",
                    onValueChange = {  },
                    label = { Text(text = "Confirm Password") },
                    placeholder = { Text(text = " Confirm Password") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(start = 50.dp),
                )
            }
            Spacer(modifier = Modifier.height(60.dp))
            Row() {
                Button( modifier = Modifier
                    .width(350.dp)
                    .height(50.dp)
                    .padding(start = 40.dp)
                    .background(color = Color.Red),   onClick = { /*TODO*/ },  colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {
                    Text(text = "Create account", style = TextStyle(color = Color.White))
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Row(modifier = Modifier.padding(start = 135.dp)) {
                Text(
                    text = "Login Instead",
                    modifier = Modifier.clickable(onClick = {
                        navController.navigate("login_page"){
                            popUpTo = navController.graph.startDestination
                            launchSingleTop = true
                        }


                    })
                )
            }
//            Spacer(modifier = Modifier.padding(10.dp))
//            Row(modifier = Modifier.padding(start = 135.dp)) {
//                Text(
//                    text = "Create account",
//                    modifier = Modifier.clickable(onClick = {
////                    navController.navigate("register_page"){
////                        popUpTo = navController.graph.startDestination
////                        launchSingleTop = true
////                    }
//                    })
//                )
//            }


        }



    }


}