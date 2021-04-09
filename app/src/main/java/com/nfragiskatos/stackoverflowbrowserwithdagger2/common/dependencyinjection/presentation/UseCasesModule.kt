package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.presentation

import com.nfragiskatos.stackoverflowbrowserwithdagger2.networking.StackoverflowApi
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.FetchQuestionDetailsUseCase
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.FetchQuestionsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule() {

    @Provides
    fun fetchQuestionsUseCase(stackOverflowApi: StackoverflowApi) = FetchQuestionsUseCase(stackOverflowApi)

    @Provides
    fun fetchQuestionDetailsUseCase(stackOverflowApi: StackoverflowApi) = FetchQuestionDetailsUseCase(stackOverflowApi)
}