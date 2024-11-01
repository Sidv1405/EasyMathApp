package com.example.easymathapp.model

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorAction? = null,
)
