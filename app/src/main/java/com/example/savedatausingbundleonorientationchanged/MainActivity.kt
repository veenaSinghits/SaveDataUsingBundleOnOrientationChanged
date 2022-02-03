package com.example.savedatausingbundleonorientationchanged

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // instances of all the UI elements
    lateinit var editText: EditText
    lateinit var counterText: TextView
    lateinit var incrementB: Button
    lateinit var decrementB: Button

    // counter to increment or
    // decrement the counter text
    var countInt: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // register all the UI elements with
        // their appropriate IDs
        editText = findViewById(R.id.editText)
        incrementB = findViewById(R.id.incrementB)
        decrementB = findViewById(R.id.decrementB)
        counterText = findViewById(R.id.counterText)

        // handle the increment button
        incrementB.setOnClickListener {
            if (countInt >= 0) {
                countInt++
                counterText.text = countInt.toString()
            }
        }

        // handle the decrement button
        decrementB.setOnClickListener {
            if (countInt > 0) {
                countInt--
                counterText.text = countInt.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // put the unique key value with the data
        // to be restored after configuration changes
        outState.putInt("counterData", countInt)
        Log.v("Veena","onSave")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        // get the stored data from the bundle using the unique key
        countInt = savedInstanceState.getInt("counterData")

        // update the UI
        counterText.text = countInt.toString()
        Log.v("Veena","onRestore")
    }
}
