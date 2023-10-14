package com.example.nontonbioskop

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nontonbioskop.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySummaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedCinema = intent.getStringExtra("cinema")
        val selectedSeat = intent.getStringExtra("seat")
        val selectedMethod = intent.getStringExtra("method")
        val selectedPlatform = intent.getStringExtra("platform")
        val selectedDate = intent.getIntExtra("date", 0)
        val selectedMonth = intent.getIntExtra("month", 0)
        val selectedYear = intent.getIntExtra("year", 0)

        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "")

        binding.txtUsername.text = username
        binding.txtCinema.text = selectedCinema
        binding.txtSeat.text = selectedSeat
        binding.txtMethod.text = selectedMethod
        binding.txtPlatform.text = selectedPlatform
        binding.txtDate.text = "$selectedDate-$selectedMonth-$selectedYear"
        binding.txtSeatLevel.text = "$selectedSeat Seat"

    }
}