package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.broadcastreceiver.fragments.Fragment_A

class MainActivity : AppCompatActivity() {
    lateinit var broadCastMessage: CustomBroadCastReceiver
    private lateinit var broadcastManager: LocalBroadcastManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        broadCastMessage = CustomBroadCastReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction(TRIAL)

        broadcastManager = LocalBroadcastManager.getInstance(this)
        broadcastManager.registerReceiver(broadCastMessage, intentFilter)
        val intent = Intent(TRIAL)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.host,Fragment_A())
            broadcastManager.sendBroadcast(intent)
            commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        broadcastManager.unregisterReceiver(broadCastMessage)

    }
}