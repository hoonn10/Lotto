package com.androidapp.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val RandomCard = findViewById<CardView>(R.id.RandomCard)

        RandomCard.setOnClickListener {
            startActivity(Intent(this@MainActivity, ResultActivity::class.java))
        }

        val constellationCard = findViewById<CardView>(R.id.constellationCard)

        constellationCard.setOnClickListener {
            startActivity(Intent(this@MainActivity, ConstellationActivity::class.java))
        }

        val NameCard = findViewById<CardView>(R.id.NameCard)

        NameCard.setOnClickListener {
            startActivity(Intent(this@MainActivity, NameActivity::class.java))
        }


    }
}