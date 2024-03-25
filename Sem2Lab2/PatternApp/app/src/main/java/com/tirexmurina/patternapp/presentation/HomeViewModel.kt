package com.tirexmurina.patternapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tirexmurina.patternapp.domain.usecase.IGetProductsUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getProductsUseCase: IGetProductsUseCase
) : ViewModel() {

    private val _state = MutableLiveData<HomeState>(HomeState.Initial)
    val state : LiveData<HomeState> = _state

    fun loadData(){
        viewModelScope.launch{
            try {
                val products = getProductsUseCase()
                _state.value = HomeState.Content(products)
            } catch (e: Exception){
                Log.d("AAA", e.message.toString())
            }
        }
    }

}