package com.androidapp.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import java.util.*

fun getRandomLottoNumber (): Int{
    return Random().nextInt(45)+1
}

fun getRandomLottoNumbers(): MutableList<Int>{
    val lottoNumbers = mutableListOf<Int>()

    while(true){ //중복방지지
       var number: Int = getRandomLottoNumber()
        var flag_existing: Int = 0
        //for(j in 0..lottoNumbers.size) {
            if(lottoNumbers.contains((number))){
            //if (number.equals((lottoNumbers[j]))) {
            flag_existing = 1
            //break;
                continue
        }
/*        if(flag_existing.equals(1))
            continue
        else*/
        lottoNumbers.add(number)
        if(lottoNumbers.size >= 6)
            break;
    }

    /*for(i in 1..6){
        lottoNumbers.add(getRandomLottoNumber())
    }*/
    return lottoNumbers
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val RandomCard = findViewById<CardView>(R.id.RandomCard)

        RandomCard.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))
            startActivity(intent)
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