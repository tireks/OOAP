package com.tirexmurina.calcpattern

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tirexmurina.calcpattern.databinding.ActivityMainBinding
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var calculator: Calculator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculator = Calculator(AdditionStrategy())

        binding.buttonPlus.setOnClickListener {
            calculate(AdditionStrategy())
        }

        binding.buttonMinus.setOnClickListener {
            calculate(SubtractionStrategy())
        }

        binding.buttonMulty.setOnClickListener {
            calculate(MultiplicationStrategy())
        }

        binding.buttonDivide.setOnClickListener {
            calculate(DivisionStrategy())
        }

    }

    private fun calculate(strategy: CalculationStrategy) {
        val num1 = binding.leftNum.text.toString().toDouble()
        val num2 = binding.rightNum.text.toString().toDouble()
        calculator.setStrategy(strategy)
        val result = calculator.calculate(num1, num2)
        binding.resiltTV.text = (round(result * 100) / 100).toString() // Округление до двух знаков после запятой
    }
}