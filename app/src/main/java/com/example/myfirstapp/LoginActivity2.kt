package com.example.myfirstapp

import android.R
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import com.example.myfirstapp.databinding.ActivityLoginBinding


class LoginActivity2 : AppCompatActivity() {


    //val = immutable. cannot be changed after initialization
    //lazy = initialized on first call
    private val binding: ActivityLoginBinding by lazy {
        DataBindingUtil.setContentView(this@LoginActivity2, R.layout.activity_login)
    }

    private val binding2: ActivityLoginBinding by lazy {
        DataBindingUtil.setContentView(this@LoginActivity2, R.layout.get_password)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.editTextPassword.doOnTextChanged { text, _, _, _ ->
            validateLoginFields(password = text?.toString())
        }

        binding.editTextPassword.setText("")

        binding.buttonSignIn.setOnClickListener {
            val password = binding.editTextPassword.text?.toString()
            validateCredentials(password)
        }

        /**
         * Tasks for Jasmine
         *
         * 1) set onClickListener for "Get Password Button"
         */
        // I am calling the button
        binding.buttonGetPassword.setOnClickListener{
            //this is where i wil launch the GetPassword Activity
            //Once the button is clicked then, it will launch the GetPassword Activity Page
            val intent = Intent(this, GetPassword::class.java)
            startActivity(intent)
            finish()

            /**
             *      a) Inside onClickListener, launch GetPassword Activity
             *      b) be sure to watch out for ???? when navigating between login and getPassword activities
             */

        }

       // binding.button4.setOnClickListener{

       // }






        /**
         * 3) Inside GetPassword Activity (in the code)
         *      a) use DataBindingUtil instead of normal setContentView()
         *      b) set onClickListeners for buttons in view
         *      c) do all the things to show password to user
         *      d) Stretch Goal:
         *          i) Create "Copy" button that copies password to user's clipboard
         */


        //If the checkbox is clicked then the textbox will show the password

        binding.checkBox{

        }
                checkBox.setOnClickerListener(

                )
                if (checkBox.isChecked) {
                    p
                    editTextTextPassword.inputType = 1
                    )
                    else

                        editTextTextPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD





                    checkBox.isChecked = false
                }

            }
        }


        //This is To Copy and Paste
      //  if ClipData.Item is text




        //This was going to be used for a buttton to show and hide the program
        /**
        /showHideBtn.setOnClickListener {//
            if(showHideBtn.text.toString().equals("Show")){
                pwd.transformationMethod = HideReturnsTransformationMethod.getInstance()
                showHideBtn.text = "Hide"
            } else{
                pwd.transformationMethod = PasswordTransformationMethod.getInstance()
                showHideBtn.text = "Show"
            }
        }

    }
        */

    private fun validateLoginFields(password: String? = binding.editTextPassword.text?.toString()) {
        val isValidPassword = password != null && password.isNotBlank() && password.length >= 2
        binding.signInEnabled = isValidPassword
    }

    private fun validateCredentials(password: String?) {
        //check if password is valid
        //if null OR
        //if empty (string.trim().length == 0) OR
        //password doesn't match valid password
        //show error message and don't continue
        if (password.isNullOrEmpty() || password != Constants.validPassword) {
            val message = "[$password] is not valid"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            return
        }

        //if we made it here, user has entered a valid password
        //hooray
        saveData(password)

        //if we made it here, password has been saved in shared preferences
        //now we can launch MainActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun saveData(password: String) {
        //get shared preferences
        val sharedPreferences = getSharedPreferences(Constants.SHARED_PREFS_KEY, Context.MODE_PRIVATE)

        //open editor for shared preferences
        val editor = sharedPreferences.edit()

        //save password that user entered into shared preferences
        editor.putString(Constants.PASSWORD_KEY, password)

        //save and close editor for shared preferences
        editor.apply()
    }
}
