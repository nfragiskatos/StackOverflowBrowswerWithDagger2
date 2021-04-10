package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.service

import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.presentation.PresentationComponent
import dagger.Subcomponent


@Subcomponent(modules = [ServiceModule::class])
interface ServiceComponent {

}