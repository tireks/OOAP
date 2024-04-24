package com.tirexmurina.calcnonp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tirexmurina.calcnonp.databinding.ActivityMainBinding
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var calculator: Calculator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculator = Calculator()

        binding.buttonPlus.setOnClickListener {
            calculate(PLUS)
        }

        binding.buttonMinus.setOnClickListener {
            calculate(MINUS)
        }

        binding.buttonMulty.setOnClickListener {
            calculate(MULTIPLY)
        }

        binding.buttonDivide.setOnClickListener {
            calculate(DIVIDE)
        }


    }

    private fun calculate(operation: String) {
        val num1 = binding.leftNum.text.toString().toDouble()
        val num2 = binding.rightNum.text.toString().toDouble()
        var result = 0.0
        when(operation){
            PLUS -> {
                result = calculator.calculatePlus(num1, num2)
            }
            MINUS -> {
                result = calculator.calculateMinus(num1, num2)
            }
            MULTIPLY -> {
                result = calculator.calculateMulti(num1, num2)
            }
            DIVIDE -> {
                result = calculator.calculateDiv(num1, num2)
            }
            else -> {
                throw IllegalArgumentException("Operation problem")
            }
        }
        binding.resiltTV.text = (round(result * 100) / 100).toString() // Округление до двух знаков после запятой
    }

    companion object {
        const val PLUS = "+"
        const val MINUS = "-"
        const val MULTIPLY = "*"
        const val DIVIDE = "/"
    }
}