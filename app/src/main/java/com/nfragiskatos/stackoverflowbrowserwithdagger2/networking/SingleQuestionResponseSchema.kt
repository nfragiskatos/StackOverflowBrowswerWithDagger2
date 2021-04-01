package com.nfragiskatos.stackoverflowbrowserwithdagger2.networking

import com.google.gson.annotations.SerializedName
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.QuestionWithBody

data class SingleQuestionResponseSchema(@SerializedName("items") val questions: List<QuestionWithBody>) {
    val question: QuestionWithBody get() = questions[0]
}