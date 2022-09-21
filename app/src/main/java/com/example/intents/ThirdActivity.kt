package com.example.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intents.databinding.ActivityThirdBinding


class ThirdActivity : AppCompatActivity() {
    lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras

        val personName = bundle?.getString("personName")
        val personAge = bundle?.getString("personAge")
        val selection = bundle?.getString("selection")
        var message = ""

        binding.showButton.setOnClickListener {

            if(selection == getString(R.string.hola)) {
                message = "Hola $personName, com portes aquests $personAge anys?"
            } else {
                message = "Espero tornar a veure’t $personName, abans que facis ${personAge!!.toInt()+1} anys"
            }

            Toast.makeText(this, message, Toast.LENGTH_LONG).show()

        }
        binding.shareButton.setOnClickListener {

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, message)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)


        }
    }
}