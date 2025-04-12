package com.example.p5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Date Picker
        val dateEditText : TextView = findViewById(R.id.dateTextView)
        val dateButton: Button = findViewById(R.id.dateButton)
        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog(this, { _, year, month, day ->
            val selectedDate = "$day/${month + 1}/$year"
            dateEditText.text = selectedDate
            Toast.makeText(this, "Kamu berhasil mengubah tanggal", Toast.LENGTH_SHORT).show()
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))

        dateButton.setOnClickListener {
            datePicker.show()
        }

        // Time Picker
        val timeTextView : TextView = findViewById(R.id.timeTextView)
        val timeButton: Button = findViewById(R.id.timeButton)
        val timePicker = TimePickerDialog(this, { _, hourOfDay, minute ->
            val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
            timeTextView.text = selectedTime
            Toast.makeText(this, "Kamu berhasil mengubah waktu", Toast.LENGTH_SHORT).show()
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true)

        timeButton.setOnClickListener {
            timePicker.show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}