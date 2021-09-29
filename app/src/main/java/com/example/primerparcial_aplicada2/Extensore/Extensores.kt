package com.example.primerparcial_aplicada2.Extensore

import android.text.Editable
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun Editable?.getFloat(): Float {
    return this.toString().toFloatOrNull() ?: 0f
}

fun View.showMessage(message:String)
{
    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        .setAction("Action", null).show()
}