package com.example.percobaan

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class Masuk : AppCompatActivity(), View.OnClickListener {

    private lateinit var etEmail: EditText
    private lateinit var etKata_sandi: EditText
    private lateinit var Tampilan: TextView

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data:Intent? = result.data
            val returnString:String? =data?.getStringExtra("Tampilan")
            Tampilan.text = returnString
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        Tampilan = findViewById(R.id.tv_tampilan)
        etEmail = findViewById(R.id.edt_email)
        etKata_sandi = findViewById(R.id.edt_Kata_sandi)

        val bundle = intent.extras
        if (bundle != null) {
            etEmail.setText(bundle.getString("Email"))
            etKata_sandi.setText(bundle.getString("Kata sandi"))
        }

        val btnMasuk: Button = findViewById(R.id.btn_masuk)
        btnMasuk.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.btn_masuk -> {
                val intent = Intent(this@Masuk, MainActivity::class.java)
                intent.putExtra("user",user(etEmail.text.toString(),etKata_sandi.text.toString()))
                resultLauncher.launch(intent)
            }
        }
    }
}