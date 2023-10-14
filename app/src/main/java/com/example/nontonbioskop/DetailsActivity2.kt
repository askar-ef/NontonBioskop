package com.example.nontonbioskop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nontonbioskop.databinding.ActivityDetails2Binding

class DetailsActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityDetails2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetails2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            with(binding) {
                btnTicket.setOnClickListener {

                    val x = binding.titleFilm
                    val title = x.text.toString()
                    val intentPayment = Intent(this@DetailsActivity2, PaymentActivity::class.java)
                    intentPayment.putExtra("title", title)
                    startActivity(intentPayment)
                    println(title)
                }

            }
        }
    }
}