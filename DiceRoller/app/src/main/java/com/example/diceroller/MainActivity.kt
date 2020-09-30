package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    lateinit var diceImageA: ImageView
    lateinit var diceImageB: ImageView
    lateinit var resultTextA : TextView
    lateinit var resultTextB : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImageA = findViewById(R.id.dice_imageA)
        diceImageB = findViewById(R.id.dice_imageB)
        resultTextA = findViewById(R.id.result_textA)
        resultTextB = findViewById(R.id.result_textB)

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
        var randomInt: Int = (1..6).random()
        var randomInt2: Int = (1..6).random()
        resultTextA.text = randomInt.toString()
        resultTextB.text = randomInt2.toString()
        diceImageA.setImageResource(manageDiceRes(randomInt))
        diceImageB.setImageResource(manageDiceRes(randomInt2))

    }
    private fun countUp() {
        when {
            //Edge case requirements
            resultTextA.text.toString() == getString(R.string.hello_world) -> resultTextA.text = "1"
            resultTextA.text.toString() == "6" -> {}
            else -> {
                var i : Int = resultTextA.text.toString().toInt()
                resultTextA.text = (++i).toString()
            }
        }
        when {
            resultTextB.text.toString() == "" -> resultTextB.text = "1"
            resultTextB.text.toString() == "6" -> {}
            else -> {
                var i : Int = resultTextB.text.toString().toInt()
                resultTextB.text = (++i).toString()
            }
        }
        //Redraw the dice image to new number
        diceImageA.setImageResource(manageDiceRes(resultTextA.text.toString().toInt()))
        diceImageB.setImageResource(manageDiceRes(resultTextB.text.toString().toInt()))
    }
    private fun resetCount() {
        resultTextA.text = "0"
        resultTextB.text = "0"
        diceImageA.setImageResource(R.drawable.empty_dice)
        diceImageB.setImageResource(R.drawable.empty_dice)
    }
    private fun manageDiceRes(decider : Int) : Int {
        return when (decider) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}