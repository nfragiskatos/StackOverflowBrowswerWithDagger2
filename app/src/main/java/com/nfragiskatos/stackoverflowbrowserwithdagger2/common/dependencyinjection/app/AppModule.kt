package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.app

import android.app.Application
import com.nfragiskatos.stackoverflowbrowserwithdagger2.Constants
import com.nfragiskatos.stackoverflowbrowserwithdagger2.networking.StackoverflowApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(val application: Application) {

    @Provides
    @AppScope
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @AppScope
    fun stackOverflowApi(retrofit: Retrofit): StackoverflowApi = retrofit.create(StackoverflowApi::class.java)

    @Provides
    fun application() = application
}