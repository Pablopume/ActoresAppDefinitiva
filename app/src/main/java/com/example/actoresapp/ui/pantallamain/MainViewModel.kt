package com.example.actoresapp.ui.pantallamain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.actoresapp.domain.modelo.Actores
import com.example.actoresapp.domain.usecases.AddActorUseCase
import com.example.actoresapp.domain.usecases.DeleteActorUseCase
import com.example.actoresapp.domain.usecases.GetActorAnteriorUseCase
import com.example.actoresapp.domain.usecases.GetActorIdUseCase
import com.example.actoresapp.domain.usecases.GetActorSiguienteUseCase
import com.example.actoresapp.domain.usecases.GetActoresUseCase
import com.example.actoresapp.domain.usecases.UpdateActorUseCase
import com.example.actoresapp.utils.StringProvider
import com.example.namespace.R

class MainViewModel(
    private val addActoruseCase: AddActorUseCase,
    private val deleteActorUseCase: DeleteActorUseCase,
    private val getActoresUseCase: GetActoresUseCase,
    private val getActorIdUseCase: GetActorIdUseCase,
    private val updateActorUseCase: UpdateActorUseCase,
    private val stringProvider: StringProvider,
    private val getActorSiguienteUseCase: GetActorSiguienteUseCase,
    private val getActorAnteriorUseCase: GetActorAnteriorUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData(MainState())
    val uiState: LiveData<MainState> get() = _uiState

    init {
        _uiState.value = MainState(
            actores = _uiState.value.let { getActorIdUseCase(0) },
            error = null
        )
    }

    fun deleteActor() {
        if (!deleteActorUseCase(_uiState.value?.actores!!)) {
            _uiState.value = MainState(
                error = stringProvider.getString(R.string.app_name)
            )

        }else{
            _uiState.value=MainState(actores = getActorIdUseCase(0))
        }
    }

    fun addActor(actor: Actores) {
        if (!addActoruseCase(actor)) {
            _uiState.value = MainState(
                actores = _uiState.value!!.actores,
                error = stringProvider.getString(R.string.app_name)
            )
        }
    }
    fun getActorAnterior(){
        val actor2: Actores=_uiState.value!!.actores
        _uiState.value=MainState(actores = getActorAnteriorUseCase(actor2),
            error = null)
    }
    fun getActorSiguiente(){
        val actor2: Actores= _uiState.value!!.actores
        _uiState.value= MainState(actores= getActorSiguienteUseCase(actor2),
            error = null)
    }
    fun errorMostrado() {
        _uiState.value = _uiState.value?.copy(error = null)
    }
    fun updateActor(actor: Actores) {
        updateActorUseCase(_uiState.value!!.actores, actor)
    }


}
class MainViewModelFactory(
    private val addActoruseCase: AddActorUseCase,
    private val deleteActorUseCase: DeleteActorUseCase,
    private val getActoresUseCase: GetActoresUseCase,
    private val getActorIdUseCase: GetActorIdUseCase,
    private val updateActorUseCase: UpdateActorUseCase,
    private val stringProvider: StringProvider,
    private val getActorSiguienteUseCase: GetActorSiguienteUseCase,
    private val getActorAnteriorUseCase: GetActorAnteriorUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                addActoruseCase,
                deleteActorUseCase,
                getActoresUseCase,
                getActorIdUseCase,
                updateActorUseCase,
                stringProvider,
                getActorSiguienteUseCase,
                getActorAnteriorUseCase

            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}