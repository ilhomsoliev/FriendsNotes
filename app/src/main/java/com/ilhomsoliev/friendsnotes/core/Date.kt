package com.ilhomsoliev.friendsnotes.core

import java.text.SimpleDateFormat
import java.util.Date

fun formatMillisToDateString(millis: Long): String {
    val formatter = SimpleDateFormat("yyyy-dd-MM")
    return formatter.format(Date(millis))
}