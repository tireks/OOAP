package com.tirexmurina.nonpatternapp.presentation.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.GridLayoutManager
import com.tirexmurina.nonpatternapp.R
import com.tirexmurina.nonpatternapp.data.remote.ProductModel
import com.tirexmurina.nonpatternapp.databinding.FragmentHomeBinding
import com.tirexmurina.nonpatternapp.domain.usecase.GetProductsUseCase
import com.tirexmurina.nonpatternapp.presentation.BaseFragment
import com.tirexmurina.nonpatternapp.presentation.HomeViewModel
import com.tirexmurina.nonpatternapp.presentation.adapters.HomeAdapter
import com.tirexmurina.nonpatternapp.utils.mainActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async

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

    private fun populateData(content : List<ProductModel>) {
        (binding.mainCatalogList.adapter as? HomeAdapter)?.products = content
    }


}