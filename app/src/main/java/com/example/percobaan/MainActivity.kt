package com.example.percobaan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv =findViewById(R.id.textView)

        val Email =intent.getParcelableExtra<user>("user")?.Email
        val Kata_sandi =intent.getParcelableExtra<user>("user")?.Kata_sandi
        tv.text = "Email: $Email dan Kata sandi: $Kata_sandi"

        val btnImplicit: Button = findViewById(R.id.btn_Implicit)
        btnImplicit.setOnClickListener(this)

        val btnFragment: Button = findViewById(R.id.btn_satu)
        btnFragment.setOnClickListener(this)
    }

    override fun onClick(v: View) {
       when (v.id){
           R.id.btn_Implicit -> {
  //             val message = "Hai Saya Gita dari Kelas Mobile"
  //             val intent = Intent()
  //             intent.action = Intent.ACTION_SEND
  //             intent.putExtra(Intent.EXTRA_TEXT, message)
  //             intent.type = "text/plain"
   //            startActivity(intent)

               val intent = intent
               intent.putExtra("Tampilan", "Anda sudah masuk")
               setResult(RESULT_OK,intent)
               finish()
           }
           R.id.btn_satu -> {
               val intent = Intent(this@MainActivity, TesActivity::class.java)
               startActivity(intent)
           }
           }
       }
    }