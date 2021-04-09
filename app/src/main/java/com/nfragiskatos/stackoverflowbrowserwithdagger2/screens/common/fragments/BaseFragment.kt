package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.fragments

import androidx.fragment.app.Fragment
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.presentation.PresentationModule
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent(PresentationModule())
    }

    protected val injector get() = presentationComponent
}