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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.learnandroid.loginapplication.R

@Composable
fun  LoginPages(navController: NavController){
    Box(){
        val passwordVisibility = remember { mutableStateOf(false) }
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
                    .background(color = Color.Red),   onClick = {  navController.navigate("home_page"){
//                    popUpTo = navController.graph.startDestination
                    launchSingleTop = true
                }},  colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {
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

                    })
                )
            }


        }



    }






}