package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questiondetails

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nfragiskatos.stackoverflowbrowserwithdagger2.R
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.toolbar.MyToolbar
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.viewsmvc.BaseViewMvc

class QuestionDetailsViewMvc(layoutInflater: LayoutInflater,
                             parent: ViewGroup?
) : BaseViewMvc<QuestionDetailsViewMvc.Listener>(
        layoutInflater,
        parent,
        R.layout.layout_question_details) {

    private var toolbar: MyToolbar
    private var swipeRefresh: SwipeRefreshLayout
    private var txtQuestionBody: TextView


    interface Listener {
        fun onBackClicked()
    }

    init {
        txtQuestionBody = findViewById(R.id.txt_question_body)

        // init toolbar
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            for (listener in listeners) {
                listener.onBackClicked()
            }
        }

        // init pull-down-to-refresh (used as a progress indicator)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.isEnabled = false
    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        if (swipeRefresh.isRefreshing) {
            swipeRefresh.isRefreshing = false
        }
    }


    fun bindQuestionDetails(questionBody: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtQuestionBody.text = Html.fromHtml(questionBody, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            txtQuestionBody.text = Html.fromHtml(questionBody)
        }
    }
}