package com.tirexmurina.nonpatternapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tirexmurina.nonpatternapp.data.remote.ProductModel
import com.tirexmurina.nonpatternapp.domain.usecase.IGetProductsUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getProductsUseCase: IGetProductsUseCase
) : ViewModel() {

    lateinit var content : List<ProductModel>

    fun loadData(){
        viewModelScope.launch {
            try {
                val products = getProductsUseCase()
                content = products
            } catch (e: Exception){
                Log.d("AAA", e.message.toString())
            }
        }

    }

}