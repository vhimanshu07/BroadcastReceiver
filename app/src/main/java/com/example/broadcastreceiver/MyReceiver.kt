package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        Toast.makeText(context,action,Toast.LENGTH_LONG).show()
        // change the time zone to check , it is called implicit broadcast receiver

    }
}