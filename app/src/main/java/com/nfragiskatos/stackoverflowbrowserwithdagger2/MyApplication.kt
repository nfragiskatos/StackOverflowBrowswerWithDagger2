package com.nfragiskatos.stackoverflowbrowserwithdagger2

import FetchQuestionDetailsUseCase
import android.app.Application
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.composition.AppCompositionRoot
import com.nfragiskatos.stackoverflowbrowserwithdagger2.networking.StackoverflowApi
import com.nfragiskatos.stackoverflowbrowserwithdagger2.questions.FetchQuestionsUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication: Application() {

    lateinit var appCompositionRoot: AppCompositionRoot

    override fun onCreate() {
        super.onCreate()
        appCompositionRoot = AppCompositionRoot()
    }

}