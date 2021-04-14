package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.FetchQuestionsUseCase
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.Question
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject

class MyViewModel @Inject constructor(
        private val fetchQuestionsUseCase: FetchQuestionsUseCase
) : ViewModel() {

    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> = _questions

    init {
        viewModelScope.launch {
            val result = fetchQuestionsUseCase.fetchLatestQuestions()
            if (result is FetchQuestionsUseCase.Result.Success) {
                _questions.value = result.questions
            } else {
                throw RuntimeException("Fetch Failed")
            }
        }
    }
}