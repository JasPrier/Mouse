package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.log
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.textfield.TextInputLayout

//import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val emailLiveData = MutableLiveData<String>()
    private val passwordLiveData = MutableLiveData<String>()
    private val isValidLiveData = MediatorLiveData<Boolean>().apply {
        this.value = false

        addSource(emailLiveData){ email ->
            val password = passwordLiveData.value
            this.value = validateForm(email, password)
        }

        addSource(passwordLiveData) { password ->
            val email = emailLiveData.value
            this.value = validateForm(email, password)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailLayout = findViewById<TextInputLayout>(R.id.email_layout)
        val passwordLayout = findViewById<TextInputLayout>(R.id.pasword_layout)
        val signInButton = findViewById<MaterialButton>(R.id.sign_in_button)

        emailLayout.editText?.doOnTextChanged { text, _, _, _ ->
            emailLiveData.value = text?.toString()
        }

        passwordLayout.editText?.doOnTextChanged { text, _, _, _ ->
            passwordLiveData.value = text?.toString()
        }

        isValidLiveData.observe(this){ isValid ->
            signInButton.isEnabled = isValid
        }
    }

        private fun validateForm(email: String?, password: String?): Boolean {
            val isValidEmail = email != null && email.isNotBlank() && email.contains("@")
            val isValidPassword = password != null && password.isNotBlank() && password.length>=6
            return isValidEmail && isValidPassword
        }


       // val button3 = findViewById<Button>(R.id.button)
       // button3.setOnClickListener{
          //  val intent = Intent(this, GetPassword::class.java)
        //    startActivity(intent)


       // }

        //fun isValidString(str: String): Boolean{
           // return android.util.Patterns.EMAIL_ADDRESS.matcher(str).matches()
       // }
       // override fun onCreate(savedInstanceState: Bundle?) {
           // super.onCreate(savedInstanceState)
         //   setContentView(R.layout.activity_main)

           // val emails = arrayOf<String>("hello@gmail.com", "one.com")

         //   emails.forEach {
           //     Log.d("MainActivity","is valid email $it => ${isValidString(it)}")
            }
        //}

        //class MainActivity : AppCompatActivity() {
          //  val EMAIL_ADDRESS_PATTERN = Pattern.compile(
            //    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
              //          "\\@" +
                //        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                  //      "(" +
                   //     "\\." +
                   //     "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                     //   ")+"
     //       )
       //     fun isValidString(str: String): Boolean{
         //       return EMAIL_ADDRESS_PATTERN.matcher(str).matches()
       //     }
         //   override fun onCreate(savedInstanceState: Bundle?) {
           //     super.onCreate(savedInstanceState)


        //val btn: Button = findViewById(R.id.button)

        //btn.setOnClickListener{
            //Toast.makeToast(this, "Testing", Toast.LENGTH_LONG).show("Hi")

       // }//btn.setOnClickListener



