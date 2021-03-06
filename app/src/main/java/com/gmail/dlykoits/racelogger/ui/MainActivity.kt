package com.gmail.dlykoits.racelogger.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.dlykoits.racelogger.R
import com.gmail.dlykoits.racelogger.ui.acceleration.AccelerationFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, AccelerationFragment.newInstance())
                    .commitNow()
        }
    }

}
