package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.presentation


import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questiondetails.QuestionDetailsActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questionslist.QuestionsListActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questionslist.QuestionsListFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent()
interface PresentationComponent {

    fun inject(fragment: QuestionsListFragment)

    fun inject(activity: QuestionDetailsActivity)
    fun inject(questionsListActivity: QuestionsListActivity)
}