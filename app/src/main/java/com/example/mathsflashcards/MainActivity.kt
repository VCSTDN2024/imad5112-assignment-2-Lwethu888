package com.example.mathsflashcards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val Welcome = findViewById<TextView>(R.id.Welcome)
        val playbutton = findViewById<Button>(R.id.playbutton)
        val exitButton = findViewById<Button>(R.id.exitbutton)

        Welcome.text = "Welcome Lets Test Your Math Knowledge"


        playbutton.setOnClickListener {

            val intent = Intent(this, MathsQuiz::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
    }
