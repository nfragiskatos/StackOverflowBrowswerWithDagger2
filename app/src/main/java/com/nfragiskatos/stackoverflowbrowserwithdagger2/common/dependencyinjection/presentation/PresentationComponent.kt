package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.presentation


import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questiondetails.QuestionDetailsActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questionslist.QuestionsListActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questionslist.QuestionsListFragment
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.viewmodel.ViewModelActivity
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [ViewModelsModule::class])
interface PresentationComponent {

    fun inject(fragment: QuestionsListFragment)

    fun inject(activity: QuestionDetailsActivity)
    fun inject(questionsListActivity: QuestionsListActivity)
    fun inject(viewModelActivity: ViewModelActivity)
}