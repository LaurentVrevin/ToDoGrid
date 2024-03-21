package com.laurentvrevin.todogrid.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.laurentvrevin.todogrid.domain.models.TaskPriority

@Composable
fun PriorityButton(
    text: String, isSelected: Boolean, onSelected: () -> Unit
) {
    OutlinedButton(
        onClick = { onSelected() }, colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
            contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.height(40.dp),
        border = ButtonDefaults.outlinedButtonBorder.copy(brush = SolidColor(Color.Transparent))
    ){
        Text(text)
    }
}

@Composable
fun PrioritySelector(priority: TaskPriority, onPrioritySelected: (TaskPriority) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        DoodleBorderBox() {
            PriorityButton("Low", priority == TaskPriority.LOW) {
                onPrioritySelected(TaskPriority.LOW)
            }
        }

        DoodleBorderBox() {
            PriorityButton("Medium", priority == TaskPriority.MEDIUM) {
                onPrioritySelected(TaskPriority.MEDIUM)
            }
        }
        DoodleBorderBox() {
            PriorityButton("High", priority == TaskPriority.HIGH) {
                onPrioritySelected(TaskPriority.HIGH)
            }
        }


    }
}