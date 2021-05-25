package com.androidapp.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        val btnGoresult = findViewById<Button>(R.id.btnGoConstell);

        btnGoresult.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
        }
    }
}