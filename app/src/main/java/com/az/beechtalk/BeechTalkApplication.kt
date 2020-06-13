package com.az.beechtalk

import android.app.Application
import android.util.Log
import com.az.beechtalk.logger.CrashReportingTree
import com.az.beechtalk.logger.FileLoggingTree
import timber.log.Timber

class BeechTalkApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e("no","no")
        if(BuildConfig.DEBUG)
            Timber.plant(
                FileLoggingTree(
                    applicationContext
                )
            );
        else
            Timber.plant(CrashReportingTree());
    }
}