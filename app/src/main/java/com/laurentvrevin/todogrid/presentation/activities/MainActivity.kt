package com.laurentvrevin.todogrid.presentation.activities

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.laurentvrevin.todogrid.presentation.ui.navigate.AppNavigation
import com.laurentvrevin.todogrid.presentation.ui.theme.ToDoGridTheme
import com.laurentvrevin.todogrid.presentation.viewmodels.TaskViewModel
import com.laurentvrevin.todogrid.utils.setupFullScreenSplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Install SplashScreen
        setupFullScreenSplashScreen()

        setContent {
            ToDoGridTheme {
                val taskViewModel: TaskViewModel = hiltViewModel()
                //NavController
                AppNavigation(taskViewModel = taskViewModel)
            }
        }
    }
}
