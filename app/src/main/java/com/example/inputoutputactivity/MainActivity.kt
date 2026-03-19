package com.example.inputoutputactivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //get the button using the id we set on the user interface
        val clickMeButton = findViewById<Button>(R.id.clickbutton)
        val welcomeTxt =findViewById<TextView>(R.id.displayTxt)
        val nameTxtField = findViewById<EditText>(R.id.nameTxt)
        //get the switch that turns on the zulu greeting
        val zuluSwitch = findViewById<Switch>(R.id.zuluSwitch)

        //add the code to the button that happens when clicked
        clickMeButton.setOnClickListener {
             welcomeTxt.text ="welcome. ${nameTxtField}.text!"}

        //add the code to the button
        clickMeButton?.setOnClickListener {
            var greeting: String
            var zulu: Boolean
            var age: 18
            if (zuluSwitch.isChecked) {
                greeting = "sawubona, ${nameTxtField.text}!"
            } else {
                //easter egg for Otha
                if ((nameTxtField.text.toString() == "Otha" ||
                     nameTxtField.text.toString() == "Otha")
                      && age > 18) {
                    greeting = "Yo.${nameTxtField.text}!"
                } else {
                    greeting = "greetings, ${nameTxtField.text}!"
                }
            }
            welcomeTxt.text =greeting

            //

            Toast.makeText(this@MainActivity,
                "Button clicked",Toast.LENGTH_LONG).show()
            //

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}