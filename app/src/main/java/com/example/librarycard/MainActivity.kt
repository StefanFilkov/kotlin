package com.example.librarycard   // <- keep your own package

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private val facultyNumber = "22621824"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvTitle: TextView = findViewById(R.id.tvTitle)
        val etCardCode: EditText = findViewById(R.id.etCardCode)
        val etUniversity: EditText = findViewById(R.id.etUniversity)
        val etFullName: EditText = findViewById(R.id.etFullName)
        val btnCheck: Button = findViewById(R.id.btnCheck)
        val tvCardResult: TextView = findViewById(R.id.tvCardResult)
        val tvUnivResult: TextView = findViewById(R.id.tvUnivResult)
        val tvNameResult: TextView = findViewById(R.id.tvNameResult)
        val tvConfirm: TextView = findViewById(R.id.tvConfirm)

        tvTitle.text = "Карта за библиотека на $facultyNumber"

        btnCheck.setOnClickListener {
            val cardCode = etCardCode.text.toString().trim()
            val university = etUniversity.text.toString().trim()
            val fullName = etFullName.text.toString().trim()

            var isValid = true

            etCardCode.error = null
            etUniversity.error = null
            etFullName.error = null
            tvConfirm.text = ""

            if (cardCode.isEmpty() || cardCode != facultyNumber) {
                etCardCode.error = "Моля въведете код на карта"
                isValid = false
            }
            if (university.isEmpty()) {
                etUniversity.error = "Моля въведете университет"
                isValid = false
            }
            if (fullName.isEmpty()) {
                etFullName.error = "Моля въведете име и фамилия"
                isValid = false
            }

            if (!isValid) {
                Toast.makeText(this, "Моля попълнете всички полета", Toast.LENGTH_SHORT).show()
                Log.i(facultyNumber, "Validation FAILED – missing data")
                return@setOnClickListener
            }

            tvCardResult.text = "Карта No.: $cardCode"
            tvUnivResult.text = "Университет: $university"
            tvNameResult.text = "Име: $fullName"
            tvConfirm.text = "Успешна валидация и създадена карта."

            Log.i(facultyNumber, "Validation OK – card=$cardCode, university=$university, name=$fullName")
            Toast.makeText(this, "Данните са приети.", Toast.LENGTH_SHORT).show()
        }
    }
}
