package com.example.cambioventanas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.cambioventanas.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private var nombre: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.apply {

            intent.extras?.let {
                nombre = it.getString("nombre")
            }

            tvtHola2.text = nombre

            btnBoton2.setOnClickListener {
                val k = "hyuyhyuuyhyuhuybubuhb"
                val intent = Intent()
                intent.putExtra("nombre2", k)
                setResult(Activity.RESULT_OK,intent)
                finish()
            }
        }
    }
}