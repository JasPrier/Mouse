package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import com.example.myfirstapp.databinding.ActivityMainBinding


class LoginActivity2 : AppCompatActivity() {

    //val = immutable. cannot be changed after initialization
    //lazy = initialized on first call
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this@LoginActivity2, R.layout.activity_main)
    }

    //initialize shared preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.editTextEmail.doOnTextChanged  { text, _, _, _ ->
            validateLoginFields(email = text?.toString())
        }

        binding.editTextPassword.doOnTextChanged { text, _, _, _ ->
            validateLoginFields(password = text?.toString())
        }

        binding.editTextEmail.setText("") //setText = preferences.getString()
        binding.editTextPassword.setText("") //setText = preferences.getString()

        binding.buttonSignIn.setOnClickListener {
            val email = binding.editTextEmail.text?.toString() ?: ""
            val password = binding.editTextPassword.text?.toString() ?: ""
            //val javaMessage = "[" + email + "][" + password + "]"
            val kotlinMessage = "[$email][$password]"
            Toast.makeText(this, kotlinMessage, Toast.LENGTH_LONG).show()
        }
        /*
        validateLoginFields()
        validateLoginFields("testEmail")
        validateLoginFields("testEmail", "testPassword")
        validateLoginFields(email = "testEmail")
        validateLoginFields(password = "testPassword")
        validateLoginFields(email = "testEmail", password = "testPassword")
        */
    }

    private fun validateLoginFields(
        email: String? = binding.editTextEmail.text?.toString(),
        password: String? = binding.editTextPassword.text?.toString()
    ) {
        val isValidEmail = email != null && email.isNotBlank() && email.contains("@")
        val isValidPassword = password != null && password.isNotBlank() && password.length >= 6
        binding.signInEnabled = isValidEmail && isValidPassword
    }
}
