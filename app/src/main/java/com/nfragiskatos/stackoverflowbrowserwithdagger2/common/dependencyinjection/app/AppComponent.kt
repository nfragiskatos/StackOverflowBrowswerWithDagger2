package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.app

import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.activity.ActivityComponent
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.activity.ActivityModule
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.service.ServiceComponent
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.service.ServiceModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent

    fun newServiceComponent(serviceModule: ServiceModule): ServiceComponent
}