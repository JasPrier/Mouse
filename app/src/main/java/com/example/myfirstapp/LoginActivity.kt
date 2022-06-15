package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData


class LoginActivity : AppCompatActivity() {

    private val emailLiveData = MutableLiveData<String>()
    private val passwordLiveData = MutableLiveData<String>()

    /*
    //this is the old way of observing a boolean
    //new way is LiveData
    //newest way is StateFlows
    private var isEmailPasswordValid: Boolean = false
        set(value) {
            if (field != value) {
                field = value
                observers.forEach {
                    it.run()
                }
            }
        }

    private val observers = mutableListOf<Runnable>()
    */

    private val isValidLiveData = MediatorLiveData<Boolean>().apply {
        this.value = false

        /*
        observers.add(Runnable {
            signInButton.isEnabled = isEmailPasswordValid
        })
        */


        addSource(emailLiveData) { email ->
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

        val emailLayout = findViewById<EditText>(R.id.edit_text_email)
        val passwordLayout = findViewById<EditText>(R.id.edit_text_password)
        val signInButton = findViewById<Button>(R.id.button_sign_in)

        emailLayout.doOnTextChanged { text, _, _, _ ->
            emailLiveData.value = text?.toString()
        }

        passwordLayout.doOnTextChanged { text, _, _, _ ->
            passwordLiveData.value = text?.toString()
        }

        isValidLiveData.observe(this) { isValid ->
            signInButton.isEnabled = isValid
        }

        signInButton.setOnClickListener {

        }

        // button3.setOnClickListener{
        //  val intent = Intent(this, GetPassword::class.java)
        //    startActivity(intent)


        // }

    }

        private fun validateForm(email: String?, password: String?): Boolean {
            val isValidEmail = email != null && email.isNotBlank() && email.contains("@")
            val isValidPassword = password != null && password.isNotBlank() && password.length>=6
            return isValidEmail && isValidPassword
        }

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



