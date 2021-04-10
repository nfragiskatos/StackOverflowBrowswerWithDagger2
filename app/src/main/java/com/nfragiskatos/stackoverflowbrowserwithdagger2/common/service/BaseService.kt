package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.service

import android.app.Service
import com.nfragiskatos.stackoverflowbrowserwithdagger2.MyApplication
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.service.ServiceModule

abstract class BaseService : Service() {

    private val appComponent get() = (application as MyApplication).appComponent

    val serviceComponent by lazy {
        appComponent.newServiceComponent(ServiceModule(this))
    }
}