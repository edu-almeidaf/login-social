package com.betrybe.sociallogin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private val loginButton: Button by lazy { findViewById(R.id.login_button) }
    private val emailInput: TextInputEditText by lazy { findViewById(R.id.email_text_input_field) }
    private val passwordInput: TextInputEditText by lazy { findViewById(R.id.password_text_input_field) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enableButton()
        validateEmail()
    }

    private fun enableButton () {
        loginButton.isEnabled = false
        emailInput.doOnTextChanged { text, start, before, count -> verifyFields() }
        passwordInput.doOnTextChanged { text, start, before, count -> verifyFields() }
    }

    private fun verifyFields() {
        val emailInputNotEmpty = emailInput.text?.isNotEmpty()!!
        val passwordInputNotEmpty = passwordInput.text?.isNotEmpty()!!
        loginButton.isEnabled = emailInputNotEmpty && passwordInputNotEmpty
    }

    private fun validateEmail() {

    }
}
