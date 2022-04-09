package com.example.magicyellowsquare.util

import java.text.SimpleDateFormat
import java.util.*

fun toStringDate(): String {
    val currentDateAndTime = SimpleDateFormat("dd MMMM yyyy à HH:mm", Locale.getDefault())
    return currentDateAndTime.format(Date())
}