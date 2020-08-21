package com.academy.stikompoltek.utils.ext

import android.widget.EditText

fun EditText.checkIsNotEmpty(): Boolean {
    if (text.isNullOrEmpty()) error = "Required"
    return !text.isNullOrEmpty()
}