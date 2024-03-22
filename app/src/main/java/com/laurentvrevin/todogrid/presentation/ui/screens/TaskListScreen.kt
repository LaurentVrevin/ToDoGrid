package com.laurentvrevin.todogrid.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.laurentvrevin.todogrid.R
import com.laurentvrevin.todogrid.domain.models.Task
import com.laurentvrevin.todogrid.domain.models.TaskPriority
import com.laurentvrevin.todogrid.domain.models.TaskStatus
import com.laurentvrevin.todogrid.presentation.ui.components.AddTaskFAB
import com.laurentvrevin.todogrid.presentation.ui.components.TaskCard
import com.laurentvrevin.todogrid.presentation.ui.theme.Pink80
import com.laurentvrevin.todogrid.presentation.ui.theme.Purple40
import com.laurentvrevin.todogrid.presentation.ui.theme.Purple80
import com.laurentvrevin.todogrid.presentation.ui.theme.PurpleGrey80
import com.laurentvrevin.todogrid.presentation.ui.theme.ToDoGridTheme
import com.laurentvrevin.todogrid.presentation.viewmodels.TaskViewModel
import java.util.Date

@SuppressLint("SuspiciousIndentation")
@Composable
fun TaskListScreen(
    taskViewModel: TaskViewModel,
    navController: NavController
) {
    val tasks by taskViewModel.tasks.collectAsState(initial = emptyList())

    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bentask_header_image),
            contentDescription = "En-tête",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .size(150.dp, 150.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalItemSpacing = 4.dp
            ) {
                itemsIndexed(tasks) { index, task ->
                    val backgroundColor = when (index % 4) {
                        0 -> Purple80
                        1 -> Pink80
                        2 -> Purple40
                        3 -> PurpleGrey80
                        else -> MaterialTheme.colorScheme.secondary
                    }
                    TaskCard(task = task, backgroundColor = backgroundColor) {
                        navController.navigate("taskDetail/${task.id}")
                    }
                }
            }
            AddTaskFAB(
                onClick = {
                    navController.navigate("taskForm/-1")
                },
                modifier = Modifier
                    .padding(24.dp)
                    .align(Alignment.BottomEnd)
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun TaskListScreenPreview() {
    val fakeTasks = listOf(
        Task(
            id = 1,
            title = "Apprendre Jetpack Compose",
            description = "Regarder des tutoriels sur YouTube",
            deadline = Date(),
            createDate = Date(),
            status = TaskStatus.DONE,
            priority = TaskPriority.HIGH
        ),
        Task(
            id = 2,
            title = "Faire les courses",
            description = "Acheter des légumes et des fruits",
            deadline = Date(),
            createDate = Date(),
            status = TaskStatus.DONE,
            priority = TaskPriority.MEDIUM
        ),
        Task(
            id = 2,
            title = "Manger quelque chose de bon",
            description = "Acheter des légumes et des fruits",
            deadline = Date(),
            createDate = Date(),
            status = TaskStatus.DONE,
            priority = TaskPriority.MEDIUM
        ),
        Task(
            id = 2,
            title = "Faire les courses",
            description = "Acheter des légumes et des fruits",
            deadline = Date(),
            createDate = Date(),
            status = TaskStatus.DONE,
            priority = TaskPriority.MEDIUM
        )
    )
    ToDoGridTheme {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.spacedBy(1.dp),
            verticalItemSpacing = 8.dp
        ) {
            items(fakeTasks) { task ->
                TaskCard(task = task) {}
            }
        }
    }
}