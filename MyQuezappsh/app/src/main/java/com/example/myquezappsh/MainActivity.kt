package com.example.myquezappsh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnstart:Button=findViewById(R.id.btn_start)
        val ettext:EditText=findViewById(R.id.et_name)
        btnstart.setOnClickListener {

            if(ettext.text.isEmpty()){
                Toast.makeText(this, "pleas enter your name", Toast.LENGTH_SHORT).show()
            }else{
                val intent= Intent(this,question_2::class.java)
               intent.putExtra(Constants.User_name,ettext.text.toString()) // enclude some information can you send from activity to another
                startActivity(intent)
                finish()
            }
        }
    }
}