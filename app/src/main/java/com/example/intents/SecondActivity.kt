package com.example.intents

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.SeekBar
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

        val personName = bundle?.getString("personName")
        var personAge = ""

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

        binding.goNextButton.setOnClickListener {

            val intent = Intent(this, ThirdActivity::class.java)

            intent.putExtra("personName", personName)
            intent.putExtra("personAge", personAge)

            if(binding.radioButtonHola.isChecked) {
               intent.putExtra("selection", getString(R.string.hola))
            }
            if(binding.radioButtonAdeu.isChecked) {
                intent.putExtra("selection", getString(R.string.adeu))
            }

            startActivity(intent)
        }
    }
}