package com.droiddaemon.tic_tak_toe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    lateinit var buttons: Array<Array<Button>>
    private var playerOneTurn: Boolean = true
    private var roundCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val resetButton: Button = findViewById(R.id.reset_btn)
        resetButton.setOnClickListener {
            resetGame()
        }
        inti()

    }

    private fun inti() {

        buttons = Array(3) { r ->
            Array(3) { c ->
                initButtons(r, c)
            }

        }

    }

    private fun initButtons(r: Int, c: Int): Button {

        val btn: Button = findViewById(resources.getIdentifier("button_$r$c", "id", packageName))

        btn.setOnClickListener {
            btnClick(btn);
        }
        return btn;


    }

    private fun btnClick(btn: Button) {

        if (!btn.text.isNullOrEmpty()) return

        if (playerOneTurn) {
            btn.setText("X")

        } else {
            btn.setText("O")
        }

        roundCount++

        if (checkForWin()) {
            if (playerOneTurn) win(1) else win(2)
        } else if (roundCount == 9) {
            draw()
        } else {
            playerOneTurn = !playerOneTurn
        }


    }

    private fun draw() {
        Toast.makeText(applicationContext, "Game Draw", Toast.LENGTH_LONG).show()
        resetGame()

    }

    private fun win(i: Int) {
        if (playerOneTurn) {
            Toast.makeText(applicationContext, "Player 1 Wins", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(applicationContext, "Player 2 Wins", Toast.LENGTH_LONG).show()

        }
        resetGame()

    }

    private fun checkForWin(): Boolean {

        val field = Array(3) { r ->
            Array(3) { c ->
                buttons[r][c].text
            }

        }

        for (i in 0..2) {
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2] && field[i][0] != "") {
                return true
            }

        }

        for (i in 0..2) {
            if (field[0][i] == field[1][i] && field[0][i] == field[2][i] && field[0][i] != "") {
                return true
            }

        }

        if (field[0][0] == field[1][1] && field[0][0] == field[2][2] && field[0][0] != "") {
            return true
        }

        if (field[0][2] == field[1][1] && field[0][2] == field[2][0] && field[0][2] != "") {
            return true
        }



        return false


    }

    private fun resetGame() {
        roundCount = 0
        Array(3) { r ->
            Array(3) { c ->
                buttons[r][c].text = ""
            }

        }
    }
}