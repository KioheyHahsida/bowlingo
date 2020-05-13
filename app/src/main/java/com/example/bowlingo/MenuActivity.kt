package com.example.bowlingo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_STRIKE = "com.example.bowlingo.SETTING_1"
const val EXTRA_GUTTER = "com.example.bowlingo.SETTING_2"
const val EXTRA_FOUL= "com.example.bowlingo.SETTING_3"
const val EXTRA_COLROW= "com.example.bowlingo.SETTING_4"


class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.bowlingo.R.layout.activity_menu)

        var strike = 0
        var gutter = 1
        var foul = 1

        val switch1: Switch = findViewById(R.id.switch1)
        switch1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                strike = 1
            }else{
                strike = 0
            }
        }
        val switch2: Switch = findViewById(R.id.switch2)
        switch2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                gutter = 0
            } else {
                gutter = 1
            }
        }
        val switch3: Switch = findViewById(R.id.switch3)
        switch3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                foul = 0
            }else{
                foul = 1
            }
        }

        val numPicker = findViewById<NumberPicker>(R.id.numPicker)
        numPicker.wrapSelectorWheel = false
        val values = arrayOf("3", "5", "7")
        numPicker.minValue = 0
        numPicker.maxValue = values.size-1
        numPicker.displayedValues = values



        val start: Button = findViewById(R.id.start)
        start.setOnClickListener {
            val colRow = numPicker.value * 2 + 3
            when(colRow){
                3 ->{
                    val intent = Intent(this@MenuActivity, MainActivity3::class.java).apply {
                        putExtra(EXTRA_COLROW,colRow)
                        putExtra(EXTRA_STRIKE,strike)
                        putExtra(EXTRA_GUTTER,gutter)
                        putExtra(EXTRA_FOUL, foul)
                    }
                    startActivity(intent);
                }
                5 ->{
                    val intent = Intent(this@MenuActivity, MainActivity5::class.java).apply {
                        putExtra(EXTRA_COLROW,colRow)
                        putExtra(EXTRA_STRIKE,strike)
                        putExtra(EXTRA_GUTTER,gutter)
                        putExtra(EXTRA_FOUL, foul)
                    }
                    startActivity(intent);
                }
                7 ->{
                    val intent = Intent(this@MenuActivity, MainActivity7::class.java).apply {
                        putExtra(EXTRA_COLROW,colRow)
                        putExtra(EXTRA_STRIKE,0)
                        putExtra(EXTRA_GUTTER, 0)
                        putExtra(EXTRA_FOUL, 0)
                    }
                    startActivity(intent);
                }
            }
        }
    }
}
