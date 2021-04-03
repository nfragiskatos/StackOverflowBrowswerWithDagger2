package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.MyApplication
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.composition.AppCompositionRoot

open class BaseActivity: AppCompatActivity() {

    val compositionRoot get() = (application as MyApplication).appCompositionRoot
}