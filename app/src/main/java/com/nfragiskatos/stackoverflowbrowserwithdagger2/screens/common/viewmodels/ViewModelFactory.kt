package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.viewmodels

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.FetchQuestionDetailsUseCase
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.FetchQuestionsUseCase
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.viewmodel.MyViewModel
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.viewmodel.MyViewModel2
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
        private val fetchQuestionDetailsUseCaseProvider: Provider<FetchQuestionDetailsUseCase>,
        private val fetchQuestionsUseCaseProvider: Provider<FetchQuestionsUseCase>,
        savedStateRegistryOwner: SavedStateRegistryOwner
) : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {
    override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {

        return when (modelClass) {
            MyViewModel::class.java -> MyViewModel(
                fetchQuestionsUseCaseProvider.get(),
                    fetchQuestionDetailsUseCaseProvider.get(),
                    handle
            ) as T

            MyViewModel2::class.java -> MyViewModel2(
                    fetchQuestionsUseCaseProvider.get(),
                    fetchQuestionDetailsUseCaseProvider.get()
            ) as T

            else -> throw RuntimeException("unsupported viewmodel type: ${modelClass}")
        }
    }
}