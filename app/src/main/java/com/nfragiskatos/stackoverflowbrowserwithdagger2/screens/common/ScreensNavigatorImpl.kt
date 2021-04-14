package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.activity.ActivityScope
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questiondetails.QuestionDetailsActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.viewmodel.ViewModelActivity
import javax.inject.Inject

@ActivityScope
class ScreensNavigatorImpl @Inject constructor(private val activity: AppCompatActivity) : ScreensNavigator {

    override fun navigateBack() {
        activity.onBackPressed()
    }

    override fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }

    override fun toViewModel() {
        ViewModelActivity.start(activity)
    }
}