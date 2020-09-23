package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }

        val countUpButton: Button = findViewById(R.id.count_up)
        countUpButton.setOnClickListener {
            countUp()
        }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener {
            resetCount()
        }
    }

    private fun rollDice() {
        //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = (1..6).random().toString()
    }
    private fun countUp() {
        val rT : TextView = findViewById(R.id.result_text)
        when {
            //Edge case requirements
            rT.text.toString() == getString(R.string.hello_world) -> rT.text = "1"
            rT.text.toString() == "6" -> {}
            else -> {
                var i : Int = rT.text.toString().toInt()
                rT.text = (++i).toString()
            }
        }
    }
    private fun resetCount() {
        val rT: TextView = findViewById(R.id.result_text)
        rT.text = "0"
    }
}