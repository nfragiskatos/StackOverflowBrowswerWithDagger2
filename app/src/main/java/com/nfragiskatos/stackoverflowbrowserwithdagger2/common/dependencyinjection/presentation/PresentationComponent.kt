package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.presentation


import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.activity.ActivityComponent
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questiondetails.QuestionDetailsActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questionslist.QuestionsListFragment
import dagger.Component
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class])
interface PresentationComponent {

    fun inject(fragment: QuestionsListFragment)

    fun inject(activity: QuestionDetailsActivity)
}