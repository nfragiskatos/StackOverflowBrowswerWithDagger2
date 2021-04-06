package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.composition

import FetchQuestionDetailsUseCase
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.FetchQuestionsUseCase
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.ScreensNavigator
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.dialogs.DialogsNavigator
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.viewsmvc.ViewMvcFactory

class ActivityCompositionRoot(private val activity: AppCompatActivity, private val appCompositionRoot: AppCompositionRoot) {

    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    val layoutInflater get() = LayoutInflater.from(activity)
    val fragmentManager get() = activity.supportFragmentManager
    val stackOverflowApi get() = appCompositionRoot.stackOverflowApi




}