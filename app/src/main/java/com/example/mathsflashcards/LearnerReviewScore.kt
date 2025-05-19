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

class LearnerReviewScore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_learner_review_score)

        val learnerreviewscoretextView = findViewById<TextView>(R.id.learnerreviewscoretextView)
        val restartbutton = findViewById<Button>(R.id.restartbutton)
        val exitbutton = findViewById<Button>(R.id.exitbutton)

        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val reviewText = StringBuilder()
        if (questions != null && answers != null && questions.size == answers.size) {
            for (i in questions.indices) {
                reviewText.append("${i + 1}. ${questions[i]} \n")
                reviewText.append("   Answer: ${if (answers[i]) "True" else "False"}\n\n")
            }
            learnerreviewscoretextView.text = reviewText.toString()
        } else {
            learnerreviewscoretextView.text = "Failed to retrieve review data"
        }
        restartbutton.setOnClickListener {
            startActivity(Intent(this, MathsQuiz::class.java))
        }
        exitbutton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
          }
        }
}