package com.example.kmmgitlib

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

actual fun getDialog(messageButtonPositive: String,messageButtonNegative: String,message: String,title: String,context: Any?) {
    if (context is Context) {
        val builder = AlertDialog.Builder(context)

        builder.setTitle(title)
        builder.setMessage(message)

        builder.setPositiveButton(messageButtonPositive) { dialog, which ->
            dialog.dismiss()
        }

        // Optionally, set the negative button (Cancel button)
        builder.setNegativeButton(messageButtonNegative) { dialog, which ->
            dialog.dismiss()
        }

        // Create and show the dialog
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }else{

    }
}
