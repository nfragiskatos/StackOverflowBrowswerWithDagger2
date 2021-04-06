package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.fragments

import androidx.fragment.app.Fragment
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.composition.PresentationCompositionRoot
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    protected val compositionRoot by lazy {
        PresentationCompositionRoot((requireActivity() as BaseActivity).activityCompositionRoot)
    }
}