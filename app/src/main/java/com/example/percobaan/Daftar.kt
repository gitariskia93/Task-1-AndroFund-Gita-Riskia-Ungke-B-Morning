package com.example.percobaan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class Daftar : AppCompatActivity(), View.OnClickListener {

    private lateinit var etEmail: EditText
    private lateinit var etKata_sandi: EditText
    private lateinit var etKonfirmasi_kata_sandi: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        etEmail = findViewById(R.id.edt_email)
        etKata_sandi = findViewById(R.id.edt_kata_sandi)
        etKonfirmasi_kata_sandi = findViewById(R.id.edt_konfirmasi_kata_sandi)

        val btnDaftar: Button = findViewById(R.id.btn_daftar)
        btnDaftar.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_daftar -> {

                val bundle = Bundle()
                bundle.putString("Email",etEmail.text.toString())
                bundle.putString("Kata sandi", etKata_sandi.text.toString())

                val intent = Intent(this@Daftar, Masuk::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}