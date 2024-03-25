package com.tirexmurina.patternapp.presentation.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.GridLayoutManager
import com.tirexmurina.nonpatternapp.utils.mainActivity
import com.tirexmurina.patternapp.R
import com.tirexmurina.patternapp.databinding.FragmentHomeBinding
import com.tirexmurina.patternapp.domain.repository.entity.Product
import com.tirexmurina.patternapp.domain.usecase.GetProductsUseCase
import com.tirexmurina.patternapp.presentation.BaseFragment
import com.tirexmurina.patternapp.presentation.HomeState
import com.tirexmurina.patternapp.presentation.HomeViewModel
import com.tirexmurina.patternapp.presentation.adapters.HomeAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    private val viewModel: HomeViewModel by viewModels {
        viewModelFactory {
            initializer {
                HomeViewModel(GetProductsUseCase(mainActivity.repository))
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainCatalogList.adapter = HomeAdapter()
        binding.mainCatalogList.layoutManager = GridLayoutManager(context,2)
        viewModel.state.observe(viewLifecycleOwner, ::handleState)
        viewModel.loadData()
    }

    private fun handleState(homeState: HomeState) {
        when(homeState){
            is HomeState.Content -> {
                populateData(homeState.items)
            }
            is HomeState.Initial -> {

            }
        }
    }

    private fun populateData(items: List<Product>) {
        (binding.mainCatalogList.adapter as? HomeAdapter)?.products = items
    }


}