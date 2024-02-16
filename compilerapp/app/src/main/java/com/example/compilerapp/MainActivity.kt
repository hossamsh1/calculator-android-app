package com.example.compilerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.compilerapp.databinding.ActivityMainBinding
import com.example.compilerapp.databinding.ActivityTestpagBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.buttest?.setOnClickListener {

            var intent = Intent(this, testpag::class.java)
            startActivity(intent)
        }

        binding?.NFA?.setOnClickListener {

            var intent = Intent(this, nfa::class.java)
            startActivity(intent)
        }

        binding?.DFA?.setOnClickListener {

            var intent = Intent(this, dfa::class.java)
            startActivity(intent)
        }

        binding?.lamp?.setOnClickListener {
            var intent = Intent(this, description::class.java)
            startActivity(intent)
        }

    }
}