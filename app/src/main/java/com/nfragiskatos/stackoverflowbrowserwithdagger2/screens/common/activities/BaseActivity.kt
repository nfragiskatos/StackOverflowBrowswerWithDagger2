package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.MyApplication
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.ActivityCompositionRoot
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.DaggerPresentationComponent
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.Injector
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.PresentationModule

open class BaseActivity : AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).appCompositionRoot

    val activityCompositionRoot by lazy {
        ActivityCompositionRoot(this, appCompositionRoot)
    }

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
                .presentationModule(PresentationModule(activityCompositionRoot))
                .build()
    }

    protected val injector get() = Injector(presentationComponent)

}