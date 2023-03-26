package com.example.myapplication.presentation.util.ext

import android.content.Context
import android.widget.Toast

fun String.asToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()
}
