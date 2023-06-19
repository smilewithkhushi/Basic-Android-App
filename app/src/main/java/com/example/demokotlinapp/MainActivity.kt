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

        //creating static companion object to exchange  data between different screens
    companion object{
        const val KEY = "com.example.demokotlinapp.MainActivity.KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnUpload=findViewById<Button>(R.id.button_upload)
        val btnDownload=findViewById<Button>(R.id.button_download)
        val dark=findViewById<Button>(R.id.darktheme)
        val light=findViewById<Button>(R.id.lighttheme)
        val layout=findViewById<LinearLayout>(R.id.linearLayout)

        //use of toast in android
        btnUpload.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "Uploading..", Toast.LENGTH_SHORT).show()
        }
        )

        btnDownload.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "Downloading..", Toast.LENGTH_SHORT).show()
        }
        )

        //using buttons to change the layout theme or color
        light.setOnClickListener(View.OnClickListener {
            //change the app theme to light mode
            layout.setBackgroundResource(R.color.skyblue)

        })

        dark.setOnClickListener(View.OnClickListener {
            //change the app theme to light mode
            layout.setBackgroundResource(R.color.purple_700)

        })

        //using explicit intent to migrate to another screen
        val secScreenbtn=findViewById<Button>(R.id.secondScreen)
        secScreenbtn.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "Moving to second scree", Toast.LENGTH_SHORT).show()
            intent = Intent(application, screen2::class.java)
            startActivity(intent)
        })


        //using card view and implicit intents

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

        //exchanging data between two screens

        val personDetailButton=findViewById<Button>(R.id.personDetailBtn)
        val prsnName=findViewById<EditText>(R.id.personName)
        val prsnage=findViewById<EditText>(R.id.personAge)
        val prsncourse=findViewById<EditText>(R.id.personCourse)
        val prsnclg=findViewById<EditText>(R.id.personCollege)

        personDetailButton.setOnClickListener{
            Toast.makeText(applicationContext, "Your details have been saved!", Toast.LENGTH_SHORT).show()
            val personMessage="Hi there "+prsnName.text.toString()+". You are "+prsnage.text.toString()+" years old. You are pursuing "+prsncourse.text.toString()+" course from "+prsnclg.text.toString()+" college!"
            intent = Intent(application, screen2::class.java)
            intent.putExtra(KEY, personMessage)
            startActivity(intent)
        }
    }

    private fun webViewSetup(webView: WebView){
        webView.webViewClient= WebViewClient()
        webView.apply {
            loadUrl("https://www.github.com/SmileWithKhushi")
            settings.javaScriptEnabled=true
        }


    }
}