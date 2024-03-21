package com.laurentvrevin.todogrid.presentation.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PriorityButton(
    text: String,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    OutlinedButton(
        onClick = { onSelected() },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
            contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.height(40.dp)
    ) {
        Text(text)
    }
}