package com.nfragiskatos.stackoverflowbrowserwithdagger2.networking

import com.google.gson.annotations.SerializedName
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.Question

class QuestionsListResponseSchema(@SerializedName("items") val questions: List<Question>)