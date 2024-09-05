package com.example.broadcastreceiver.fragments

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.broadcastreceiver.CustomBroadCastReceiver
import com.example.broadcastreceiver.FRAGMENT_B
import com.example.broadcastreceiver.R
import com.example.broadcastreceiver.databinding.FragmentBBinding

class Fragment_B : Fragment(), View.OnClickListener {
    lateinit var broadCastMessage: CustomBroadCastReceiver
    lateinit var binding: FragmentBBinding
    private lateinit var broadcastManager: LocalBroadcastManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        broadCastMessage = CustomBroadCastReceiver()
//        val intentFilter = IntentFilter()
//        intentFilter.addAction(FRAGMENT_B)
        val intentFilter = Intent(FRAGMENT_B)
        context?.let {
            LocalBroadcastManager.getInstance(it).sendBroadcast(intentFilter)
        }
        binding = FragmentBBinding.inflate(layoutInflater)
        setUpListeners()

    }

    private fun setUpListeners() {
        binding.button.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.run {
                replace(R.id.host, Fragment_A())
                commit()
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__b, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        context?.unregisterReceiver(broadCastMessage)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.button -> {
                activity?.supportFragmentManager?.beginTransaction()?.run {
                    replace(R.id.host, Fragment_A())
                    commit()
                }
            }
        }
    }


}