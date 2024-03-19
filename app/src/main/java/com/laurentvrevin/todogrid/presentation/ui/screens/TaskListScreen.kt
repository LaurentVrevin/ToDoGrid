package com.laurentvrevin.todogrid.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.laurentvrevin.todogrid.domain.models.Task
import com.laurentvrevin.todogrid.domain.models.TaskPriority
import com.laurentvrevin.todogrid.domain.models.TaskStatus
import com.laurentvrevin.todogrid.presentation.ui.components.TaskCard
import com.laurentvrevin.todogrid.presentation.ui.theme.ToDoGridTheme
import com.laurentvrevin.todogrid.presentation.viewmodels.TaskViewModel
import java.util.Date

@Composable
fun TaskListScreen(
    taskViewModel: TaskViewModel,
    onTaskClick: (Task) -> Unit
) {
    val tasks by taskViewModel.tasks.collectAsState(initial = emptyList())

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalItemSpacing = 16.dp
    ) {
        items(tasks) { task ->
            TaskCard(task = task, onTaskClick = onTaskClick)
        }
    }

}
@Preview (showBackground = true)
@Composable
fun TaskListScreenPreview() {
    val fakeTasks = listOf(
        Task(id = 1, title = "Apprendre Jetpack Compose", description = "Regarder des tutoriels sur YouTube", deadline = Date(), createDate = Date(), status = TaskStatus.DONE, priority = TaskPriority.HIGH),
        Task(id = 2, title = "Faire les courses", description = "Acheter des légumes et des fruits", deadline = Date(), createDate = Date(), status = TaskStatus.DONE, priority = TaskPriority.MEDIUM),
        Task(id = 2, title = "Faire les courses", description = "Acheter des légumes et des fruits", deadline = Date(), createDate = Date(), status = TaskStatus.DONE, priority = TaskPriority.MEDIUM),
        Task(id = 2, title = "Manger quelque chose de bon", description = "Acheter des légumes et des fruits", deadline = Date(), createDate = Date(), status = TaskStatus.DONE, priority = TaskPriority.MEDIUM)
    )
    ToDoGridTheme {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalItemSpacing = 16.dp
       ) {
           items(fakeTasks) { task ->
               TaskCard(task = task, onTaskClick = { /* Simule un clic */ })
           }
       }
    }
}