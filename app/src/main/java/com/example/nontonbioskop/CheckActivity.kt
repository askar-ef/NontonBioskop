package com.example.nontonbioskop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nontonbioskop.databinding.ActivityCheckBinding

class CheckActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCheckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            val title = intent.getStringExtra("abu")
            binding.txtTitle.text = title
        }
    }
}