package com.example.compilerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.compilerapp.databinding.ActivityTestpagBinding

class testpag : AppCompatActivity() {



    private lateinit var inputEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var acceptedImageView: ImageView
    private lateinit var rejectedImageView: ImageView

    private var binding: ActivityTestpagBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestpagBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        inputEditText = findViewById(R.id.inputEditText)
        submitButton = findViewById(R.id.submitButton)
        acceptedImageView = findViewById(R.id.imvaccept)
        rejectedImageView = findViewById(R.id.imvregect)


        submitButton.setOnClickListener {
            val input = inputEditText.text.toString()
            val result = processInput(input)

            if (result == 2 || result == 23 || result == 12) { acceptedImageView.setImageResource(R.drawable.accept)
                acceptedImageView.visibility = View.VISIBLE
                rejectedImageView.visibility = View.INVISIBLE

                Toast.makeText(this, "ACCEPT", Toast.LENGTH_SHORT).show()
            } else {
                rejectedImageView.setImageResource(R.drawable.regect)
                rejectedImageView.visibility = View.VISIBLE
                acceptedImageView.visibility = View.INVISIBLE

                Toast.makeText(this, "REJECT", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun processInput(input: String): Int {
        var state = 1

        for (ch in input.toCharArray()) {
            when (state) {
                1 -> {
                    if (ch == 'a') {
                        state = 2
                    } else {
                        state = -1
                    }
                }
                2 -> {
                    if (ch == 'a') {
                        state = 1
                    } else if (ch == 'b') {
                        state = 23
                    } else {
                        state = -1
                    }
                }
                23 -> {
                    if (ch == 'a') {
                        state = 12
                    } else if (ch == 'b') {
                        state = 23
                    } else {
                        state = -1
                    }
                }
                12 -> {
                    if (ch == 'a') {
                        state = 12
                    } else if (ch == 'b') {
                        state = 23
                    } else {
                        state = -1
                    }
                }
            }
        }

        return state
    }


    }
