package com.merka.convertify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Home : AppCompatActivity() {
    private lateinit var massButton: Button
    private lateinit var lengthButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        lengthButton = findViewById(R.id.lengthButton)
        lengthButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                openMainActivity()
            }
        })

        massButton = findViewById(R.id.massButton)
        massButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                openMassActivity()
            }
        })
    }

    private fun openMassActivity() {
        val intent = Intent(this, Mass::class.java)
        startActivity(intent)
    }

    private fun openMainActivity() {
        val intent = Intent(this, Length::class.java)
        startActivity(intent)
    }
}
