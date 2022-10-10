package com.example.task8.data.repository

import com.example.task8.data.model.User
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val firebaseAuth: FirebaseAuth) :
    UserRepository {


    override fun createUser(user: User , onResult: (Boolean) -> Unit) {
        if (user.email!!.isNotEmpty() && user.password!!.isNotEmpty() &&
            user.repeatPassword!!.isNotEmpty()
        ) {
            if (
                (user.password == user.repeatPassword) &&
                user.password.contains(Regex(("(?=.*[0-9])"))) &&
                user.password.contains(Regex("(?=.*[A-Z])")) &&
                user.password.contains(Regex(".{6,}"))
//                user.repeatPassword.contains(Regex(("(?=.*[0-9])"))) &&
//                user.repeatPassword.contains(Regex("(?=.*[A-Z])")) &&
//                user.repeatPassword.contains(Regex(".{6,}"))

            ) {
                firebaseAuth.createUserWithEmailAndPassword(user.email , user.password)
                    .addOnCompleteListener {
                        onResult.invoke(it.isSuccessful)

                    }
            }
        }
//        try {
//            if (user.email!!.isNotEmpty() && user.password!!.isNotEmpty() &&
//                user.repeatPassword!!.isNotEmpty() && user.fullName!!.isNotEmpty()
//            ) {
//                if (
//                    user.password == user.repeatPassword &&
//                    user.password.contains(Regex(("(?=.*[0-9])"))) &&
//                    user.password.contains("(?=.*[A-Z])") &&
//                    user.password.contains(Regex(".{6,}"))
//                ) {
//                    firebaseAuth.createUserWithEmailAndPassword(user.email , user.password)
//                        .addOnCompleteListener {
//                            onResult.invoke(Result.Success(data = User()))
//
//                        }
//                }
//            }
//
//        } catch(e: Throwable){
//            onResult.invoke(Result.Error(throwable = Throwable(message = "Error")))
//        }
//    }

    }


    override fun logIn(user: User , onResult: (Boolean) -> Unit) {
        if (user.email!!.isNotEmpty() && user.password!!.isNotEmpty()) {
            firebaseAuth.signInWithEmailAndPassword(user.email , user.password)
                .addOnCompleteListener {
                    onResult.invoke(it.isSuccessful)
                }
        }
    }


    override fun logOut(user: User , onResult: (Boolean) -> Unit) {
        firebaseAuth.signOut()
    }
}
