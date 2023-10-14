package com.example.nontonbioskop

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.example.nontonbioskop.databinding.ActivityPaymentBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    private lateinit var tvSelectDate: TextView  // Menambahkan variabel untuk tvSelectDate

    private val cinema = arrayOf(
        "Select",
        "Ambarrukmo Mall",
        "Hartono Mall",
        "Jogja City Mall"
    )
    private val seat = arrayOf(
        "Select",
        "Reguler",
        "Exclusive",
        "Private"
    )

    private val method = arrayOf(
        "Select",
        "Bank Transfer",
        "Qris",
        "e-Money"
    )

    private val platform = arrayOf(
        "Select",
        "BCA",
        "BRI",
        "Mandiri"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvSelectDate = binding.tvSelectDate  // Inisialisasi tvSelectDate

        with(binding) {
            val title = intent.getStringExtra("title")
            txtTitle.text = title

            val adapterCinema = ArrayAdapter(this@PaymentActivity, android.R.layout.simple_spinner_item, cinema)
            adapterCinema.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCinema.adapter = adapterCinema

            val adapterSeat = ArrayAdapter(this@PaymentActivity, android.R.layout.simple_spinner_item, seat)
            adapterSeat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerSeat.adapter = adapterSeat

            val adapterMethod = ArrayAdapter(this@PaymentActivity, android.R.layout.simple_spinner_item, method)
            adapterMethod.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerMethod.adapter = adapterMethod

            val adapterPlatform = ArrayAdapter(this@PaymentActivity, android.R.layout.simple_spinner_item, platform)
            adapterPlatform.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerPlatform.adapter = adapterPlatform

            // Inisialisasi datePicker
            val datePickerButton = btnShowDatePicker

            datePickerButton.setOnClickListener {
                showDatePicker()
            }

            btnOrder.setOnClickListener {
                val selectedCinema = spinnerCinema.selectedItem.toString()
                val selectedSeat = spinnerSeat.selectedItem.toString()
                val selectedMethod = spinnerMethod.selectedItem.toString()
                val selectedPlatform = spinnerPlatform.selectedItem.toString()

                // Dapatkan tanggal dari tvSelectDate
                val selectedDate = tvSelectDate.text.toString()

                // Parsing tanggal yang terpilih
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val date = dateFormat.parse(selectedDate)
                val calendar = Calendar.getInstance()
                calendar.time = date

                val selectedDay = calendar.get(Calendar.DAY_OF_MONTH)
                val selectedMonth = calendar.get(Calendar.MONTH)
                val selectedYear = calendar.get(Calendar.YEAR)

                val intent = Intent(this@PaymentActivity, SummaryActivity::class.java)
                intent.putExtra("cinema", selectedCinema)
                intent.putExtra("seat", selectedSeat)
                intent.putExtra("method", selectedMethod)
                intent.putExtra("platform", selectedPlatform)
                intent.putExtra("date", selectedDay)
                intent.putExtra("month", selectedMonth)
                intent.putExtra("year", selectedYear)
                startActivity(intent)
            }
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            this, { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                tvSelectDate.text = formattedDate

            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.show()
    }
}
