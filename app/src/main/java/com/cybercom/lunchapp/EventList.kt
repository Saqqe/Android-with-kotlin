package com.cybercom.lunchapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_event_list.*

class EventList : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, EventList::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }


    private lateinit var user: FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_list)

        user = FirebaseAuth.getInstance().currentUser!!

        setupUI()
    }

    private fun setupUI() {
        sign_out_button.setOnClickListener{
            signOut()
        }

        textView_HelloWorld.setText("Welcome " + user.displayName)
    }


    private fun signOut() {
        startActivity(LoginActivity.getLaunchIntent(this))
        FirebaseAuth.getInstance().signOut();
    }
}

