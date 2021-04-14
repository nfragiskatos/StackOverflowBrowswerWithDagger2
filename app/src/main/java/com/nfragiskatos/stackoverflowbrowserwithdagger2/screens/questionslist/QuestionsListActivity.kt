package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questionslist

import android.os.Bundle
import android.util.Log
import com.nfragiskatos.stackoverflowbrowserwithdagger2.R
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.ScreensNavigatorImpl
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.activities.BaseActivity
import javax.inject.Inject

class QuestionsListActivity : BaseActivity() {


    @Inject
    lateinit var screensNavigator: ScreensNavigatorImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        Log.e("QuestionsListActivity", "$screensNavigator")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_frame)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.frame_content, QuestionsListFragment())
                    .commit()
        }
    }
}