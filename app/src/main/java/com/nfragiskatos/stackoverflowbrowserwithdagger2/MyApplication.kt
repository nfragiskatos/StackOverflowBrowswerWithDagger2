package com.nfragiskatos.stackoverflowbrowserwithdagger2

import android.app.Application
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.AppCompositionRoot

class MyApplication: Application() {

    lateinit var appCompositionRoot: AppCompositionRoot

    override fun onCreate() {
        super.onCreate()
        appCompositionRoot = AppCompositionRoot()
    }

}