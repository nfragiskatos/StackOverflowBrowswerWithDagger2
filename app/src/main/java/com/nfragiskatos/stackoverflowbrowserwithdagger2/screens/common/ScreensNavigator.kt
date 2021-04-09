package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questiondetails.QuestionDetailsActivity

class ScreensNavigator constructor(private val activity: AppCompatActivity) {

    fun navigateBack() {
        activity.onBackPressed()
    }

    fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }
}