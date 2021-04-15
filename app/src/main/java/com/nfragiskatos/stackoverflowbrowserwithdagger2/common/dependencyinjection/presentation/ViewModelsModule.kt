package com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.presentation

import androidx.lifecycle.ViewModel
import com.nfragiskatos.stackoverflowbrowserwithdagger2.common.dependencyinjection.ViewModelKey
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.viewmodel.MyViewModel
import com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.viewmodel.MyViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    abstract fun myViewModel(myViewModel: MyViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel2::class)
    abstract fun myViewModel2(myViewModel2: MyViewModel2) : ViewModel
}