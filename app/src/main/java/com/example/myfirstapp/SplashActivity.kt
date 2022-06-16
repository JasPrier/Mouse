package com.example.myfirstapp
import android.os.Bundle
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        loadData()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences(Constants.SHARED_PREFS_KEY, Context.MODE_PRIVATE)
        val savedPassword: String? = sharedPreferences.getString(Constants.PASSWORD_KEY, null)

        if (savedPassword.isNullOrEmpty() || savedPassword != Constants.validPassword) {
            //user is not logged in
            //go to LoginActivity2
            val intent = Intent(this, LoginActivity2::class.java) //"this" keyword always refers to the current class
            startActivity(intent)
        } else {
            //user IS logged in
            //go to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        finish()
    }

    /*

    STEPS:

    1 - Define SplashActivity in manifest
    2 - Make SplashActivity default/launch activity
    3 - Inside SplashActivity check if user is already authenticated/logged in
        a - If user IS logged in, go to MainActivity
        b - If user IS NOT logged in, go to LoginActivity
     */

    /*val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
     with (sharedPref.edit()) {
        putInt(getString(R.string.saved_high_score_key), newHighScore)
        apply()
    }
    */



}