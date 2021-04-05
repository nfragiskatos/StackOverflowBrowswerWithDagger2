package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.composition

import FetchQuestionDetailsUseCase
import android.app.Activity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.FetchQuestionsUseCase
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.ScreensNavigator

class ActivityCompositionRoot(private val activity: Activity, private val appCompositionRoot: AppCompositionRoot) {

    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    private val stackOverflowApi get() = appCompositionRoot.stackOverflowApi

    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackOverflowApi)

    val fetchQuestionDetailsUseCase get() = FetchQuestionDetailsUseCase(stackOverflowApi)
}