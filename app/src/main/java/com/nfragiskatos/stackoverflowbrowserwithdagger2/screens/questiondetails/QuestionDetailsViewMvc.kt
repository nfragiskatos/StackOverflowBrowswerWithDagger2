package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questiondetails

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nfragiskatos.stackoverflowbrowserwithdagger2.R
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.QuestionWithBody
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.imageloader.ImageLoader
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.toolbar.MyToolbar
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.viewsmvc.BaseViewMvc

class QuestionDetailsViewMvc(
        layoutInflater: LayoutInflater,
        private val imageLoader: ImageLoader,
        parent: ViewGroup?
) : BaseViewMvc<QuestionDetailsViewMvc.Listener>(
        layoutInflater,
        parent,
        R.layout.layout_question_details) {

    private var toolbar: MyToolbar
    private var swipeRefresh: SwipeRefreshLayout
    private var txtQuestionBody: TextView
    private var imgUser: ImageView
    private var txtUserName: TextView


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

        imgUser = findViewById(R.id.image_user)
        txtUserName = findViewById(R.id.txt_user_name)
    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        if (swipeRefresh.isRefreshing) {
            swipeRefresh.isRefreshing = false
        }
    }


    fun bindQuestionDetails(questionBody: QuestionWithBody) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtQuestionBody.text = Html.fromHtml(questionBody.body, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            txtQuestionBody.text = Html.fromHtml(questionBody.body)
        }
        imageLoader.loadImage(questionBody.owner.imageUrl, imgUser)
        txtUserName.text = questionBody.owner.name
    }
}