package com.example.myfirstapp
import android.os.Bundle
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //this is the shared preferences
        //var sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        loadData()

        //Button Click
        button_sign_in.setOnClickerListener{
            saveData()


        }
    }


    private fun saveData(){


        val insertedText :String = edit_text_email.text.toString()
        edit_text_password.text = insertedText


        var sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        editor.apply{
            putString("STRING_KEY", insertedText)
            putBoolean("BOOLEAN_KEY", sw_switch)
        }apply()

        Toast.makeText(this,"Data saved", Toast.LENGTH_SHORT).show()
    }

    private fun loadData(){
        var sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        var savedString : String? = sharedPreferences.getString("STRING_KEY", null)
        var savedBoolean: Boolean = sharedPreferences.getBoolean("BOOLEAN_KEY", false)

        edit_text_password.text = savedString
        sw_switch.isChecked = savedBoolean

    }


    //sharedPref = MainActivity?.getPreferences(Context.MODE_PRIVATE) ?: return
    //val defaultValue = resources.getInteger(R.integer.saved_high_score_default_key)
    //val highScore = sharedPref.getInt(getString(R.string.saved_high_score_key), defaultValue)

    /*

    STEPS:

    1 - Define SplashActivity in manifest
    2 - Make SplashActivity default/launch activity
    3 - Inside SplashActivity check if user is already authenticated/logged in
    */


    /*val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
     with (sharedPref.edit()) {
        putInt(getString(R.string.saved_high_score_key), newHighScore)
        apply()
    }
    */


    /*

        a - If user IS logged in, go to MainActivity
        b - If user IS NOT logged in, go to LoginActivity
     */
}