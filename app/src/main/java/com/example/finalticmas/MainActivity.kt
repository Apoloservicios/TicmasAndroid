package com.example.finalticmas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalticmas.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import com.example.finalticmas.ui.theme.FinalTicmasTheme


class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparar.observe(this){
            println("recibimos unvalor.$it")
            binding.Textoresultado.text = "${it.resultado}"
        }

        binding.button2.setOnClickListener{
            var cadena1 = binding.Texto1.text.toString()
            var cadena2 = binding.Texto2.text.toString()
            mainViewModel.Compararcadena(cadena1,cadena2)


            if (binding.Texto1.text.toString() == binding.Texto2.text.toString()) {

                binding.prueba.text = "Iguales"


            } else {
                binding.prueba.text = "Diferentes"
            }
        }

    }
}

