package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection

import androidx.annotation.UiThread
import com.nfragiskatos.stackoverflowbrowserwithdagger2.Constants
import com.nfragiskatos.stackoverflowbrowserwithdagger2.networking.StackoverflowApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@UiThread
class AppCompositionRoot {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    val stackOverflowApi: StackoverflowApi by lazy { retrofit.create(StackoverflowApi::class.java) }
}