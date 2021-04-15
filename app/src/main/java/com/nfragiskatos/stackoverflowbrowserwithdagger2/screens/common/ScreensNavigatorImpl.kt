package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questiondetails.QuestionDetailsActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.viewmodel.ViewModelActivity
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
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