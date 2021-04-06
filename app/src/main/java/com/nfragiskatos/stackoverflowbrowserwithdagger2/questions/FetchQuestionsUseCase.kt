package com.nfragiskatos.stackoverflowbrowserwithdagger2.questions

import com.nfragiskatos.stackoverflowbrowserwithdagger2.networking.StackoverflowApi
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FetchQuestionsUseCase(private val stackoverflowApi: StackoverflowApi) {

    sealed class Result {
        data class Success(val questions: List<Question>) : Result()
        object Failure: Result()
    }

    suspend fun fetchLatestQuestions() : Result {
        return withContext(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.lastActiveQuestions(20)
                if (response.isSuccessful && response.body() != null) {
                    return@withContext Result.Success(response.body()!!.questions)
                } else {
                    return@withContext Result.Failure
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    return@withContext Result.Failure
                } else {
                    throw t
                }
            }
        }
    }
}