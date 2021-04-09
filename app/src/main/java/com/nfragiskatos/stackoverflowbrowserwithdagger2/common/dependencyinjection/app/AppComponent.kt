package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.app

import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.activity.ActivityComponent
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.activity.ActivityModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent

//    fun stackOverflowApi(): StackoverflowApi
//
//    fun application(): Application
}