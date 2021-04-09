package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.activity

import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.presentation.PresentationComponent
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.presentation.PresentationModule
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.presentation.UseCasesModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun newPresentationComponent(
            presentationModule: PresentationModule,
            useCasesModule: UseCasesModule
    ): PresentationComponent
}