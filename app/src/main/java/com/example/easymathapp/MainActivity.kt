package com.example.easymathapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.easymathapp.ui.theme.EasyMathAppTheme
import com.example.easymathapp.view.Calculator
import com.example.easymathapp.viewmodel.CalculatorViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EasyMathAppTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp
                val isCalculated = viewModel.isCalculated
                val lastExpression = viewModel.lastExpression

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                ) {
                    Calculator(
                        state = state,
                        buttonSpacing = buttonSpacing,
                        isCalculated = isCalculated,
                        lastExpression = lastExpression,
                        onAction = { action, value ->
                            viewModel.handleAction(action, value)
                        }
                    )
                }
            }
        }
    }
}