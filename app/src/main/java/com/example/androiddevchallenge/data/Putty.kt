package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class Putty(
    val name: String,
    val location: String,
    val age: Int,
    val gender: String,
    val breed: String,
    @DrawableRes val imageId: Int,
    val description: String
)
