package com.example.deron.util

import java.util.Locale


object Tool {
    fun intToHMS(time: Int): String {
        val hour = time / 3600
        val minute = time % 3600 / 60
        val seconds = time % 60
        return String.format(Locale.US, "%02d:%02d:%02d", hour, minute, seconds)
    }
}