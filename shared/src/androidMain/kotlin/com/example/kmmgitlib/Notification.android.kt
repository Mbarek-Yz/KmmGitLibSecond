package com.example.kmmgitlib

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

actual fun NotificationManager(title: String, message: String, context: Any?, drawable: Int) {
    if (context is Context) {
        // Create a unique channel ID
        val channelId = "default_channel_id"

        // Create the NotificationChannel if the Android version is Oreo or newer
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName = "Default Channel"
            val channelDescription = "Default Notification Channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            createNotificationChannel(context, channelId, channelName, channelDescription, importance)
        }

        val builder: NotificationCompat.Builder = NotificationCompat.Builder(context, channelId)
            .setContentTitle(title)
            .setContentText(message)
            .setAutoCancel(true)
            .setSmallIcon(drawable)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Add as notification
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        manager?.notify(0, builder.build())
    }
}

// Helper function to create a notification channel
private fun createNotificationChannel(
    context: Context,
    channelId: String,
    channelName: String,
    channelDescription: String,
    importance: Int
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(channelId, channelName, importance).apply {
            description = channelDescription
        }

        // Register the channel with the system
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}
