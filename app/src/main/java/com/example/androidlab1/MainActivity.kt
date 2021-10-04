package com.example.androidlab1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private var signUpButton: Button? = null
    private var signInButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSignInButton()
        setupSignUpButton()
    }
    private fun setupSignInButton() {
        signInButton = findViewById(R.id.sign_in_button)
        signInButton?.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setupSignUpButton() {
        signUpButton = findViewById(R.id.sign_up_button)
        signUpButton?.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
