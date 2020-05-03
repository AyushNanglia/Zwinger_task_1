package com.example.groceryapp_zwinger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
   lateinit var title:TextView
    lateinit var loginbut:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_act)

    title=findViewById(R.id.title)
    loginbut=findViewById(R.id.loginbut)

        loginbut.setOnClickListener {
            val intent=Intent(this@LoginActivity,UserpageActivity::class.java)
            startActivity(intent)
            finish()
             }
    }

}
