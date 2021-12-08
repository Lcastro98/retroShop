package com.misionTIC.retroshop.data.repositories

import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.userProfileChangeRequest
import kotlinx.coroutines.tasks.await

class UserRepository (private val dataSource: FirebaseAuth){
    suspend fun loggedIn(): FirebaseUser? {
        return dataSource.currentUser
    }

    suspend fun signUp(email: String, name: String, pass: String): FirebaseUser? {
        try {
            dataSource.createUserWithEmailAndPassword(email, pass).await()
            val user = dataSource.currentUser
            val profileUpdate =  userProfileChangeRequest {
                displayName = name

            }
            user!!.updateProfile(profileUpdate).await()
            return user
        } catch (e: FirebaseAuthUserCollisionException) {
            throw Error("Correo electronico en uso")
        }
    }

    suspend fun login(email: String, pass: String): FirebaseUser? {
        try {
            dataSource.signInWithEmailAndPassword(email, pass).await()
            return dataSource.currentUser
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            throw Error("Credenciales invalidas")
        } catch (e: FirebaseAuthInvalidUserException) {
            throw Error("Usuario deshabilitado")
        }
    }

    suspend fun logOut(): FirebaseUser? {
        dataSource.signOut()
        return null
    }
}