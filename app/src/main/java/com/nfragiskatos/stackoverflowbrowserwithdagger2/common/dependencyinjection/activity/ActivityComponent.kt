package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.app.AppComponent
import com.nfragiskatos.stackoverflowbrowserwithdagger2.networking.StackoverflowApi
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.ScreensNavigator
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun activity(): AppCompatActivity

    fun screensNavigator(): ScreensNavigator

    fun layoutInflater(): LayoutInflater

    fun fragmentManager(): FragmentManager

    fun stackOverflowApi(): StackoverflowApi
}