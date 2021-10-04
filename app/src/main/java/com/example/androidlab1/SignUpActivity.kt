package com.example.androidlab1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    private var goHomeSuButton: Button? = null
    private var signUpConfirmButton: Button? = null

    private var emailTextView: TextView? = null
    private var passwordTextView: TextView? = null
    private var nameTextView: TextView? = null
    private var passwordConfirmTextView: TextView? = null

    private var emailTextInputEditLayout: TextInputLayout? = null
    private var passwordTextInputEditLayout: TextInputLayout? = null
    private var nameTextInputEditLayout: TextInputLayout? = null
    private var passwordConfirmTextInputEditLayout: TextInputLayout? = null

    private var congratText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        emailTextView = findViewById(R.id.sign_up_email)
        passwordTextView = findViewById(R.id.sign_up_password)
        nameTextView = findViewById(R.id.sign_up_name)
        passwordConfirmTextView = findViewById(R.id.sign_up_confirm_password)

        emailTextInputEditLayout = findViewById(R.id.sign_up_email_layout)
        passwordTextInputEditLayout = findViewById(R.id.sign_up_password_layout)
        nameTextInputEditLayout = findViewById(R.id.sign_up_name_layout)
        passwordConfirmTextInputEditLayout = findViewById(R.id.sign_up_confirm_password_layout)

        setupGoHomeButton()
        confirmSignUpButton()
    }

    private fun setupGoHomeButton() {
        goHomeSuButton = findViewById(R.id.sign_up_go_back_button)
        goHomeSuButton?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun confirmSignUpButton() {
        signUpConfirmButton = findViewById(R.id.sign_up_confirm_button)
        signUpConfirmButton?.setOnClickListener {
            if (nameTextView?.text.isNullOrEmpty()) {
                nameTextInputEditLayout?.error = "Name is not validated"
            } else if (emailTextView?.text.isNullOrEmpty()) {
                nameTextInputEditLayout?.isErrorEnabled = false
                emailTextInputEditLayout?.error = "Email is not validated"
            } else if (passwordTextView?.text.isNullOrEmpty()) {
                nameTextInputEditLayout?.isErrorEnabled = false
                emailTextInputEditLayout?.isErrorEnabled = false
                passwordTextInputEditLayout?.error = "Password is not validated"
            } else if (passwordTextView?.text.toString().length> 8
            ) {
                nameTextInputEditLayout?.isErrorEnabled = false
                emailTextInputEditLayout?.isErrorEnabled = false
                passwordTextInputEditLayout?.error = "Password is long. Choose another one"
            } else if (passwordConfirmTextView?.text.isNullOrEmpty()
            ) {
                nameTextInputEditLayout?.isErrorEnabled = false
                emailTextInputEditLayout?.isErrorEnabled = false
                passwordTextInputEditLayout?.isErrorEnabled = false
                passwordConfirmTextInputEditLayout?.error = "Password Confirm is not validated"
            } else if ((passwordConfirmTextView?.text.toString().compareTo(passwordTextView?.text.toString()) != 0)
            ) {
                nameTextInputEditLayout?.isErrorEnabled = false
                emailTextInputEditLayout?.isErrorEnabled = false
                passwordTextInputEditLayout?.isErrorEnabled = false
                passwordConfirmTextInputEditLayout?.error = "Password mismatch"
            } else {
                emailTextInputEditLayout?.isErrorEnabled = false
                passwordTextInputEditLayout?.isErrorEnabled = false
                passwordTextInputEditLayout?.isErrorEnabled = false
                passwordConfirmTextInputEditLayout?.isErrorEnabled = false
                congratText = findViewById(R.id.sign_up_congrats_text_view)
                Toast.makeText(this, congratText?.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
