package com.sampson.kotlinintegratedtestsemulated

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.sampson.kotlinintegratedtestsemulated.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var textFormatter: TextFormatter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textFormatter = TextFormatter(NumberAdder(), applicationContext)
        findViewById<Button>(R.id.button).setOnClickListener {
            textFormatter.getSumResult(
                findViewById<EditText>(R.id.edit_text).text.toString().toIntOrNull() ?: 0
            ) {
                findViewById<TextView>(R.id.text_view).text = it
            }
        }
    }
}


