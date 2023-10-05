package com.example.actoresapp.ui.pantallamain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.actoresapp.domain.usecases.AddActorUseCase
import com.example.actoresapp.domain.usecases.DeleteActorUseCase
import com.example.actoresapp.domain.usecases.GetActorUseCase
import com.example.actoresapp.domain.usecases.UpdateActorUseCase

class MainViewModel(
    private val addActoruseCase: AddActorUseCase,
    private val deleteActorUseCase: DeleteActorUseCase,
    private val getActorUseCase: GetActorUseCase,
    private val updateActorUseCase: UpdateActorUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData(MainState())
        val uiState: LiveData<MainState> get()=_uiState

        fun addActor
}