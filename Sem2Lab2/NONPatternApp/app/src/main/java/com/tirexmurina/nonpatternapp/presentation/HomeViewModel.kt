package com.tirexmurina.nonpatternapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tirexmurina.nonpatternapp.data.remote.ProductModel
import com.tirexmurina.nonpatternapp.domain.usecase.IGetProductsUseCase
import com.tirexmurina.nonpatternapp.presentation.screen.HomeState
import kotlinx.coroutines.async
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