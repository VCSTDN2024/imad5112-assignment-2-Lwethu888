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


        //linking UI elements to the appropriate varaibles
        val welcome = findViewById<TextView>(R.id.Welcome)
        val playbutton = findViewById<Button>(R.id.playbutton)
        val exitButton = findViewById<Button>(R.id.exitbutton)

        //Welcome message
        welcome.text = "Welcome Lets Test Your Math Knowledge"


        //allows user to move to the quiz page once the button is pressed
        playbutton.setOnClickListener {

            //Intent is used to link one kotlin file to the next
            val intent = Intent(this, MathsQuiz::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
    }
