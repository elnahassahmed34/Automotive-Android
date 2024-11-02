// MainActivity.kt
package com.example.lab

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var numberInput: EditText
    private lateinit var resultView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberInput = findViewById(R.id.numberInput)
        resultView = findViewById(R.id.resultView)

        findViewById<Button>(R.id.calculateButton).setOnClickListener {
            val number = numberInput.text.toString().toIntOrNull() ?: 0
            // Call Java method to calculate factorial
            val result = FactorialCalculator.calculateFactorial(number)
            // Show result
            resultView.text = "Factorial: $result"
            // Log the result
            logToConsole(result)
        }
    }

    companion object {
        @JvmStatic
        fun logToConsole(result: Int) {
            println("Factorial result is: $result")
        }
    }
}
