package com.example.easymathapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.easymathapp.model.CalculatorAction
import com.example.easymathapp.model.CalculatorState

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set
    var isCalculated by mutableStateOf(false)
    var lastExpression by mutableStateOf("")

    fun handleAction(action: CalculatorAction, value: String? = null) {
        when (action) {
            CalculatorAction.NUMBER -> {
                value?.let {
                    state = if (state.operation == null) {
                        // Chưa có phép toán, cập nhật number1
                        state.copy(number1 = state.number1 + it)
                    } else {
                        // Đã chọn phép toán, cập nhật number2
                        state.copy(number2 = state.number2 + it)
                    }
                }
            }
            CalculatorAction.CLEAR -> {
                // Xóa toàn bộ
                state = CalculatorState()
                isCalculated = false
                lastExpression = "" // Xóa biểu thức khi AC
            }
            CalculatorAction.DELETE -> {
                // Xóa số cuối cùng từ number1 hoặc number2
                state = if (state.operation == null) {
                    state.copy(number1 = state.number1.dropLast(1))
                } else {
                    state.copy(number2 = state.number2.dropLast(1))
                }
            }
            CalculatorAction.OPERATION_ADD -> {
                if (state.operation == null) {
                    state = state.copy(operation = "+")
                }
            }
            CalculatorAction.OPERATION_SUBTRACT -> {
                if (state.operation == null) {
                    state = state.copy(operation = "-")
                }
            }
            CalculatorAction.OPERATION_MULTIPLY -> {
                if (state.operation == null) {
                    state = state.copy(operation = "x")
                }
            }
            CalculatorAction.OPERATION_DIVIDE -> {
                if (state.operation == null) {
                    state = state.copy(operation = "/")
                }
            }
            CalculatorAction.CALCULATE -> {
                val number1 = state.number1.toDoubleOrNull()
                val number2 = state.number2.toDoubleOrNull()
                if (number1 != null && number2 != null) {
                    val result = when (state.operation) {
                        "+" -> number1 + number2
                        "-" -> number1 - number2
                        "x" -> number1 * number2
                        "/" -> number1 / number2
                        else -> return
                    }

                    val formattedResult = if (result % 1.0 == 0.0) {
                        result.toInt().toString()
                    } else {
                        result.toString()
                    }

                    // Lưu lại biểu thức và kết quả
                    lastExpression = "${state.number1} ${state.operation} ${state.number2}"
                    state = state.copy(
                        number1 = formattedResult,
                        number2 = "",
                        operation = null
                    )
                    isCalculated = true
                }
            }

            CalculatorAction.DECIMAL -> {
                if (state.operation == null && !state.number1.contains(".")) {
                    state = state.copy(number1 = state.number1 + ".")
                } else if (!state.number2.contains(".")) {
                    state = state.copy(number2 = state.number2 + ".")
                }
            }
        }
    }
}


