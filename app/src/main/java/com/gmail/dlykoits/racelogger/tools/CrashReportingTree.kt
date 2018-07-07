package com.gmail.dlykoits.racelogger.tools

import android.util.Log
import androidx.annotation.Nullable
import timber.log.Timber.Tree


/** A tree which logs important information for crash reporting.  */
class CrashReportingTree : Tree() {

    fun isLoggable(priority: Int, @Nullable tag: String): Boolean {
        return priority >= Log.INFO
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

//        FakeCrashLibrary.log(priority, tag, message)

        if (t != null) {
            if (priority == Log.ERROR) {
                //              FakeCrashLibrary.logError(t)
            } else if (priority == Log.WARN) {
                //             FakeCrashLibrary.logWarning(t)
            }
        }
    }
}