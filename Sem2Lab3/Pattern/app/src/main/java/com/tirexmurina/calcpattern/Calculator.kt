package com.tirexmurina.calcpattern

class Calculator (private var strategy: CalculationStrategy) {

    fun setStrategy(strategy: CalculationStrategy) {
        this.strategy = strategy
    }

    fun calculate(num1: Double, num2: Double): Double {
        return strategy.calculate(num1, num2)
    }
}