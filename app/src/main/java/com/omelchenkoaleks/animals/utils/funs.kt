package com.omelchenkoaleks.animals.utils

import android.widget.Toast

fun showToast(message: String) {
    Toast.makeText(APP_ACTIVITY, message, Toast.LENGTH_LONG).show()
}