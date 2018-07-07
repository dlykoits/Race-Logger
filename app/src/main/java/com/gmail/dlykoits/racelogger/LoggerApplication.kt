package com.gmail.dlykoits.racelogger

import android.app.Application
import com.gmail.dlykoits.racelogger.tools.CrashReportingTree
import timber.log.Timber
import timber.log.Timber.DebugTree


class LoggerApplication : Application() {

    lateinit var trackingRepository: TrackingRepository
        private set

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }

        trackingRepository = TrackingRepository(this)
    }
}