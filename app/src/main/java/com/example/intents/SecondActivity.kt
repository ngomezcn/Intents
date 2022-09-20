package com.example.intents

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.intents.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        binding.radioGroup.check(binding.radioButtonHola.id)

        val personName = bundle?.getString("personName")
        var personAge = ""
        var selectedString = "";

        binding.ageSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                personAge = p1.toString()
                binding.ageNumber.text = personAge
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        } )

        binding.radioGroup.setOnCheckedChangeListener { _, p1 ->
            if (p1 == 1)
                selectedString = getString(R.string.hola);
            if (p1 == 2)
                selectedString = getString(R.string.adeu);
        }

        binding.goNextButton.setOnClickListener {

            val intent = Intent(this, ThirdActivity::class.java)

            intent.putExtra("personAge", personAge)
            intent.putExtra("personName", personName)
            intent.putExtra("selectedStr", personName)

            Toast.makeText(this, selectedString, Toast.LENGTH_SHORT).show()

            startActivity(intent)
        }
    }
}