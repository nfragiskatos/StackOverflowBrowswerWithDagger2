package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questiondetails

import FetchQuestionDetailsUseCase
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.ScreensNavigator
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.activities.BaseActivity
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.dialogs.DialogsNavigator
import kotlinx.coroutines.*

class QuestionDetailsActivity : BaseActivity(), QuestionDetailsViewMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private lateinit var questionId: String

    private lateinit var viewMvc: QuestionDetailsViewMvc

    private lateinit var fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase

    private lateinit var dialogsNavigator: DialogsNavigator

    private lateinit var screensNavigator: ScreensNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewMvc = compositionRoot.viewMvcFactory.newQuestionDetailsViewMvc(null)

        setContentView(viewMvc.rootView)

        fetchQuestionDetailsUseCase = compositionRoot.fetchQuestionDetailsUseCase

        // retrieve question ID passed from outside
        questionId = intent.extras!!.getString(EXTRA_QUESTION_ID)!!

        dialogsNavigator = compositionRoot.dialogsNavigator

        screensNavigator = compositionRoot.screensNavigator
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
        fetchQuestionDetails()
    }

    override fun onStop() {
        super.onStop()
        viewMvc.unregisterListener(this)
        coroutineScope.coroutineContext.cancelChildren()
    }

    private fun fetchQuestionDetails() {
        coroutineScope.launch {
            viewMvc.showProgressIndication()
            try {
                when (val result = fetchQuestionDetailsUseCase.fetchQuestionDetails(questionId)) {
                    is FetchQuestionDetailsUseCase.Result.Success -> {
                        viewMvc.bindQuestionDetails(result.question.body)
                    }
                    is FetchQuestionDetailsUseCase.Result.Failure -> onFetchFailed()
                }
            } finally {
                viewMvc.hideProgressIndication()
            }

        }
    }

    private fun onFetchFailed() {
        dialogsNavigator.showServerErrorDialog()
    }


    companion object {
        const val EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID"
        fun start(context: Context, questionId: String) {
            val intent = Intent(context, QuestionDetailsActivity::class.java)
            intent.putExtra(EXTRA_QUESTION_ID, questionId)
            context.startActivity(intent)
        }
    }

    override fun onBackClicked() {
        screensNavigator.navigateBack()
    }
}