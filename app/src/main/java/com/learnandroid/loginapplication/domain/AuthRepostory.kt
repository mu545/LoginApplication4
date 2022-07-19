package com.learnandroid.loginapplication.domain

import androidx.compose.runtime.Composable
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepostory {
    val currentUser : FirebaseUser? =Firebase.auth.currentUser

    fun hasUser(): Boolean = Firebase.auth.currentUser != null
    fun getuserId():String = Firebase.auth.currentUser?.uid.orEmpty()

    suspend fun createuser(email:String , pass: String , onComposable: (Boolean)->Unit) = withContext(Dispatchers.IO){
        Firebase.auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
            if(it.isSuccessful){
                onComposable.invoke(true)
            }else{onComposable.invoke(false)}
        }
    }
    suspend fun login(email:String , pass: String , onComposable: (Boolean)->Unit) = withContext(Dispatchers.IO){
        Firebase.auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener{
            if(it.isSuccessful){
                onComposable.invoke(true)
            }else{onComposable.invoke(false)}
        }
    }















}