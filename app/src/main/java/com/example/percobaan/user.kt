package com.example.percobaan

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class user(
    val Email:String,
    val Kata_sandi:String
):Parcelable
