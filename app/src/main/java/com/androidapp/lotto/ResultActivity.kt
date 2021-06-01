package com.androidapp.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // 1. get result

        val result = intent.getIntegerArrayListExtra("result") ?: return
        val strConstellation = intent.getStringExtra("constellation")

        // 2. sort the array
        val result_sorted = result?.let { result.sortedBy{it} } //it는 데이터 테이블에 컬럼마다 제목이있다. 특정 소스를 분류할 수 있게 해줌 . . ?는 null아닐때 sort 실행
        //val result_sorted = result?.sorted()
        strConstellation?.let{
            val resultLabel = findViewById<TextView>(R.id.resultLabel)
            resultLabel.text = "${strConstellation}의 ${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())} 로또번호입니다."
        }
        /*result?.let{
            updateLottoBallImages(result.sortedBy {it})
        }*/

        //updateLottoBallImages(result_sorted)
        // 3. set Image
       val lottoImageStartId = R.drawable.ball_01

        val imageView1 = findViewById<ImageView>(R.id.imageView1)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        val imageView4 = findViewById<ImageView>(R.id.imageView4)
        val imageView5 = findViewById<ImageView>(R.id.imageView5)
        val imageView6 = findViewById<ImageView>(R.id.imageView6)

        imageView1.setImageResource(lottoImageStartId + (result_sorted[0] - 1))
        imageView2.setImageResource(lottoImageStartId + (result_sorted[1] - 1))
        imageView3.setImageResource(lottoImageStartId + (result_sorted[2] - 1))
        imageView4.setImageResource(lottoImageStartId + (result_sorted[3] - 1))
        imageView5.setImageResource(lottoImageStartId + (result_sorted[4] - 1))
        imageView6.setImageResource(lottoImageStartId + (result_sorted[5] - 1))

    }


    /*private fun updateLottoBallImages(result_sorted : List<Int>){
        val lottoImageStartId = R.drawable.ball_01

        val imageView1 = findViewById<ImageView>(R.id.imageView1)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        val imageView4 = findViewById<ImageView>(R.id.imageView4)
        val imageView5 = findViewById<ImageView>(R.id.imageView5)
        val imageView6 = findViewById<ImageView>(R.id.imageView6)

        imageView1.setImageResource(lottoImageStartId + (result_sorted[0]!! - 1))
        imageView2.setImageResource(lottoImageStartId + (result_sorted[1] - 1))
        imageView3.setImageResource(lottoImageStartId + (result_sorted[2] - 1))
        imageView4.setImageResource(lottoImageStartId + (result_sorted[3] - 1))
        imageView5.setImageResource(lottoImageStartId + (result_sorted[4] - 1))
        imageView6.setImageResource(lottoImageStartId + (result_sorted[5] - 1))
    }*/
}