package com.tirexmurina.nonpatternapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tirexmurina.nonpatternapp.R
import com.tirexmurina.nonpatternapp.data.ProductRepositoryImpl
import com.tirexmurina.nonpatternapp.domain.repository.ProductRepository

class MainActivity : AppCompatActivity() {

    val repository: ProductRepository = ProductRepositoryImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}