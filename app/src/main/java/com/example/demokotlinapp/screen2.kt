package com.example.demokotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        //button to move to home screen
        val screenbtn1=findViewById<Button>(R.id.firstScreenBtn)
        screenbtn1.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(applicationContext, "Moving to home screen..", Toast.LENGTH_SHORT).show()
                intent=Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        )

        //receving data from first screen and showing the data in the text view of second screen
        val messageFromPerson=intent.getStringExtra(MainActivity.KEY)
        val personTextArea=findViewById<TextView>(R.id.personDetails)
        personTextArea.text=messageFromPerson


    }
}