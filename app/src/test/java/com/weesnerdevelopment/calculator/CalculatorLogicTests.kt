package com.weesnerdevelopment.calculator

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.math.BigDecimal

class CalculatorLogicTests {
    @Test
    fun intAddWorks() {
        assertThat(Operation(Operator.PLUS, 2, 2).answer).isEqualTo(BigDecimal("4"))
    }

    @Test
    fun doubleAddWorks() {
        assertThat(Operation(Operator.PLUS, 2.2, 2.5).answer).isEqualTo(BigDecimal("4.7"))
    }

    @Test
    fun doubleAndIntAddWorks() {
        assertThat(Operation(Operator.PLUS, 2, 2.5).answer).isEqualTo(BigDecimal("4.5"))
    }

    @Test
    fun intSubtractWorks() {
        assertThat(Operation(Operator.MINUS, 2, 2).answer).isEqualTo(BigDecimal("0"))
    }

    @Test
    fun doubleSubtractWorks() {
        assertThat(Operation(Operator.MINUS, 2.2, .5).answer).isEqualTo(BigDecimal("1.7"))
    }

    @Test
    fun doubleAndIntSubtractWorks() {
        assertThat(Operation(Operator.MINUS, 2, 2.5).answer).isEqualTo(BigDecimal("-.5"))
    }

    @Test
    fun intMultiplyWorks() {
        assertThat(Operation(Operator.MULTIPLY, 2, 2).answer).isEqualTo(BigDecimal("4"))
    }

    @Test
    fun doubleMultiplyWorks() {
        assertThat(Operation(Operator.MULTIPLY, 2.2, 2.5).answer).isEqualTo(BigDecimal("5.50"))
    }

    @Test
    fun doubleAndIntMultiplyWorks() {
        assertThat(Operation(Operator.MULTIPLY, 2, 2.5).answer).isEqualTo(BigDecimal("5.0"))
    }

    @Test
    fun intDivideWorks() {
        assertThat(Operation(Operator.DIVIDE, 2, 2).answer).isEqualTo(BigDecimal("1"))
    }

    @Test
    fun doubleDivideWorks() {
        assertThat(Operation(Operator.DIVIDE, 2.2, 2.5).answer).isEqualTo(BigDecimal(".88"))
    }

    @Test
    fun doubleAndIntDivideWorks() {
        assertThat(Operation(Operator.DIVIDE, 2.5, 2).answer).isEqualTo(BigDecimal("1.25"))
    }

    @Test
    fun stringAddition() {
        val formula = "2*2"
        assertThat(Operation(formula).answer).isEqualTo(BigDecimal("4"))
    }

    @Test
    fun verifyOperatorIsntThere(){
        val formula = "20"
        assertThat(formula.contains(Regex("(?=[/*+-])|(?<=[/*+-])"))).isFalse()
    }

    @Test
    fun verifyOperatorIsThere(){
        val formula = "20*2"
        assertThat(formula.contains(Regex("(?=[/*+-])|(?<=[/*+-])"))).isTrue()
    }
}