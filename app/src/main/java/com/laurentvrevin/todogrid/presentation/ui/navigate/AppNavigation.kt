package com.laurentvrevin.todogrid.presentation.ui.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.laurentvrevin.todogrid.presentation.ui.screens.SplashScreen
import com.laurentvrevin.todogrid.presentation.ui.screens.TaskDetailScreen
import com.laurentvrevin.todogrid.presentation.ui.screens.TaskFormScreen
import com.laurentvrevin.todogrid.presentation.ui.screens.TaskListScreen
import com.laurentvrevin.todogrid.presentation.viewmodels.TaskViewModel

@Composable
fun AppNavigation(taskViewModel: TaskViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splashScreen"
    ) {
        composable(
            "splashScreen"
        ) {
            SplashScreen(
                navController
            )
        }
        composable(
            "taskList"
        ) {
            TaskListScreen(
                taskViewModel,
                navController
            )
        }
        composable(
            "taskDetail/{taskId}",
            arguments = listOf(navArgument("taskId")
            {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt("taskId")
                ?.let {
                    TaskDetailScreen(
                        taskId = it,
                        onEditTask = {},
                        onDeleteTask = {},
                        taskViewModel = taskViewModel,
                        navController = navController
                    )
                }
        }
        composable(
            "taskForm/{taskId}",
            arguments = listOf(navArgument("taskId")
            {
                type = NavType.IntType
                defaultValue = -1
            })
        ) { backStackEntry ->
            TaskFormScreen(
                taskId = backStackEntry.arguments?.getInt("taskId"),
                taskViewModel = taskViewModel,
                navController = navController
            )
        }
    }
}