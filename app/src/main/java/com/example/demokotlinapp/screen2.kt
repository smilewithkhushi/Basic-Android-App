package com.example.demokotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        val screenbtn1=findViewById<Button>(R.id.firstScreenBtn)

        screenbtn1.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(applicationContext, "Moving to home screen..", Toast.LENGTH_SHORT).show()
            intent=Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        )
    }
}