package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.app

import android.app.Application
import com.nfragiskatos.stackoverflowbrowserwithdagger2.Constants
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.Retrofit1
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.Retrofit2
import com.nfragiskatos.stackoverflowbrowserwithdagger2.networking.StackoverflowApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class AppModule(val application: Application) {

    @Provides
    @AppScope
    @Named("retrofit1")
    fun retrofit1(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @AppScope
    @Named("retrofit2")
    fun retrofit2(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @AppScope
    fun stackOverflowApi(@Named("retrofit1") retrofit: Retrofit): StackoverflowApi = retrofit.create(StackoverflowApi::class.java)

    @Provides
    fun application() = application
}