package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Presentation: AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.presentation)

        val intent = intent

        val textname: TextView = findViewById(R.id.textView3)
        val textsurname: TextView = findViewById(R.id.textView4)
        val textmail: TextView =findViewById(R.id.textView5)
        val textphoneNumber: TextView = findViewById(R.id.textView6)
        val textmotdepasse: TextView = findViewById(R.id.textView7)
        val boutonInfo: Button = findViewById(R.id.button)
        val boutonRetour: Button =findViewById(R.id.button4)

        val name = intent.getStringExtra("name")
        val surname = intent.getStringExtra("surname")
        val email = intent.getStringExtra("email")
        val phoneNumber = intent.getStringExtra("phoneNumber")
        val password = intent.getStringExtra("password")

        textname.text = name
        textsurname.text = surname
        textmail.text= email
        textphoneNumber.text= phoneNumber
        textmotdepasse.text= password

        boutonInfo.setOnClickListener{
            val intent2 = Intent(this, Appel::class.java)
            intent2.putExtra("phoneNumber", phoneNumber)
            startActivity(intent2)
        }

        boutonRetour.setOnClickListener{
            finish()
        }


    }

}


