package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.questiondetails

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nfragiskatos.stackoverflowbrowserwithdagger2.R
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.toolbar.MyToolbar

class QuestionDetailsViewMvc(private val layoutInflater: LayoutInflater,
                             private val parent: ViewGroup?) {

    private lateinit var toolbar: MyToolbar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var txtQuestionBody: TextView
    val rootView: View = layoutInflater.inflate(R.layout.layout_question_details, parent, false)

    interface Listener {
        fun onBackClicked()
    }

    private val listeners = HashSet<Listener>()

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

    private fun <T : View?> findViewById(@IdRes id: Int): T {
        return rootView.findViewById<T>(id)
    }

    fun registerListener(listener: Listener) {
        listeners.add(listener)
    }

    fun unregisterListener(listener: Listener) {
        listeners.remove(listener)
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