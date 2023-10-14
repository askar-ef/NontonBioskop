package com.example.nontonbioskop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.nontonbioskop.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding){
            btnTicket.setOnClickListener{

                val x = binding.titleFilm
                val title = x.text.toString()
                val intentPayment = Intent(this@DetailsActivity, PaymentActivity::class.java)
                intentPayment.putExtra("title", title)
                startActivity(intentPayment)
                println(title)


            }
        }
    }
}

