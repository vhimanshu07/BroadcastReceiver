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
import com.example.broadcastreceiver.FRAGMENT_A
import com.example.broadcastreceiver.R
import com.example.broadcastreceiver.databinding.FragmentABinding

class Fragment_A : Fragment(), View.OnClickListener {

    lateinit var binding: FragmentABinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val intentFilter = IntentFilter()
//        intentFilter.addAction(FRAGMENT_A)

        binding = FragmentABinding.inflate(layoutInflater)

        setUpListeners()


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intentFilter = Intent(FRAGMENT_A)
        context?.let {
            LocalBroadcastManager.getInstance(it).sendBroadcast(intentFilter)
        }
    }

    private fun setUpListeners() {
        binding.buttona.setOnClickListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment__a, container, false)

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.buttona -> {
                activity?.supportFragmentManager?.beginTransaction()?.apply{
                    replace(R.id.host, Fragment_B())
                    commit()
                }
            }
        }
    }


}