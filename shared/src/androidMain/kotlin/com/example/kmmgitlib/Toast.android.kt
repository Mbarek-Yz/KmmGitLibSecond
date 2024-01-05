package com.example.kmmgitlib

import android.content.Context
import android.util.Log
import android.widget.Toast

actual fun getToast(message: String, context: Any?) {
    Log.w("ModuleKmm","Fun getToast Android")
    if (context is Context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        Log.w("ModuleKmm","Toast Android")
    } else {
        // Handle the case where the context is not of the expected type
        Log.w("ModuleKmm","No Toast Android")
    }
}

