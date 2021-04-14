package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.app

import android.app.Application
import com.nfragiskatos.stackoverflowbrowserwithdagger2.Constants
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.Retrofit1
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.Retrofit2
import com.nfragiskatos.stackoverflowbrowserwithdagger2.networking.StackoverflowApi
import com.nfragiskatos.stackoverflowbrowserwithdagger2.networking.UrlProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class AppModule(val application: Application) {

    @Provides
    @AppScope
    @Retrofit1
    fun retrofit1(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
                .baseUrl(urlProvider.getBaseUrl1())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @AppScope
    @Retrofit2
    fun retrofit2(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
                .baseUrl(urlProvider.getBaseUrl2())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }


    @AppScope
    @Provides
    fun baseUrlProvider() = UrlProvider()

    @Provides
    @AppScope
    fun stackOverflowApi(@Retrofit1 retrofit: Retrofit): StackoverflowApi = retrofit.create(StackoverflowApi::class.java)

    @Provides
    fun application() = application
}