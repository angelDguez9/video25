package com.example.cambioventanas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.cambioventanas.R.id.tvtHola
import com.example.cambioventanas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var hola2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        hola2 = binding.tvtHola

        binding.apply {

            btnBoton.setOnClickListener {
                navegar()
                Toast.makeText(this@MainActivity, "Usted cambió de ventana", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

    private fun navegar() {
        val hola = "buenas noches"
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("nombre", hola)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val n = data?.getStringExtra("nombre2")
                hola2.text = n
                Toast.makeText(this@MainActivity, "" + n, Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }
}