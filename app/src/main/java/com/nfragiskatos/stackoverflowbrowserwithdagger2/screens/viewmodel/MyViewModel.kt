package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.viewmodel

import androidx.lifecycle.*
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.FetchQuestionDetailsUseCase
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.FetchQuestionsUseCase
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.Question
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyViewModel @Inject constructor(
        private val fetchQuestionsUseCase: FetchQuestionsUseCase,
        private val fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase,
        private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _questions: MutableLiveData<List<Question>> = savedStateHandle.getLiveData("questions")
    val questions: LiveData<List<Question>> = _questions

    init {
        viewModelScope.launch {
            delay(5000)
            val result = fetchQuestionsUseCase.fetchLatestQuestions()
            if (result is FetchQuestionsUseCase.Result.Success) {
                _questions.value = result.questions
            } else {
                throw RuntimeException("Fetch Failed")
            }
        }
    }
}