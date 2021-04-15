package com.nfragiskatos.stackoverflowbrowserwithdagger2.screens.common.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

abstract class SavedStateViewModel : ViewModel() {

    abstract fun init(savedStateHandle: SavedStateHandle)
}