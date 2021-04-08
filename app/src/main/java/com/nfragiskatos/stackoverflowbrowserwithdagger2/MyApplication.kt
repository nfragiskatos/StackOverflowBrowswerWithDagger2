package com.nfragiskatos.stackoverflowbrowserwithdagger2

import android.app.Application
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.app.AppComponent
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.app.AppModule
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.DaggerAppComponent

class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}