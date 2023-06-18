package com.example.demokotlinapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintSet.Constraint

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnUpload=findViewById<Button>(R.id.button_upload)
        val btnDownload=findViewById<Button>(R.id.button_download)
        val dark=findViewById<Button>(R.id.darktheme)
        val light=findViewById<Button>(R.id.lighttheme)
        val layout=findViewById<LinearLayout>(R.id.linearLayout)

        btnUpload.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "Uploading..", Toast.LENGTH_SHORT).show()
        }
        )

        btnDownload.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "Downloading..", Toast.LENGTH_SHORT).show()
        }
        )

        light.setOnClickListener(View.OnClickListener {
            //change the app theme to light mode
            layout.setBackgroundResource(R.color.skyblue)

        })

        dark.setOnClickListener(View.OnClickListener {
            //change the app theme to light mode
            layout.setBackgroundResource(R.color.purple_700)

        })


        val secScreenbtn=findViewById<Button>(R.id.secondScreen)
        secScreenbtn.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "Moving to second scree", Toast.LENGTH_SHORT).show()
            intent = Intent(application, screen2::class.java)
            startActivity(intent)
        })

        val camerabtn=findViewById<CardView>(R.id.cameraView)
        val browserBtn=findViewById<Button>(R.id.webBtn)
        val link=findViewById<EditText>(R.id.browseLink)

        browserBtn.setOnClickListener(View.OnClickListener {
            val intents=Intent(Intent.ACTION_VIEW)
            val urlText=link.getText().toString()
            intent.data= Uri.parse(urlText)
            startActivity(intent)
        })



    }
}