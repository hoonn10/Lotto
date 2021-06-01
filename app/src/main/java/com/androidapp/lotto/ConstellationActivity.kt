package com.androidapp.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

fun getShuffledLottoNumbersFromHash(str: String): MutableList<Int>{
    // 정수 list todtjd
    val list = mutableListOf<Int>()
    // list에 정수 저장
    for (number in 1..45){
        list.add(number)
    }

    val targetString = SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS", Locale.KOREA).format(Date()) + str

    // list 섞기. SEED 값으로 이름의 hash 코드 사용
    list.shuffle(Random(targetString.hashCode().toLong())) // 같은 seed 사용하면 항상 같은 sequence
    // 앞에서부터 6개 반환
    return list.subList(0, 6)
}

private fun makeConstellationString(month: Int, day: Int): String {
    val target = "${month+1}${String.format("%02d", day)}".toInt()
    when(target){
        in 101..119 -> return "염소자리"
        in 120..218 -> return "물병자리"
        in 219..320 -> return "물고기자리"
        in 321..419 -> return "양자리"
        in 420..520 -> return "황소자리"
        in 521..621 -> return "쌍둥이자리"
        in 622..722 -> return "게자리"
        in 723..822 -> return "사자자리"
        in 823..923 -> return "처녀자리"
        in 924..1022 -> return "천칭자리"
        in 1023..1122 -> return "전갈자리"
        in 1123..1224 -> return "사수자리"
        in 1225..1231 -> return "염소자리"
        else -> return "기타별자리"

    }
}


class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        val calendar = Calendar.getInstance()
        val btnGoResultConstell = findViewById<Button>(R.id.btnGoResultConstell)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val txtConstell = findViewById<TextView>(R.id.txtConstell)
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
        object : CalendarView.OnDateChangeListener, DatePicker.OnDateChangedListener{
            override fun onDateChanged(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                // 변경된 시점의 DatePicker 의 월, 일 정보로 별자리 텍스트 변경
                txtConstell.text = makeConstellationString(datePicker.month, datePicker.dayOfMonth)
            }
            override fun onSelectedDayChange(view: CalendarView, year: Int, month: Int, dayOfMonth: Int) {
                TODO("Not yet implemented")
            }



        })

        txtConstell.text= makeConstellationString(datePicker.month, datePicker.dayOfMonth)

        btnGoResultConstell.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getShuffledLottoNumbersFromHash(makeConstellationString(datePicker.month, datePicker.dayOfMonth))))
            //intent.putIntegerArrayListExtra(getShuffledLottoNumbersFromHash(txtConstell.text.toString()))
            intent.putExtra("constellation", makeConstellationString(datePicker.month, datePicker.dayOfMonth))
            startActivity(intent)
        }
    }


}