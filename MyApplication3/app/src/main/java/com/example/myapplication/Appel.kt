package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Appel : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.appel)

        val intent2 = intent

        val textPhoneNumber: TextView = findViewById(R.id.textView8)
        val boutonAppel: Button = findViewById(R.id.button3)
        val boutonRetour: Button = findViewById(R.id.button5)

        val phoneNumber= intent2.getStringExtra("phoneNumber")

        textPhoneNumber.text= phoneNumber

        boutonAppel.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }

        boutonRetour.setOnClickListener {
            finish()
        }






    }
}
