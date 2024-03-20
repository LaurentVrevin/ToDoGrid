package com.laurentvrevin.todogrid.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.laurentvrevin.todogrid.presentation.ui.navigate.AppNavigation
import com.laurentvrevin.todogrid.presentation.ui.theme.ToDoGridTheme
import com.laurentvrevin.todogrid.presentation.viewmodels.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoGridTheme {
                val taskViewModel: TaskViewModel = hiltViewModel()
                //NavController
                AppNavigation(taskViewModel = taskViewModel)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToDoGridTheme {
    }
}