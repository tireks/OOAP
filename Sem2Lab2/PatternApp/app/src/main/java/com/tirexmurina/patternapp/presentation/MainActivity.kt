package com.tirexmurina.patternapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.tirexmurina.patternapp.R
import com.tirexmurina.patternapp.data.ProductRepositoryImpl
import com.tirexmurina.patternapp.domain.repository.ProductRepository

class MainActivity : AppCompatActivity() {

    val repository: ProductRepository = ProductRepositoryImpl()
    private val navController get() = findNavController(R.id.mainDataContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}