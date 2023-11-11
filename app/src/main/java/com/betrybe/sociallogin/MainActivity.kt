package com.betrybe.sociallogin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.doOnTextChanged
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val loginButton: Button by lazy { findViewById(R.id.login_button) }

    private val emailInput: TextInputLayout by lazy { findViewById(R.id.email_text_input_layout) }
    private val emailInputField: TextInputEditText by lazy {
        findViewById(R.id.email_text_input_field)
    }

    private val passwordInput: TextInputLayout by lazy {
        findViewById(R.id.password_text_input_layout)
    }
    private val passwordInputField: TextInputEditText by lazy {
        findViewById(R.id.password_text_input_field)
    }

    private val regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"

    private val parentLayout: ConstraintLayout by lazy { findViewById(R.id.main) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enableButton()
        loginButton.setOnClickListener { validateEmailAndPassword() }
    }

    private fun enableButton() {
        loginButton.isEnabled = false
        emailInputField.doOnTextChanged { text, start, before, count -> verifyFields() }
        passwordInputField.doOnTextChanged { text, start, before, count -> verifyFields() }
    }

    private fun verifyFields() {
        val emailInputNotEmpty = emailInputField.text?.isNotEmpty()!!
        val passwordInputNotEmpty = passwordInputField.text?.isNotEmpty()!!
        loginButton.isEnabled = emailInputNotEmpty && passwordInputNotEmpty
    }

    private fun validateEmailAndPassword() {
        val emailText = emailInputField.text.toString()
        val passwordText = passwordInputField.text.toString()

        if (!emailText.matches(regexEmail.toRegex())) {
            emailInput.error = getString(R.string.email_warning)
        } else if (passwordText.length < 4) {
            passwordInput.error = getString(R.string.password_warning)
        } else {
            emailInput.error = null
            passwordInput.error = null
            Snackbar.make(parentLayout, R.string.login_succeeded, Snackbar.LENGTH_LONG).show()
        }
    }
}
