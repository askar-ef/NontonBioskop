package com.example.nontonbioskop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.nontonbioskop.databinding.ActivityMainBinding
import com.example.nontonbioskop.databinding.ActivityMenuBinding
import com.example.nontonbioskop.databinding.ActivityToolbarBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val txtName = findViewById<TextView>(R.id.txt_name)
        val username = intent.getStringExtra("username")
        txtName.text = username

        with(binding){
            film1.setOnClickListener{
                val intentDetails = Intent(this@MenuActivity, DetailsActivity::class.java)
                intentDetails.putExtra("username", username)
                startActivity(intentDetails)
            }
            film2.setOnClickListener {
                val intentDetails2 = Intent(this@MenuActivity, DetailsActivity2::class.java)
                intentDetails2.putExtra("username", username)
                startActivity(intentDetails2)
            }
        }



    }

}

