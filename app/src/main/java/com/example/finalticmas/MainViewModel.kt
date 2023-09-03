package com.example.finalticmas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch



class MainViewModel:ViewModel() {


     private val _comparar = MutableLiveData<Comparar>()
     val comparar: LiveData<Comparar>get() = _comparar

    fun Compararcadena( valor1: String, valor2: String) {
        viewModelScope.launch{
            var next: String
            if (valor1.equals(valor2)) {
                next = "Iguales"

                updatecomparcion(next)
            } else {
                next  = "Diferentes"
                updatecomparcion(next)
            }

        }


    }

   private fun updatecomparcion (next: String) {
        viewModelScope.launch {
            _comparar.value = Comparar("","","${next}")
        }

    }





}