package com.example.compilerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.compilerapp.databinding.ActivityDfaBinding
import com.example.compilerapp.databinding.ActivityMainBinding

class dfa : AppCompatActivity() {
    private var binding: ActivityDfaBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDfaBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.lamp?.setOnClickListener {
            var intent = Intent(this, description::class.java)
            startActivity(intent)
        }

    }
}