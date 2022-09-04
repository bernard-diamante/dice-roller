package com.bernarddiamante.diceroller

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bernarddiamante.diceroller.databinding.ActivityMainBinding


const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Roll dice
        binding.btRoll.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()

            rollDice(binding.ivDice1)
            rollDice(binding.ivDice2)

        }
    }

    /*
    * Roll the dice and update the dice images.
    * */
    private fun rollDice(ivDice: ImageView) {
        // Create new Dice object with x number of sides and roll
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Select image based on roll result
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Display dice image
        ivDice.setImageResource(drawableResource)
        ivDice.contentDescription = diceRoll.toString()
    }


    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}