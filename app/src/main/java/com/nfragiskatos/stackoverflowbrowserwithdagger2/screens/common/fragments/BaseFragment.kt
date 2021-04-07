package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.fragments

import androidx.fragment.app.Fragment
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.DaggerPresentationComponent
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.Injector
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.PresentationModule
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
                .presentationModule(PresentationModule((requireActivity() as BaseActivity).activityCompositionRoot))
                .build()
    }

    protected val injector get() = Injector(presentationComponent)
}