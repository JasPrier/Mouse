package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.myfirstapp.databinding.ActivityLoginBinding

class GetPassword : AppCompatActivity() {

    private val binding2: ActivityLoginBinding by lazy {
        DataBindingUtil.setContentView(this@GetPassword, R.layout.get_password)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_password)

        val button3 = findViewById<Button>(R.id.button_Create)
        button3.setOnClickListener{
            val intent = Intent(this, GetPassword::class.java)
            startActivity(intent)

            //val actionBar = supportActionBar

            //if(actionBar != null){
            //  actionBar.title = "Password"
            //}

            //actionBar.setDisplayHomeAsUpEnabled(true)
        }



        binding2.button4Back.setOnClickListener{
            //this will take me back to the login screen
            //Once the button is clicked then, it will launch the Login Activity Page
            val intent = Intent(this, GetPassword::class.java)
            startActivity(intent)
            finish()
        /**
         * 3) Inside GetPassword Activity (in the code)
         *      a) use DataBindingUtil instead of normal setContentView()
         *      b) set onClickListeners for buttons in view
         *      c) do all the things to show password to user
         *      d) Stretch Goal:
         *          i) Create "Copy" button that copies password to user's clipboard
         */



    }

}
