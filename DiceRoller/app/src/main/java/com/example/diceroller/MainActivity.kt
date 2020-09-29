package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    lateinit var rT : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)
        rT = findViewById(R.id.result_text)
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
        rT.text = randomInt.toString()
        val drawableRes = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableRes)
    }
    private fun countUp() {
        when {
            //Edge case requirements
            rT.text.toString() == getString(R.string.hello_world) -> rT.text = "1"
            rT.text.toString() == "6" -> {}
            else -> {
                var i : Int = rT.text.toString().toInt()
                rT.text = (++i).toString()
            }
        }
        //Redraw the dice image
        val drawableRes = when (rT.text.toString().toInt()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> {
                R.drawable.dice_6
            }
        }
        diceImage.setImageResource(drawableRes)
    }
    private fun resetCount() {
        rT.text = "0"
        diceImage.setImageResource(R.drawable.empty_dice)
    }
}