package com.example.calculator
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var current = ""
    private var operator = ""
    private var firstValue = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.txtDisplay1)
    }

    fun onDigit(view: View) {
        val btn = view as Button
        current += btn.text
        display.text = current
    }

    fun onDecimal(view: View) {
        if (!current.contains(".")) {
            current += "."
            display.text = current
        }
    }
    fun onOperator(view: View) {
        val btn = view as Button
        operator = btn.text.toString()
        firstValue = current.toDoubleOrNull() ?: 0.0
        current = ""
    }
    fun onEqual(view: View) {
        val secondValue = current.toDoubleOrNull() ?: 0.0
        val result = when (operator) {
            "+" -> firstValue + secondValue
            "-" -> firstValue - secondValue
            "*" -> firstValue * secondValue
            "/" -> if (secondValue != 0.0) firstValue / secondValue else "Error"
            else -> secondValue
        }
        display.text = result.toString()
        current = result.toString()
        operator = ""
    }
    fun onClear(view: View) {
        current = ""
        operator = ""
        firstValue = 0.0
        display.text = "0"
    }
}



