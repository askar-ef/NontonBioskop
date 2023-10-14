package com.example.nontonbioskop

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.nontonbioskop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.txtUsername.text.toString()
            val password = binding.txtPassword.text.toString()

            val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("username", username)
            editor.apply()


            if (username == "Askar" && password == "504665") {
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Login gagal. Periksa kembali Username dan Password", Toast.LENGTH_LONG).show()
            }

        }
    }
}