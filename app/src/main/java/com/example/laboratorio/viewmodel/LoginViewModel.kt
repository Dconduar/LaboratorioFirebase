package com.example.laboratorio.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    var showAlert by mutableStateOf(false)

    fun login(email: String, password: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful) {
                            onSuccess()
                        } else {
                            Log.e("LoginViewModel", "Login failed", task.exception)
                            showAlert = true
                        }
                    }
            }catch (e: Exception){
                Log.e("LoginViewModel", "Login failed", e)
                showAlert = true
            }
        }
    }
    fun closeAlert() {
        showAlert = false
    }
}
