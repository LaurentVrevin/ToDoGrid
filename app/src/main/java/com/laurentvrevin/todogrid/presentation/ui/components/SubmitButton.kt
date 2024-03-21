package com.laurentvrevin.todogrid.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SubmitButton(
    modifier: Modifier = Modifier,
    isUpdating: Boolean,
    onSubmit: () -> Unit
) {
    Button(
        onClick = { onSubmit() },
        modifier = modifier
    ) {
        Text(text = if (isUpdating) "Mettre à jour" else "Ajouter")
    }
}