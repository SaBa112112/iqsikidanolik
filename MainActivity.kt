package com.example.iqsikidanoliki

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var button1 : Button
    private lateinit var button2 : Button
    private lateinit var button3 : Button
    private lateinit var button4 : Button
    private lateinit var button5 : Button
    private lateinit var button6 : Button
    private lateinit var button7 : Button
    private lateinit var button8 : Button
    private lateinit var button9 : Button
    private lateinit var score1 : TextView
    private lateinit var score2 : TextView
    private lateinit var buttonRES : Button

    private var activePlayer = 1
    private var scr1 = 0
    private var scr2 = 0

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score1 = findViewById(R.id.score1)
        score2 = findViewById(R.id.score2)

        var n1 = intent.getStringExtra("NAME1")
        var n2 = intent.getStringExtra("NAME2")

        var k = findViewById<TextView>(R.id.n1).apply { text = n1 }
        var t = findViewById<TextView>(R.id.n2).apply { text = n2 }

        init()

    }
    private fun init(){
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
    }

    override fun onClick(clickedview: View?) {
        if (clickedview is Button) {
            var buttonnum = 0

            when (clickedview.id) {
                R.id.button1 -> buttonnum = 1
                R.id.button2 -> buttonnum = 2
                R.id.button3 -> buttonnum = 3
                R.id.button4 -> buttonnum = 4
                R.id.button5 -> buttonnum = 5
                R.id.button6 -> buttonnum = 6
                R.id.button7 -> buttonnum = 7
                R.id.button8 -> buttonnum = 8
                R.id.button9 -> buttonnum = 9
            }
            if (buttonnum != 0) {
                playGame(clickedview, buttonnum)
            }
        }
    }

    private fun playGame(clickedview : Button, buttonnum : Int) {
        if(activePlayer == 1){
            clickedview.text = "X"
            clickedview.setBackgroundColor(Color.GREEN)
            activePlayer = 2
            firstPlayer.add(buttonnum)
        }
        else if(activePlayer == 2){
            clickedview.text = "0"
            clickedview.setBackgroundColor(Color.RED)
            activePlayer = 1
            secondPlayer.add(buttonnum)
        }
        clickedview.isEnabled = false
        check()
    }
    private fun check(){
        var winnerPlayer = 0
        if(firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer = 2
        }

        if(firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2
        }

        if(firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }

        if(firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }

        if(firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2
        }

        if(firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }

        if(firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }

        if(firstPlayer.contains(7) && firstPlayer.contains(5) && firstPlayer.contains(3)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(7) && secondPlayer.contains(5) && secondPlayer.contains(3)){
            winnerPlayer = 2
        }



        if(winnerPlayer == 1){
            Toast.makeText(this, "გამარჯვებულია პირველი",Toast.LENGTH_SHORT).show()
            gameOver()
            scr1 += 1
            score1.text = "$scr1"
        }
        if(winnerPlayer == 2){
            Toast.makeText(this, "გამარჯვებულია მეორე",Toast.LENGTH_SHORT).show()
            gameOver()
            scr2 += 1
            score2.text = "$scr2"
        }
        if(firstPlayer.size + secondPlayer.size == 9 && winnerPlayer == 0){
            Toast.makeText(this, "ფრეა",Toast.LENGTH_SHORT).show()
            gameOver()
        }
    }

    fun gameOver(){
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
    }

    fun buttonR(clickedview: View?){
        if(clickedview is Button) {
            activePlayer = 1
            firstPlayer.clear()
            secondPlayer.clear()

            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""

            button1.setBackgroundColor(Color.parseColor("#FFBB86FC"))
            button2.setBackgroundColor(Color.parseColor("#FFBB86FC"))
            button3.setBackgroundColor(Color.parseColor("#FFBB86FC"))
            button4.setBackgroundColor(Color.parseColor("#FFBB86FC"))
            button5.setBackgroundColor(Color.parseColor("#FFBB86FC"))
            button6.setBackgroundColor(Color.parseColor("#FFBB86FC"))
            button7.setBackgroundColor(Color.parseColor("#FFBB86FC"))
            button8.setBackgroundColor(Color.parseColor("#FFBB86FC"))
            button9.setBackgroundColor(Color.parseColor("#FFBB86FC"))

            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true

        }
    }
    fun buttonRES(clickedview: View?) {
        if (clickedview is Button) {

            buttonR(clickedview)

            if(scr1 != 0 && scr2 != 0){
                score1.text = "0"
                score2.text = "0"

                scr1 = 0
                scr2 = 0
            }
            buttonRES.setOnClickListener{ Intent(this,MainActivity2::class.java) }
        }
    }
}