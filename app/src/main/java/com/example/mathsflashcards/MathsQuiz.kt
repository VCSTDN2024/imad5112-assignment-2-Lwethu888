package com.example.mathsflashcards

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MathsQuiz : AppCompatActivity() {

    private lateinit var questiontextView: TextView
    private lateinit var truebutton: Button
    private lateinit var falsebutton: Button
    private lateinit var nextbutton: Button
    private lateinit var feedbacktextView: TextView

    companion object{
        val questions = arrayOf(
            "An acute angle is always greater than 90 degrees",
            "The fraction 3/4 is equivalent to 0.75",
            "The number (pi) is a rational number",
            "A parallelogram has exactly one pair of parallel sides",
            "The sum of the interior angles of a triangle is always 180 degrees",
            "The prime number is divisible only by 1 and itself"
        )
        val answers = booleanArrayOf(false, true, false, false, true, true)
    }
    private var currentQuestionIndex = 0
    private var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_maths_quiz)

        questiontextView = findViewById(R.id.questiontextView)
        truebutton = findViewById(R.id.truebutton)
        falsebutton = findViewById(R.id.falsebutton)
        nextbutton = findViewById(R.id.nextbutton)
        feedbacktextView = findViewById(R.id.feedbacktextView)

        displayQuestion()

        truebutton.setOnClickListener { checkAnswer(true) }
        falsebutton.setOnClickListener { checkAnswer(false) }

        nextbutton.setOnClickListener {
            currentQuestionIndex ++
            if (currentQuestionIndex < questions.size){
                displayQuestion()
                feedbacktextView.text = ""
                truebutton.isEnabled = true
                falsebutton.isEnabled = true
            } else  {
                val intent = Intent(this, LearnerScore::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }
        nextbutton.isEnabled = false
    }
    private fun displayQuestion(){
        questiontextView.text = questions[currentQuestionIndex]

    }

    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = answers[currentQuestionIndex]

        if (userAnswer == correctAnswer){
            feedbacktextView.text = "Correct"
            feedbacktextView.setTextColor(Color.GREEN)
            score ++
        } else {
            feedbacktextView.text = "Incorrect"
            feedbacktextView.setTextColor(Color.RED)
        }
        truebutton.isEnabled = false
        falsebutton.isEnabled = false
        nextbutton.isEnabled=true
    }
}


