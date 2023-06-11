package com.example.easiercompose

import android.os.Parcelable
import java.time.LocalDateTime
import kotlinx.parcelize.Parcelize
@Parcelize
data class User(
    val name: String,
    val uid: String,
    val created: LocalDateTime
): Parcelable
