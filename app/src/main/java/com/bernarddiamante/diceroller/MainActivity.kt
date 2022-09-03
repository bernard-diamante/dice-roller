package com.bernarddiamante.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bernarddiamante.diceroller.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity.kt"
        const val numSides = 6
    }
    private lateinit var binding: ActivityMainBinding
    private var result by Delegates.notNull<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Roll dice
        binding.btRoll.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()

            val rollResult1 = rollDice()
            binding.tvRollNumber1.text = rollResult1.toString()
            val rollResult2 = rollDice()
            binding.tvRollNumber2.text = rollResult2.toString()

            when {
                rollResult1 > rollResult2 -> binding.tvResult.text = ">:D"
                rollResult1 < rollResult2 -> binding.tvResult.text = ":'("
                rollResult1 == rollResult2 -> binding.tvResult.text = ":/"
            }
        }
    }

    private fun rollDice(): Int {
        val dice = Dice(numSides)
        return dice.roll()

    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}