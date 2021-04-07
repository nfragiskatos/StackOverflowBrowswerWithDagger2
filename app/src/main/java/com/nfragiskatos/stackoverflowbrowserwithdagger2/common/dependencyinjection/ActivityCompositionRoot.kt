package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.ScreensNavigator

class ActivityCompositionRoot(
        val activity: AppCompatActivity,
        private val appCompositionRoot: AppCompositionRoot) {

    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    val application get() = appCompositionRoot.application
    val layoutInflater get() = LayoutInflater.from(activity)
    val fragmentManager get() = activity.supportFragmentManager
    val stackOverflowApi get() = appCompositionRoot.stackOverflowApi


}