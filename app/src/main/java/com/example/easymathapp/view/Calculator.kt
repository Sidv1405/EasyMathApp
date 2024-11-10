package com.example.easymathapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.easymathapp.model.CalculatorAction
import com.example.easymathapp.model.CalculatorState
import com.example.easymathapp.view.components.ButtonComponent

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp,
    modifier: Modifier = Modifier,
    onAction: (CalculatorAction, String?) -> Unit,
    isCalculated: Boolean,
    lastExpression: String

) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = lastExpression,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp,
                color = Color.Gray, // Màu xám nhỏ
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = state.number1 + (state.operation ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp)
                    .height(100.dp) // Cố định chiều cao của text
                    .background(Color.Black),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis // Ẩn phần văn bản vượt quá giới hạn
            )


            // Hàng 1
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                ButtonComponent(symbol = "AC",
                    modifier = Modifier
                        .background(Color(0xFF818181))
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.CLEAR, null)
                    })
                ButtonComponent(symbol = "Del",
                    modifier = Modifier
                        .background(Color(0xFF818181))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.DELETE, null)
                    })
                ButtonComponent(symbol = "/",
                    modifier = Modifier
                        .background(Color(0xFFFF9800))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.OPERATION_DIVIDE, "/")
                    })
            }

            // Hàng 2
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                ButtonComponent(symbol = "7",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.NUMBER, "7")
                    }
                )
                ButtonComponent(symbol = "8",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.NUMBER, "8")
                    }
                )
                ButtonComponent(symbol = "9",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.NUMBER, "9")
                    }
                )
                ButtonComponent(symbol = "x",
                    modifier = Modifier
                        .background(Color(0xFFFF9800))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.OPERATION_MULTIPLY, "x")
                    })
            }

            // Hàng 3
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                ButtonComponent(symbol = "4",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.NUMBER, "4")
                    }
                )
                ButtonComponent(symbol = "5",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.NUMBER, "5")
                    }
                )
                ButtonComponent(symbol = "6",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.NUMBER, "6")
                    }
                )
                ButtonComponent(symbol = "-",
                    modifier = Modifier
                        .background(Color(0xFFFF9800))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.OPERATION_SUBTRACT, "-")
                    })
            }

            // Hàng 4
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                ButtonComponent(symbol = "1",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.NUMBER, "1")
                    }
                )
                ButtonComponent(symbol = "2",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.NUMBER, "2")
                    }
                )
                ButtonComponent(symbol = "3",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.NUMBER, "3")
                    }
                )
                ButtonComponent(symbol = "+",
                    modifier = Modifier
                        .background(Color(0xFFFF9800))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.OPERATION_ADD, "+")
                    })
            }

            // Hàng 5
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                ButtonComponent(symbol = "0",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.NUMBER, "0")
                    })
                ButtonComponent(symbol = ".",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.DECIMAL, ".")
                    })
                ButtonComponent(symbol = "=",
                    modifier = Modifier
                        .background(Color(0xFFFF9800))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.CALCULATE, null)
                    })
            }
            Spacer(modifier = Modifier.weight(0.2f))

        }
    }
}













