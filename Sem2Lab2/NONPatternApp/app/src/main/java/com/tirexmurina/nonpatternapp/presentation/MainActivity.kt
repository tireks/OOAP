package com.tirexmurina.nonpatternapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.tirexmurina.nonpatternapp.R
import com.tirexmurina.nonpatternapp.data.ProductRepositoryImpl
import com.tirexmurina.nonpatternapp.domain.repository.ProductRepository

class MainActivity : AppCompatActivity() {

    val repository: ProductRepository = ProductRepositoryImpl()
    private val navController get() = findNavController(R.id.mainDataContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}