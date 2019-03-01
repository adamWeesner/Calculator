package com.weesnerdevelopment.calculator

import java.math.BigDecimal
import kotlin.Double.Companion.NaN

class Operation(operator: Operator, number1: Number, number2: Number) {
    var answer: Number = NaN

    init {
        val item1 = BigDecimal(number1.toString())
        val item2 = BigDecimal(number2.toString())

        answer = when (operator) {
            Operator.PLUS -> item1.plus(item2)
            Operator.MINUS -> item1.minus(item2)
            Operator.MULTIPLY -> item1.multiply(item2)
            Operator.DIVIDE -> item1.divide(item2)
        }
    }
}

enum class Operator { PLUS, MINUS, DIVIDE, MULTIPLY }
