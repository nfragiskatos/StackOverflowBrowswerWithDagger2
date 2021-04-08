package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.presentation

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.nfragiskatos.stackoverflowbrowserwithdagger2.networking.StackoverflowApi
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.FetchQuestionDetailsUseCase
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.FetchQuestionsUseCase
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.dialogs.DialogsNavigator
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.viewsmvc.ViewMvcFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule() {

    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater) = ViewMvcFactory(layoutInflater)

    @Provides
    fun dialogsNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)

    @Provides
    fun fetchQuestionsUseCase(stackOverflowApi: StackoverflowApi) = FetchQuestionsUseCase(stackOverflowApi)

    @Provides
    fun fetchQuestionDetailsUseCase(stackOverflowApi: StackoverflowApi) = FetchQuestionDetailsUseCase(stackOverflowApi)
}