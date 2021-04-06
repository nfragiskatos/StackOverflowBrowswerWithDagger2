package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.fragments

import androidx.fragment.app.Fragment
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    protected val compositionRoot get() = (requireActivity() as BaseActivity).compositionRoot
}