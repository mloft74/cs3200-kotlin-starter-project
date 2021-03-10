package com.example.api.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.api.models.User
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class UserViewModel {
    val auth = Firebase.auth
    val user = MutableLiveData<User?>()
//    val loginError = MutableLiveData<RuntimeException?>()

    init {
        auth.addAuthStateListener {
            val fbUser = auth.currentUser
//            loginError.value = null
            user.value = if (fbUser == null) null else User(fbUser)
        }
    }

    fun signUp(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.result?.user != null) {
//                    loginError.value = RuntimeException("Signup failed")
//                }
//            }
    }

    fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
    }

    fun signOut() = auth.signOut()
}
