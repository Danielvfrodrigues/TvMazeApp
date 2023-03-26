package com.example.myapplication.presentation.util.ext

import android.view.View

fun View.show(value: Boolean) {
    visibility = if (value) {
        View.VISIBLE
    } else {
        View.GONE
    }
}
