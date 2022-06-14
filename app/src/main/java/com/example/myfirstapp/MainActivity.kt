package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

//import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val emailLiveData = MutableLiveData<String>()
    private val passwordLiveData = MutableLiveData<String>()
    private val isValidLiveData = MediatorLiveData<Boolean>().apply {
        addSource(emailLiveData){ email ->
            val password = passwordLiveData.value
            this.value = validateForm(email,)

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

        private fun validateForm(email: String?, password:String?): Boolean {
            return false
        }


        val button3 = findViewById<Button>(R.id.button)
        button3.setOnClickListener{
            val intent = Intent(this, GetPassword::class.java)
            startActivity(intent)


        }

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
        }

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



