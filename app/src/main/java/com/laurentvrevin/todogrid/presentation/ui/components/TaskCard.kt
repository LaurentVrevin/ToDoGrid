package com.laurentvrevin.todogrid.presentation.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.laurentvrevin.todogrid.domain.models.Task
import com.laurentvrevin.todogrid.domain.models.TaskPriority
import com.laurentvrevin.todogrid.domain.models.TaskStatus
import java.util.Date

@SuppressLint("SimpleDateFormat")
@Composable
fun TaskCard(
    task: Task,
    onTaskClick: () -> Unit,
){
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable(onClick = onTaskClick)
    ) {
        Column(modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            ) {
            Text(
                text = task.title,
                modifier = Modifier
                 .padding(8.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = task.deadline.toString(),
                modifier = Modifier.
                padding(8.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun TaskCardPreview() {
         TaskCard(
            task = Task(
                id = 1,
                title = "Title",
                description = "Description",
                order = 1,
                createDate = Date(),
                deadline = Date(),
                status = TaskStatus.TODO,
                priority = TaskPriority.HIGH

            ),
             onTaskClick = {}
        )
}