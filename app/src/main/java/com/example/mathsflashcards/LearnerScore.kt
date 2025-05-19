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

class LearnerScore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_learner_score)

        val scoretextView = findViewById<TextView>(R.id.scoretextView)
        val feedbacktextView = findViewById<TextView>(R.id.feedbacktextView)
        val restartbutton = findViewById<Button>(R.id.restartbutton)
        val exitbutton = findViewById<Button>(R.id.exitbutton)

        val score = intent.getIntExtra("score", 0)
        scoretextView.text = "Your score: $score/6"

        val feedback = if (score >= 3){
            "Wow amazing job!"
        } else{
            "Ah Ah !"
        }
        feedbacktextView.text = feedback

        restartbutton.setOnClickListener {

            val intent = Intent(this, LearnerReviewScore::class.java)
            intent.putExtra("questions", MathsQuiz.questions)
            intent.putExtra("answers", MathsQuiz.answers)
            startActivity(intent)
        }
        exitbutton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

    }
}