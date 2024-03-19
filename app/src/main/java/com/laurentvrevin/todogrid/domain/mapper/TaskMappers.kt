package com.laurentvrevin.todogrid.domain.mapper

import com.laurentvrevin.todogrid.data.entities.TaskEntity
import com.laurentvrevin.todogrid.domain.models.Task

fun TaskEntity.toDomainModel(): Task = Task(
id = id,
title = title,
description = description,
createDate = createDate,
deadline = deadline,
status = status,
priority = priority,
order = order
)

fun Task.toEntity(): TaskEntity = TaskEntity(
    id = id,
    title = title,
    description = description,
    createDate = createDate,
    deadline = deadline,
    status = status,
    priority = priority,
    order = order
)