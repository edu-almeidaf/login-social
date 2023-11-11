package com.betrybe.sociallogin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val loginButton: Button by lazy { findViewById(R.id.login_button) }
    private val emailInput: TextInputLayout by lazy { findViewById(R.id.email_text_input_layout) }
    private val passwordInput: TextInputLayout by lazy { findViewById(R.id.password_text_input_layout) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginButton.isEnabled = false

        enableButton()
    }

    private fun enableButton () {
        emailInput.editText?.doOnTextChanged { text, start, before, count -> verifyFields() }
        passwordInput.editText?.doOnTextChanged { text, start, before, count -> verifyFields() }
    }

    private fun verifyFields() {
        val emailInputNotEmpty = emailInput.editText?.text?.isNotEmpty()!!
        val passwordInputNotEmpty = passwordInput.editText?.text?.isNotEmpty()!!

        loginButton.isEnabled = emailInputNotEmpty && passwordInputNotEmpty
    }
}
