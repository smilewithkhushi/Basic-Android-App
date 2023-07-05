package com.example.demokotlinapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class imageGallery : AppCompatActivity() {

    var currentImage = 0
    lateinit var image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_gallery)

        supportActionBar?.hide() //saves the app from crashing

        val prev = findViewById<ImageButton>(R.id.previousButton)
        val next = findViewById<ImageButton>(R.id.nextButton)

        val idCurrentImage= "pic$currentImage"
        //convert string it into integer address associated with it
        val idCurrentImageInt= this.resources.getIdentifier(idCurrentImage, "id", packageName)
        image = findViewById(idCurrentImageInt)

        prev.setOnClickListener {
            image.alpha=0f
            currentImage=(10 + currentImage-1)%10

            val idImageToShowString = "pic$currentImage"
            //convert string it into integer address associated with it
            val idImageToShowInt= this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha=1f
        }

        next.setOnClickListener {
            image.alpha=0f
            currentImage=(10 + currentImage+1)%10

            val idImageToShowString = "pic$currentImage"
            //convert string it into integer address associated with it
            val idImageToShowInt= this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha=1f
        }


    }
}