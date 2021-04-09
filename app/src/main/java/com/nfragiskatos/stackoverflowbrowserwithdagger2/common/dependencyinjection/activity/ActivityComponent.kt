package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.app.AppComponent
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.presentation.PresentationComponent
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.presentation.PresentationModule
import com.nfragiskatos.stackoverflowbrowserwithdagger2.networking.StackoverflowApi
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.ScreensNavigator
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

   fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent
}