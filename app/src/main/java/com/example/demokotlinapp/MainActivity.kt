package com.example.demokotlinapp

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
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
        val msgBtn=findViewById<CardView>(R.id.messageView)
        val emailBtn=findViewById<CardView>(R.id.emailView)

        browserBtn.setOnClickListener(View.OnClickListener {
            val intents=Intent(Intent.ACTION_VIEW)
            val urlText=link.text.toString()
            intents.data= Uri.parse(urlText)
            startActivity(intents)
        })

        camerabtn.setOnClickListener(View.OnClickListener {
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)

        })

        msgBtn.setOnClickListener(View.OnClickListener {
            val intent=Intent(Intent.ACTION_CALL)
            startActivity(intent)

        })

        val webViewVariable=findViewById<WebView>(R.id.webView)
        webViewSetup(webViewVariable)
    }

    private fun webViewSetup(webView: WebView){
        webView.webViewClient= WebViewClient()
        webView.apply {
            loadUrl("https://www.github.com/SmileWithKhushi")
            settings.javaScriptEnabled=true


        }


    }
}