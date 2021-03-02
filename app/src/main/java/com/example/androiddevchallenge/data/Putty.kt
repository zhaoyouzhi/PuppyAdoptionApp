package com.example.androiddevchallenge.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class Putty(
    val name: String,
    val location: String,
    val age: Int,
    val gender: String,
    val breed: String,
    @DrawableRes val imageId: Int,
    val description: String
) : Parcelable
