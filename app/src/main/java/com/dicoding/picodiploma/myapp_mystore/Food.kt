package com.dicoding.picodiploma.myapp_mystore

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    val name: String,
    val description: String,
    val photo: String,
    val bahan: String
) : Parcelable
