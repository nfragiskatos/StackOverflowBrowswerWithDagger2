package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.service

import android.app.Service
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ServiceModule(val service: Service) {

    @Provides
    fun context(): Context = service
}