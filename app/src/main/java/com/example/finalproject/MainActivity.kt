package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    enum class UserLogin
    constructor(val intValue: Int) {
        Login(1),
        Password(2),
        Success(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userEntry = findViewById<EditText>(R.id.usernameInput)
        val passwordEntry = findViewById<EditText>(R.id.passwordInput)
        val loginBtn = findViewById<Button>(R.id.loginButton)

        loginBtn.setOnClickListener {
            val toastError: Toast? = null
            val isOK: UserLogin? = null

            when (loginVerify(userEntry.text.toString(), passwordEntry.text.toString())) {
                UserLogin.Login -> {
//                    toastError!!.makeText(getApplicationContext(), getString(R.string.errMessageLogin), toastError.LENGTH_SHORT).show()
                    userEntry.requestFocus()
                }
                UserLogin.Password -> {
//                    toastError!!.makeText(getApplicationContext(), getString(R.string.errMessagePassword), toastError.LENGTH_SHORT).show()
                    passwordEntry.requestFocus()
                }
                else ->
                    startActivity(Intent(this@MainActivity, FinalScreen2::class.java))
            }
        }
    }

        fun loginVerify(userEntry: String, passwordEntry: String): UserLogin {
            val holdLogin = "Joel"
            val holdPassword = "Password"

            if (holdLogin != userEntry) {
                return UserLogin.Login
            }
            return if (holdPassword != passwordEntry) {
                UserLogin.Password
            }
            else UserLogin.Success
        }
    
}
