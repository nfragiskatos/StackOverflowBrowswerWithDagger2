package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.MyApplication
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.*
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.activity.ActivityComponent
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.activity.ActivityModule
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.activity.DaggerActivityComponent
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.presentation.PresentationComponent
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.presentation.PresentationModule

open class BaseActivity : AppCompatActivity() {

    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(ActivityModule(this))
                .build()
    }

    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent(PresentationModule())
    }

    protected val injector: PresentationComponent get() = presentationComponent

}