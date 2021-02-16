package com.example.api

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Verify {
    companion object {
        fun verifyPhoneApp() {
            Firebase.database.reference.child("phoneAppVerified").setValue(true);
        }

        fun verifyWatchApp() {
            Firebase.database.reference.child("watchAppVerified").setValue(true);
        }
    }
}
