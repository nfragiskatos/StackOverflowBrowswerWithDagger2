package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common

interface ScreensNavigator {

    fun navigateBack()

    fun toQuestionDetails(questionId: String)
}