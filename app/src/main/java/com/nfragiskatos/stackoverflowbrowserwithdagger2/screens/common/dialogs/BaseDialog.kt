package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.dialogs

import androidx.fragment.app.DialogFragment
import com.nfragiskatos.stackoverflowbrowserwithdagger2.MyApplication
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.service.ServiceModule
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.activities.BaseActivity

open class BaseDialog: DialogFragment() {

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent()
    }

    protected val injector get() = presentationComponent
}