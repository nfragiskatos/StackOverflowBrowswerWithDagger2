package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.MyApplication
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.composition.ActivityCompositionRoot

open class BaseActivity : AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).appCompositionRoot

    val compositionRoot by lazy {
        ActivityCompositionRoot(this, appCompositionRoot)
    }


}