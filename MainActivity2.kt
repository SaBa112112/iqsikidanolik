package com.example.iqsikidanoliki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var name1 : EditText
    private lateinit var name2 : EditText
    private lateinit var buttonST: Button
    private lateinit var buttonCL : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        buttonST = findViewById(R.id.buttonST)
        buttonST.setOnClickListener{nextPage()}

        buttonCL = findViewById(R.id.buttonCL)
        buttonCL.setOnClickListener {
            name1.text.clear()
            name2.text.clear()
        }
    }

    private fun nextPage() {
        name1 = findViewById(R.id.name1)
        name2 = findViewById(R.id.name2)

        Intent(this,MainActivity::class.java).also {
            it.putExtra("NAME1",name1.text.toString())
            it.putExtra("NAME2",name2.text.toString())
            startActivity(it)
        }
    }

/*    fun buttonCLS(clickedView : View){
        if(clickedView is Button){
         //   name1.setText("",TextView.BufferType.EDITABLE)
         //   name2.setText("",TextView.BufferType.EDITABLE)

            name1.text = Editable.Factory.getInstance().newEditable("")
            name2.text = Editable.Factory.getInstance().newEditable("")
        }
    }*/
}