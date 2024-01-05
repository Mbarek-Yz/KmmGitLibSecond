package com.example.kmmgitlib

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat

actual fun NotificationManager(title: String, message: String, context: Any?,drawable : Int) {
    if (context is Context) {
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(context)
            .setContentTitle(title) // set title of notification
            .setContentText(message) // this is notification message
            .setAutoCancel(true) // makes auto cancel of notification
            .setSmallIcon(drawable)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) // set priority of notification

        // Add as notification
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        manager?.notify(0, builder.build())
    }
}
