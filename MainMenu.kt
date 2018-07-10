package com.example.zvonimir.popquiz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.Button


class MainMenu : AppCompatActivity() {

    private var newGameButton: Button? = null
    private var loginButton: Button?=null
    private var listOfPlayers: RecyclerView? = null
    private var testButton: Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_menu)
        newGameButton = findViewById(R.id.new_game)
        loginButton=findViewById(R.id.login)
        testButton=findViewById(R.id.testButton)
        newGameButton?.setOnClickListener{click ->
            val CategoryInt= Intent(this,CategoryActivity::class.java) // izbor kategorija za igru
            startActivity(CategoryInt)
        }
        loginButton?.setOnClickListener{click->
            val LoginInt=Intent(this,LoginActivity::class.java)
            startActivity(LoginInt)
        }
    }
}
