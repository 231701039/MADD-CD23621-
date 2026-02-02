package com.example.assignment1

import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isBgChanged = false
    private var count = 1
    private var isTextBig = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = findViewById<LinearLayout>(R.id.main)

        val btnBg = findViewById<Button>(R.id.buttonBg)
        val btnInc = findViewById<Button>(R.id.buttonInc)
        val btnDec = findViewById<Button>(R.id.buttonDec)
        val btnSize = findViewById<Button>(R.id.buttonSize)
        val btnBMI = findViewById<Button>(R.id.btnBMI)
        val btnConvert = findViewById<Button>(R.id.btnConvert)

        val tvCount = findViewById<TextView>(R.id.textView)
        val tvBmiResult = findViewById<TextView>(R.id.tvBmiResult)
        val tvTempResult = findViewById<TextView>(R.id.tvTempResult)

        val etWeight = findViewById<EditText>(R.id.etWeight)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val etCelsius = findViewById<EditText>(R.id.etCelsius)


        btnBg.setOnClickListener {
            isBgChanged = !isBgChanged
            layout.setBackgroundColor(
                if (isBgChanged) Color.CYAN else Color.WHITE
            )
        }

        btnInc.setOnClickListener {
            count++
            tvCount.text = count.toString()
        }

        btnDec.setOnClickListener {
            if (count > 0) count--
            tvCount.text = count.toString()
        }

        btnSize.setOnClickListener {
            isTextBig = !isTextBig
            tvCount.textSize = if (isTextBig) 36f else 24f
        }


        btnBMI.setOnClickListener {
            val weightStr = etWeight.text.toString()
            val heightStr = etHeight.text.toString()

            if (weightStr.isNotEmpty() && heightStr.isNotEmpty()) {
                val weight = weightStr.toFloat()
                val height = heightStr.toFloat()

                if (height > 0) {
                    val bmi = weight / (height * height)
                    tvBmiResult.text = "BMI: %.2f".format(bmi)
                } else {
                    tvBmiResult.text = "Height must be greater than 0"
                }
            } else {
                tvBmiResult.text = "Please enter weight and height"
            }
        }

        btnConvert.setOnClickListener {
            val celsiusStr = etCelsius.text.toString()

            if (celsiusStr.isNotEmpty()) {
                val celsius = celsiusStr.toFloat()
                val fahrenheit = (celsius * 9 / 5) + 32
                tvTempResult.text = "Fahrenheit: %.2f °F".format(fahrenheit)
            } else {
                tvTempResult.text = "Please enter temperature"
            }
        }
    }
}
