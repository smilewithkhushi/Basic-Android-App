package com.example.demokotlinapp

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
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
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

        //creating static companion object to exchange  data between different screens
    companion object{
        const val KEY = "com.example.demokotlinapp.MainActivity.KEY"
    }
    lateinit var dialog1 : Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnUpload = findViewById<Button>(R.id.button_upload)
        val btnDownload = findViewById<Button>(R.id.button_download)
        val dark = findViewById<Button>(R.id.darktheme)
        val light = findViewById<Button>(R.id.lighttheme)
        val layout = findViewById<LinearLayout>(R.id.linearLayout)

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
        light.setOnClickListener{
            //change the app theme to light mode
            layout.setBackgroundResource(R.color.skyblue)
        }

        dark.setOnClickListener{
            //change the app theme to light mode
            layout.setBackgroundResource(R.color.purple_700)
        }

        //using explicit intent to migrate to another screen
        val secScreenbtn = findViewById<Button>(R.id.secondScreen)
        secScreenbtn.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "Moving to second scree", Toast.LENGTH_SHORT).show()
            intent = Intent(application, screen2::class.java)
            startActivity(intent)
        })


        //using card view and implicit intents

        val camerabtn = findViewById<CardView>(R.id.cameraView)
        val browserBtn = findViewById<Button>(R.id.webBtn)
        val link = findViewById<EditText>(R.id.browseLink)
        val msgBtn = findViewById<CardView>(R.id.messageView)
        val emailBtn = findViewById<CardView>(R.id.emailView)

        browserBtn.setOnClickListener {
            val intents = Intent(Intent.ACTION_VIEW)
            val urlText = link.text.toString()
            intents.data = Uri.parse(urlText)
            startActivity(intents)
        }

        camerabtn.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        msgBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            startActivity(intent)
        }

        val webViewVariable = findViewById<WebView>(R.id.webView)
        webViewSetup(webViewVariable)

        //exchanging data between two screens

        val personDetailButton = findViewById<Button>(R.id.personDetailBtn)
        val prsnName = findViewById<EditText>(R.id.personName)
        val prsnage = findViewById<EditText>(R.id.personAge)
        val prsncourse = findViewById<EditText>(R.id.personCourse)
        val prsnclg = findViewById<EditText>(R.id.personCollege)

        personDetailButton.setOnClickListener {
            Toast.makeText(applicationContext, "Your details have been saved!", Toast.LENGTH_SHORT)
                .show()
            val personMessage =
                "Hi there " + prsnName.text.toString() + ". You are " + prsnage.text.toString() + " years old. You are pursuing " + prsncourse.text.toString() + " course from " + prsnclg.text.toString() + " college!"
            intent = Intent(application, screen2::class.java)
            intent.putExtra(KEY, personMessage)
            startActivity(intent)
        }

        val alertbtn1 = findViewById<Button>(R.id.alertbtn1)
        val alertbtn2 = findViewById<Button>(R.id.alertbtn2)
        val alertbtn3 = findViewById<Button>(R.id.alertbtn3)

        alertbtn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Alert box 1")
            builder1.setMessage("Do you want to close the app?")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setPositiveButton(
                "Yes",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    //action performed when Yes is clicked
                    finish()
                })
            builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
            })
            builder1.show()
        }

        alertbtn2.setOnClickListener{
            val options = arrayOf("Kotlin", "Java", "JavaScript", "Python")
            val builder2=AlertDialog.Builder(this)
            builder2.setTitle("What is your favourite language?")
            builder2.setSingleChoiceItems(options, 0, DialogInterface.OnClickListener{
                dialog, which->
                Toast.makeText(this, "You Clicked on ${options[which]}", Toast.LENGTH_SHORT ).show()
            })
            builder2.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    //action performed when Yes is clicked
                })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
            })
            builder2.show()

        }

        alertbtn3.setOnClickListener{
            val options = arrayOf("Web Development", "Android Development", "AI ML", "Web3 and Blockchain")
            val builder2=AlertDialog.Builder(this)
            builder2.setTitle("What is your domain of interest?")
            builder2.setMultiChoiceItems(options, null, DialogInterface.OnMultiChoiceClickListener{
                    dialog, which, isChecked ->
                Toast.makeText(this, "You Clicked on ${options[which]}", Toast.LENGTH_SHORT ).show()
            })
            builder2.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    //action performed when Yes is clicked
                })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
            })
            builder2.show()
        }

        //customized dialog boxes , the variable of type dialogue has been created before
        val custAlertBox1=findViewById<Button>(R.id.custAlert1)
        val custAlertBox2=findViewById<Button>(R.id.custAlert2)

        custAlertBox1.setOnClickListener{

            dialog1=Dialog(this)
            dialog1.setContentView(R.layout.custom_dialog1)
            dialog1.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alertbox))

            //creating variables for the custom dialog .xml design
            var buttonGood = dialog1.findViewById<Button>(R.id.goodbtn)
            var buttonBad = dialog1.findViewById<Button>(R.id.badbtn)
            var buttonfeedback = dialog1.findViewById<Button>(R.id.feedbackbtn)

            buttonGood.setOnClickListener{
                dialog1.dismiss()
            }
            buttonBad.setOnClickListener {
                Toast.makeText(this, "Please fill the feedback form!", Toast.LENGTH_SHORT).show()
            }
            buttonfeedback.setOnClickListener {
                Toast.makeText(this, "Feedback form will be avaiable in a while!", Toast.LENGTH_SHORT).show()
            }

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