package com.laurentvrevin.todogrid.presentation.ui.components

import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun DatePickerButton(selectedDate: String, onDateSelected: (String) -> Unit) {
    val context = LocalContext.current
    val dateFormatter = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }

    TextButton(onClick = {
        showDatePicker(context = context, dateFormatter = dateFormatter) { date ->
            onDateSelected(date)
        }
    }) {
        Text(text = "Choisir la date: $selectedDate")
    }
}

fun showDatePicker(context: Context, dateFormatter: SimpleDateFormat, onDateChosen: (String) -> Unit) {
    val calendar = Calendar.getInstance()
    DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            calendar.set(year, month, dayOfMonth)
            onDateChosen(dateFormatter.format(calendar.time))
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    ).show()
}