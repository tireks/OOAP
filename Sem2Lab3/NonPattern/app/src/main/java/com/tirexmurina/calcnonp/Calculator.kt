package com.tirexmurina.calcnonp

class Calculator () {
    fun calculatePlus(num1: Double, num2: Double): Double {
        return num1 + num2
    }

    fun calculateMinus(num1: Double, num2: Double): Double {
        return num1 - num2
    }

    fun calculateMulti(num1: Double, num2: Double): Double {
        return num1 * num2
    }

    fun calculateDiv(num1: Double, num2: Double): Double {
        if (num2 != 0.0) {
            return num1 / num2
        } else {
            throw IllegalArgumentException("Division by zero")
        }
    }
}