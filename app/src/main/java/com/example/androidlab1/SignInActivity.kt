package com.example.androidlab1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class SignInActivity : AppCompatActivity() {
    private var signInConfirmButton: Button? = null
    private var signUpForNoAccButton: Button? = null

    private var emailTextView: TextView? = null
    private var passwordTextView: TextView? = null
    private var passwordTextString: String? = null
    private var emailTextInputEditLayout: TextInputLayout? = null
    private var passwordTextInputEditLayout: TextInputLayout? = null

    private var congratText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        emailTextView = findViewById(R.id.sign_in_email)
        passwordTextView = findViewById(R.id.sign_in_password)
        emailTextInputEditLayout = findViewById(R.id.sign_in_email_layout)
        passwordTextInputEditLayout = findViewById(R.id.sign_in_password_layout)
        confirmSignInButton()
        setupSignUpForNoAccButton()
    }
    private fun setupSignUpForNoAccButton() {
        signUpForNoAccButton = findViewById(R.id.sign_up_for_no_account_button)
        signUpForNoAccButton?.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isValidPassword(password: String?): Boolean {
        password?.let {
            val passwordPattern = "[A-Za-z]{8,}$"
            val passwordMatcher = Regex(passwordPattern)

            return passwordMatcher.find(password) != null
        } ?: return false
    }
    private fun isEmailValid(email: String?): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun confirmSignInButton() {
        signInConfirmButton = findViewById(R.id.sign_in_confirm_button)
        signInConfirmButton?.setOnClickListener {
            if (emailTextView?.text.isNullOrEmpty()) {
                passwordTextInputEditLayout?.isErrorEnabled = false
                emailTextInputEditLayout?.error = "Email is not validated"
            } else if (isEmailValid(emailTextView?.text.toString()) == false) {
                passwordTextInputEditLayout?.isErrorEnabled = false
                emailTextInputEditLayout?.error = "The email is incorrect"
            } else if (passwordTextView?.text.isNullOrEmpty()) {
                emailTextInputEditLayout?.isErrorEnabled = false
                passwordTextInputEditLayout?.error = "Password is not validated"
            } else if (isValidPassword(passwordTextView?.text.toString())
            ) {
                emailTextInputEditLayout?.isErrorEnabled = false
                passwordTextInputEditLayout?.error = "Password is long. Choose another one"
            }
//            else if (passwordTextView?.text.toString().length< 8
//            ) {
//                emailTextInputEditLayout?.isErrorEnabled = false
//                passwordTextInputEditLayout?.error = "Password is long. Choose another one"
//            }
            else {
                emailTextInputEditLayout?.isErrorEnabled = false
                passwordTextInputEditLayout?.isErrorEnabled = false
                congratText = findViewById(R.id.sign_in_congrats_text_view)
                Toast.makeText(this, congratText?.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
