package com.example.api.models

import com.google.firebase.auth.FirebaseUser

class User(user: FirebaseUser) {
    val uid: String = user.uid
    val email: String? = user.email
}
