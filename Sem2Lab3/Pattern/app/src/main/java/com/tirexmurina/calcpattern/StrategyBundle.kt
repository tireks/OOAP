package com.tirexmurina.calcpattern

class AdditionStrategy : CalculationStrategy {
    override fun calculate(num1: Double, num2: Double): Double {
        return num1 + num2
    }
}

class SubtractionStrategy : CalculationStrategy {
    override fun calculate(num1: Double, num2: Double): Double {
        return num1 - num2
    }
}

class MultiplicationStrategy : CalculationStrategy {
    override fun calculate(num1: Double, num2: Double): Double {
        return num1 * num2
    }
}

class DivisionStrategy : CalculationStrategy {
    override fun calculate(num1: Double, num2: Double): Double {
        if (num2 != 0.0) {
            return num1 / num2
        } else {
            throw IllegalArgumentException("Division by zero")
        }
    }
}