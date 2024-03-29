package com.example.actoresapp.ui.pantallamain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.actoresapp.domain.modelo.Actores
import com.example.actoresapp.domain.usecases.AddActorUseCase
import com.example.actoresapp.domain.usecases.DeleteActorUseCase
import com.example.actoresapp.domain.usecases.DeshabilitarBotonesUseCase
import com.example.actoresapp.domain.usecases.GetActorIdUseCase
import com.example.actoresapp.domain.usecases.GetActoresUseCase
import com.example.actoresapp.domain.usecases.UpdateActorUseCase
import com.example.actoresapp.utils.StringProvider
import com.example.namespace.R
import com.example.namespace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(
            AddActorUseCase(),
            DeleteActorUseCase(),
            GetActoresUseCase(),
            GetActorIdUseCase(),
            UpdateActorUseCase(),
            StringProvider(this),
            DeshabilitarBotonesUseCase(),
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }
        viewModel.deshabilitarBotones()
        observeViewModel()
        metodos()
        observeViewModel()
    }

    private fun metodos() {
        with(binding) {
            nextButton.setOnClickListener {
                viewModel.getActorSiguiente()
                viewModel.deshabilitarBotones()

            }
            beforeButton.setOnClickListener {
                viewModel.getActorAnterior()
                viewModel.deshabilitarBotones()

            }
            imageButtonBin.setOnClickListener {
                viewModel.deleteActor()
                viewModel.deshabilitarBotones()

            }
            addButton.setOnClickListener {
                if (textName.text.isNullOrEmpty() || peliculaFam.text.isNullOrEmpty()) {
                    Toast.makeText(
                        this@MainActivity,
                        Constantes.RELLENA,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val name: String = textName.text.toString()
                    val slide: Int = slider2.value.toInt()
                    var genero: String = ""
                    when (radioGroup.checkedRadioButtonId) {
                        radioButtonHombre.id -> genero = radioButtonHombre.text.toString()
                        radioButtonMujer.id -> genero = radioButtonMujer.text.toString()
                        radioButtonOtro.id -> genero = radioButtonOtro.text.toString()
                    }
                    val vivo: Boolean = checkBox.isChecked
                    val peli: String = peliculaFam.text.toString()
                    var actor = Actores(name, vivo, peli, slide, genero)
                    viewModel.addActor(actor)
                    viewModel.deshabilitarBotones()
                }
            }
            updateButton.setOnClickListener {
                val name: String = textName.text.toString()
                val slide: Int = slider2.value.toInt()
                var genero: String = ""
                when (radioGroup.checkedRadioButtonId) {
                    radioButtonHombre.id -> genero = radioButtonHombre.text.toString()
                    radioButtonMujer.id -> genero = radioButtonMujer.text.toString()
                    radioButtonOtro.id -> genero = radioButtonOtro.text.toString()
                }
                val vivo: Boolean = checkBox.isChecked
                val peli: String = peliculaFam.text.toString()
                var actor = Actores(name, vivo, peli, slide, genero)
                viewModel.updateActor(actor)
                viewModel.deshabilitarBotones()
            }
        }

    }

    private fun observeViewModel() {
        viewModel.uiState.observe(this@MainActivity) { state ->
            state.error?.let { error ->
                Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()
                viewModel.errorMostrado()
            }

            if (state.error == null) {

                with(binding) {

                    textName.setText(state.actores.nombre)
                    if (state.botonIzquierda == false) {
                        beforeButton.isVisible = false
                    } else {
                        if (state.botonDerecha == false) {
                            nextButton.isVisible = false
                        } else {
                            beforeButton.isVisible = true
                            nextButton.isVisible = true
                        }
                    }

                    when (state.actores.genero) {
                        radioButtonHombre.text -> radioButtonHombre.isChecked = true
                        radioButtonMujer.text -> radioButtonMujer.isChecked = true
                        radioButtonOtro.text -> radioButtonOtro.isChecked = true
                    }
                    slider2.value = state.actores.premiosOscar.toFloat()
                    checkBox.isChecked = state.actores.vivo
                    peliculaFam.setText(state.actores.peliculaFamosa)
                }

            }

        }
    }
}