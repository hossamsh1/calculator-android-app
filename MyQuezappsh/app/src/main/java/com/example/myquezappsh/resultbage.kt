package com.example.myquezappsh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class resultbage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultbage)


        val tvname = findViewById<TextView>(R.id.tvname)
        val tvscore = findViewById<TextView>(R.id.tvscore)
        val butfinish = findViewById<Button>(R.id.butfinish)


        tvname.text = intent.getStringExtra(Constants.User_name)

        val totalquestions = intent.getIntExtra(Constants.Total_questions, 0)
        val correctanswers = intent.getIntExtra(Constants.Correct_answer, 0)

        tvscore.text = "your Score is   $correctanswers   out of   $totalquestions"


        butfinish.setOnClickListener {
            startActivity(Intent(this ,MainActivity::class.java))

            Toast.makeText(this, " الوزغ هو البرص ", Toast.LENGTH_SHORT).show()
        }
    }

 
}