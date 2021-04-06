package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.composition

import FetchQuestionDetailsUseCase
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.FetchQuestionsUseCase
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.dialogs.DialogsNavigator
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.viewsmvc.ViewMvcFactory

class PresentationCompositionRoot(private val activityCompositionRoot: ActivityCompositionRoot) {

    private val layoutInflater get() = activityCompositionRoot.layoutInflater
    private val fragmentManager get() = activityCompositionRoot.fragmentManager
    private val stackOverflowApi get() = activityCompositionRoot.stackOverflowApi

    val screensNavigator get() = activityCompositionRoot.screensNavigator

    val viewMvcFactory get() = ViewMvcFactory(layoutInflater)

    val dialogsNavigator get() = DialogsNavigator(fragmentManager)

    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackOverflowApi)

    val fetchQuestionDetailsUseCase get() = FetchQuestionDetailsUseCase(stackOverflowApi)
}