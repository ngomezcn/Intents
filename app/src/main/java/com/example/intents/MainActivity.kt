package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.goNextButton.setOnClickListener {

            val personName = binding.editText.text.toString();

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("personName", personName)

            if(personName.isNotEmpty()) {
                startActivity(intent)
            } else
            {
                Toast.makeText(this, "Name is empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}