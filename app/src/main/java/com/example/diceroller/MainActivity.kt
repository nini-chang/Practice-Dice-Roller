package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.button)
        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener {
            rollDice()
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
        }
        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice1 = Dice(6)
        val dice2 = Dice(6)
        val diceRoll1: Int = dice1.roll()
        val diceRoll2: Int = dice2.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource1: Int = getDrawableResource(diceRoll1);
        val drawableResource2: Int = getDrawableResource(diceRoll2);

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2);

        // Update the content description
        diceImage.contentDescription = diceRoll1.toString()
        diceImage2.contentDescription = diceRoll2.toString()
    }

    private fun getDrawableResource(diceRoll: Int): Int {
        return when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}

/**
 * Dice with a fixed number of sides.
 */
class Dice (val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll (): Int {
        return (1..numSides).random()
    }
}