package com.example.broadcastreceiver

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class CustomBroadCastReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action){
            TRIAL ->{
                displayNotificationAndToast(context,"In the Main Activity")
            }
            FRAGMENT_A ->{
                displayNotificationAndToast(context,"In Fragment A")

            }
            FRAGMENT_B->{
                displayNotificationAndToast(context,"In Fragment B")
            }
        }
    }

    private fun displayNotificationAndToast(context: Context?,textToBeDisplayed:String) {
        val appContext = context?:return

        makeStatusNotification(textToBeDisplayed, appContext)
    }
    fun makeStatusNotification(message: String, context: Context) {

        // Make a channel if necessary
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            val name = VERBOSE_NOTIFICATION_CHANNEL_NAME
            val description = VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = description

            // Add the channel
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

            notificationManager?.createNotificationChannel(channel)
        }

        // Create the notification
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(NOTIFICATION_TITLE)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setVibrate(LongArray(0))

        // Show the notification
        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, builder.build())
    }
}