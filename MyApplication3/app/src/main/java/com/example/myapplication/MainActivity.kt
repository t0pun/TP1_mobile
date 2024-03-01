package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boutonEnvoi: Button = findViewById(R.id.button2)
        val editTextName: TextInputEditText= findViewById(R.id.name)
        val nameLayout: TextInputLayout= findViewById(R.id.nameLayout)
        val editTextSurname: TextInputEditText= findViewById(R.id.surname)
        val surnameLayout: TextInputLayout= findViewById(R.id.surnameLayout)
        val editTextEmail: TextInputEditText= findViewById(R.id.email)
        val emailLayout: TextInputLayout= findViewById(R.id.emailLayout)
        val editTextPhone: TextInputEditText= findViewById(R.id.phoneNumber)
        val phoneNumberLayout: TextInputLayout= findViewById(R.id.phoneNumberLayout)
        val editTextPassword: TextInputEditText= findViewById(R.id.password)
        val passwordLayout: TextInputLayout= findViewById(R.id.passwordLayout)


        boutonEnvoi.setOnClickListener{
            val name = editTextName.text.toString()
            val surname= editTextSurname.text.toString()
            val email= editTextEmail.text.toString()
            val phoneNumber= editTextPhone.text.toString()
            val password= editTextPassword.text.toString()
            //Toast.makeText(this, "salut bébé",Toast.LENGTH_SHORT).show()

            if(name.isEmpty() || name.contains(Regex("\\d"))){
                nameLayout.error= "le champ saisi contient une erreur"
            }
            if(surname.isEmpty() || surname.contains(Regex("\\d"))){
                surnameLayout.error= "le champ saisi contient une erreur"
            }
            val emailPattern= Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
            if(email.isEmpty() || !email.matches(emailPattern)){
                emailLayout.error= "adresse email invalide"
            }
            val phoneNumberPattern = Regex("^(0|\\+33|0033)[1-9][1-9][0-9]{8}$")
            if(phoneNumber.isEmpty() || phoneNumber.matches(phoneNumberPattern)){
                phoneNumberLayout.error= "numero de téléphone invalide"
            }
            val passwordPattern = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
            if (password.isEmpty() || password.matches(passwordPattern)){
                passwordLayout.error= "mot de passe invalide"
            }else{
                val builder = AlertDialog.Builder(this)
                    .setTitle("Confirmation")
                    .setMessage("Voulez-vous enregistrer les informations ?")
                    .setPositiveButton("Oui") { dialog, _ ->
                        val stockName = name
                        editTextName.text?.clear()
                        val stockSurname= surname
                        editTextSurname.text?.clear()
                        val stockEmail= email
                        editTextEmail.text?.clear()
                        val stockPhoneNumber= phoneNumber
                        editTextPhone.text?.clear()
                        val stockPassword= password
                        editTextPassword.text?.clear()
                        Toast.makeText(this, "Informations enregistrées", Toast.LENGTH_SHORT).show()
                        dialog.dismiss() // Ferme la boîte de dialogue
                        val intent = Intent(this, Presentation::class.java)
                        intent.putExtra("name", name)
                        intent.putExtra("surname", surname)
                        intent.putExtra("email", email)
                        intent.putExtra("phoneNumber", phoneNumber)
                        intent.putExtra("password", password)
                        startActivity(intent)
                    }
                    .setNegativeButton("Non") { dialog, _ ->
                        // Actions à effectuer lorsque l'utilisateur clique sur "Non"
                        Toast.makeText(this, "Annulé", Toast.LENGTH_SHORT).show()
                        dialog.dismiss() // Ferme la boîte de dialogue
                    }

                val dialog = builder.create()
                dialog.show()

            }

        }
    }
}




