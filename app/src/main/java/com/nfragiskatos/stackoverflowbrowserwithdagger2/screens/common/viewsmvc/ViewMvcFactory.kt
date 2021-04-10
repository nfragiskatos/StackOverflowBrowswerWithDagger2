package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.viewsmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.imageloader.ImageLoader
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questiondetails.QuestionDetailsViewMvc
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questionslist.QuestionsListViewMvc
import javax.inject.Inject

class ViewMvcFactory @Inject constructor(
        private val layoutInflater: LayoutInflater,
        private val imageLoader: ImageLoader
) {

    fun newQuestionsListViewMvc(parent: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflater, parent)
    }

    fun newQuestionDetailsViewMvc(parent: ViewGroup?): QuestionDetailsViewMvc {
        return QuestionDetailsViewMvc(layoutInflater, imageLoader, parent)
    }
}