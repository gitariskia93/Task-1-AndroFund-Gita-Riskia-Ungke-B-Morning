package com.example.percobaan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tes)

        val fragmentManager = supportFragmentManager
        val fragment01 = Fragment01()
        val fragment = fragmentManager.findFragmentByTag(Fragment01::class.java.simpleName)

        if (fragment !is Fragment01){
            fragmentManager
                .beginTransaction()
                .add(R.id.container, fragment01, Fragment01::class.java.simpleName)
                .commit()
        }
    }
}