package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GetPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_password)

        val button3 = findViewById<Button>(R.id.button)
        button3.setOnClickListener{
            val intent = Intent(this, GetPassword::class.java)
            startActivity(intent)

            //val actionBar = supportActionBar

            //if(actionBar != null){
            //  actionBar.title = "Password"
            //}

            //actionBar.setDisplayHomeAsUpEnabled(true)
        }


    }

}